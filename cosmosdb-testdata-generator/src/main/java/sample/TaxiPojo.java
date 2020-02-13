package sample;

class TaxiPojo {
	private String vendorid;
	private String tpep_pickup_datetime;
	private String tpep_dropoff_datetime;
	private String passenger_count;
	private String trip_distance;
	private String ratecodeid;
	private String store_and_fwd_flag;
	private String puLocationid;
	private String doLocationid;
	private String payment_type;
	private String fare_amount;
	private String extra;
	private String mta_tax;
	private String tip_amount;
	private String tolls_amount;
	private String improvement_surcharge;
	private String total_amount;
	private String congestion_surcharge;

	public TaxiPojo(String text) {
		super();
		String[] data = text.split(",", -1);
		this.vendorid = data[0];
		this.tpep_pickup_datetime = data[1];
		this.tpep_dropoff_datetime = data[2];
		this.passenger_count = data[3];
		this.trip_distance = data[4];
		this.ratecodeid = data[5];
		this.store_and_fwd_flag = data[6];
		this.puLocationid = data[7];
		this.doLocationid = data[8];
		this.payment_type = data[9];
		this.fare_amount = data[10];
		this.extra = data[11];
		this.mta_tax = data[12];
		this.tip_amount = data[13];
		this.tolls_amount = data[14];
		this.improvement_surcharge = data[15];
		this.total_amount = data[16];
		this.congestion_surcharge = data[17];
	}

	public String getVendorid() {
		return vendorid;
	}

	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	public String getTpep_pickup_datetime() {
		return tpep_pickup_datetime;
	}

	public void setTpep_pickup_datetime(String tpep_pickup_datetime) {
		this.tpep_pickup_datetime = tpep_pickup_datetime;
	}

	public String getTpep_dropoff_datetime() {
		return tpep_dropoff_datetime;
	}

	public void setTpep_dropoff_datetime(String tpep_dropoff_datetime) {
		this.tpep_dropoff_datetime = tpep_dropoff_datetime;
	}

	public String getPassenger_count() {
		return passenger_count;
	}

	public void setPassenger_count(String passenger_count) {
		this.passenger_count = passenger_count;
	}

	public String getTrip_distance() {
		return trip_distance;
	}

	public void setTrip_distance(String trip_distance) {
		this.trip_distance = trip_distance;
	}

	public String getRatecodeid() {
		return ratecodeid;
	}

	public void setRatecodeid(String ratecodeid) {
		this.ratecodeid = ratecodeid;
	}

	public String getStore_and_fwd_flag() {
		return store_and_fwd_flag;
	}

	public void setStore_and_fwd_flag(String store_and_fwd_flag) {
		this.store_and_fwd_flag = store_and_fwd_flag;
	}

	public String getPuLocationid() {
		return puLocationid;
	}

	public void setPuLocationid(String puLocationid) {
		this.puLocationid = puLocationid;
	}

	public String getDoLocationid() {
		return doLocationid;
	}

	public void setDoLocationid(String doLocationid) {
		this.doLocationid = doLocationid;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getFare_amount() {
		return fare_amount;
	}

	public void setFare_amount(String fare_amount) {
		this.fare_amount = fare_amount;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getMta_tax() {
		return mta_tax;
	}

	public void setMta_tax(String mta_tax) {
		this.mta_tax = mta_tax;
	}

	public String getTip_amount() {
		return tip_amount;
	}

	public void setTip_amount(String tip_amount) {
		this.tip_amount = tip_amount;
	}

	public String getTolls_amount() {
		return tolls_amount;
	}

	public void setTolls_amount(String tolls_amount) {
		this.tolls_amount = tolls_amount;
	}

	public String getImprovement_surcharge() {
		return improvement_surcharge;
	}

	public void setImprovement_surcharge(String improvement_surcharge) {
		this.improvement_surcharge = improvement_surcharge;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getCongestion_surcharge() {
		return congestion_surcharge;
	}

	public void setCongestion_surcharge(String congestion_surcharge) {
		this.congestion_surcharge = congestion_surcharge;
	}

}
