
public class Vehicle {
	private int id;
	private int year;
	private String make; 
	private String model;
	
	/* default constructor */
	public Vehicle() {}
	
	/* constructor */
	public Vehicle(int id, int year, String make, String model) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.id = id;
	}
	
	/* get the vehicle id */
	public int getId() {
		return id;
	}
	
	/* set the vehicle id */
	public void setId(int id) {
		this.id = id; 
	}
	
	/* get the vehicle year */
	public int getYear() {
		return year;
	}
	
	/* set the vehicle year */
	public void setYear(int year) {
		this.year = year; 
	}
	
	/* get the vehicle make */
	public String getMake() {
		return make;
	}
	
	/* set the vehicle make */
	public void setMake(String make) {
		this.make = make; 
	}
	
	/* get the vehicle make */
	public String getModel() {
		return model;
	}
	
	/* set the vehicle make */
	public void setModel(String model) {
		this.model = model; 
	}
	
	
	
}
