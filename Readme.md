
	
This CRUD operations provide create read update and delete functions that can 
perform on car infos. I used hashmap as my in-memory persistance data structure 
to store vehicles. Apply junit testing to test my validation of my functions.
Moreover, functiosn will have restrctions on year range and no empty strings on
vehicle makes and models. 

Method implemented:
	public List<Vehicle> getVehicles(); 
		descrption: get all vehicles from hashmap and put into and return arraylist 

	public List<Vehicle> getVehiclesId(int[] idList);
		descrption: get Vehicles by ids, parameter as integer list so it can scan multiple ids from the list
		returns arraylist

        public boolean CreateVehicles(int year, String make, String model);
		descrption: it will create a vehilce class that contains id(automatically increment), pass in year
		make and model, those info can not be null

	public boolean UpdateVehicles(int id, int year, String make, String model);
		descrption: it will update vehicles infos, when the pass in info is null will return error message

	public boolean DeleteVehicles(int[] vehicleId);
		descrption: it will delete vehicles from hashmap, pass in an integer array so can process multiple ids 
		deletion request

	public List<Vehicle> getVehicleByFilter(String make, String model);
		descrption: a filter applied on get vehicle so it can either take one parameter or both,
		if both are null, then perform basic get vehicles and return all in the current hashmap
# Mitchell-coding
