package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.Database;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.DocumentCollection;
import com.microsoft.azure.documentdb.PartitionKeyDefinition;
import com.microsoft.azure.documentdb.RequestOptions;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class GenerateNYCTaxiData {

	static ResourceBundle rb = ResourceBundle.getBundle("appsettings");

	private static final String END_POINT = rb.getString("EndPointUrl");
	private static final String PRIMARY_KEY = rb.getString("PrimaryKey");
	private static final String DATABASE_ID = rb.getString("Database");
	private static final String COLLECTION_ID = rb.getString("Collection");
	private static final String CSV_FILE_DIR = rb.getString("CsvFileDir");

	// We'll use Gson for POJO <=> JSON serialization for this sample.
	// Codehaus' Jackson is another great POJO <=> JSON serializer.
	private static Gson gson = new Gson();

	public static void main(String[] args) throws DocumentClientException, IOException {

		// Instantiate a DocumentClient w/ your CosmosDB Endpoint and AuthKey.
		DocumentClient documentClient = new DocumentClient(END_POINT, PRIMARY_KEY, ConnectionPolicy.GetDefault(),
				ConsistencyLevel.Session);

		// Start from a clean state (delete database in case it already exists).
		try {
			documentClient.deleteDatabase("dbs/" + DATABASE_ID, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Define a new database using the id above.
		Database myDatabase = new Database();
		myDatabase.setId(DATABASE_ID);

		// Set the provisioned throughput for this collection to be 1000 RUs.
		RequestOptions requestOptions = new RequestOptions();
		requestOptions.setOfferThroughput(1000);

		// Create a new database.
		myDatabase = documentClient.createDatabase(myDatabase, requestOptions).getResource();

		System.out.println("Created a new database:");
		System.out.println(myDatabase.toString());
		System.out.println("Press any key to continue..");
		System.in.read();

		// Define a new collection using the id above.
		PartitionKeyDefinition partitionKeyDef = new PartitionKeyDefinition();
		ArrayList<String> paths = new ArrayList<String>();
		paths.add("/_partitionKey");
		partitionKeyDef.setPaths(paths);

		DocumentCollection myCollection = new DocumentCollection();
		myCollection.setId(COLLECTION_ID);
		myCollection.setPartitionKey(partitionKeyDef);

		// Create a new collection.
		myCollection = documentClient.createCollection("dbs/" + DATABASE_ID, myCollection, null).getResource();

		System.out.println("Created a new collection:");
		System.out.println(myCollection.toString());
		System.out.println("Press any key to continue..");
		System.in.read();

		// Create an object, serialize it into JSON, and wrap it into a document.
		File dir = new File(CSV_FILE_DIR);
		File[] list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			
			System.out.println("Read a csv file:");
			System.out.println(list[i].toString());
			System.out.println("Press any key to continue..");
			System.in.read();

			File file = new File(list[i].toString());
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String text;
			long lineCount = 0;
			while ((text = br.readLine()) != null) {
				if (lineCount == 0) {
					System.out.println("Header: " + text);
				} else {
					TaxiPojo taxiPojo = new TaxiPojo(text);
					String taxiJson = gson.toJson(taxiPojo);
					Document taxiDocument = new Document(taxiJson);

					// Create the document.
					taxiDocument = documentClient
							.createDocument("dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, taxiDocument, null, false)
							.getResource();

					System.out.println("Created " + lineCount + " document:");
					System.out.println(taxiDocument.toString());
				}
				lineCount++;
			}
			br.close();
			System.out.println("Press any key to continue..");
			System.in.read();
		}

		// Query documents
//		List<Document> results = documentClient
//				.queryDocuments("dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
//						"SELECT * FROM myCollection WHERE myCollection.email = 'allen [at] contoso.com'", null)
//				.getQueryIterable().toList();
//
//		System.out.println("Query document where e-mail address = 'allen [at] contoso.com':");
//		System.out.println(results.toString());
//		System.out.println("Press any key to continue..");
//		System.in.read();

		// Delete Database
//		documentClient.deleteDatabase("dbs/" + DATABASE_ID, null);
//
//		System.out.println("Deleted database");
//		System.out.println("Press any key to continue..");
//		System.in.read();

	}
}