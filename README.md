## Usage

1. Download csv files of Yellow Taxi Trip Reords from [here](https://www1.nyc.gov/site/tlc/about/tlc-trip-record-data.page) and put them under **C:\\Temp\\**
2. Load the **pom.xml** file in Eclipse and then open the Java perspective
3. Open **appsettings.properties** and update the properties with the values you made a note from Azure Cosmos DB:
```
EndPointUrl=https://REPLACE_ME_WITH_YOURS.documents.azure.com:443/
PrimaryKey=REPLACE_ME_WITH_YOURS
```
4. Run the **GenerateNYCTaxiData.java** as Java Application

## Resources
- [azure-documentdb-java](https://github.com/Azure/azure-documentdb-java)