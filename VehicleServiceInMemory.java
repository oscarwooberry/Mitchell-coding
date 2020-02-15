import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.Scanner;
import java.util.Set;

public class VehicleServiceInMemory implements VehicleCRUDInterface {
	private final int EARLIEST_YEAR = 1950;
	private final int LATEST_YEAR = 2050;
	//create a single shared scanner for keyboard input
	//private static Scanner scanner = new Scanner(System.in);
	private Map<Integer, Vehicle> map = new HashMap<>();
	private int id_num = 0;
	
	@Override
	public List<Vehicle> getVehicles() {
		//create a arraylist that store the vehicles
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		
	    // Getting a Set of Key-value pairs
	    Set<Entry<Integer, Vehicle>> entrySet = map.entrySet();
	 
	    // Obtaining an iterator for the entry set
	    Iterator<Entry<Integer, Vehicle>> it = entrySet.iterator();
	    
	    //iterator loop through and add to arraylist
	    while(it.hasNext()) {
	    	Map.Entry<Integer, Vehicle> mapElement = it.next();
	    	vehicleList.add(mapElement.getValue());
	    }
		return vehicleList;
	}

	@Override
	public List<Vehicle> getVehiclesId(int[] idList) {
		//create a arraylist that store the vehicles
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		
	    // Getting a Set of Key-value pairs
	    Set<Entry<Integer, Vehicle>> entrySet = map.entrySet();
	 
	    // Obtaining an iterator for the entry set
	    Iterator<Entry<Integer, Vehicle>> it = entrySet.iterator();
	    
	    //for loop to loop through the idList find all matches for ids
	    for(int i = 0; i < idList.length; i++) {
	    	//check if the current id is valid. if not error mesg and move to next 
	    	if(!map.containsKey(idList[i])) {
	    		System.out.println( "The ID: " + idList[i] + 
	    					" is not exist, please enter a correct one!" );
	   		}
	    	
	    	//iterator loop through and add to arraylist
	    	while(it.hasNext()) {
	    		Map.Entry<Integer, Vehicle> mapElement = it.next();
	    		if(idList[i] == mapElement.getKey()) {
	    			vehicleList.add(mapElement.getValue());
	    			break;
	    		}
	    	}
	    }
		return vehicleList;
	}

	@Override
	public boolean CreateVehicles(int year, String make, String model) {
		
		//System.out.print( "Put enter the year(1950-2050) for the vehicle: " );
		//String input = scanner.nextLine();
		
		//assign the id to the vehicle
		if(checkConditions(year, make, model)) {
			Vehicle vehicle = new Vehicle();
			vehicle.setYear(year);
			vehicle.setMake(make);
			vehicle.setModel(model);
			vehicle.setId(id_num);
			map.put(id_num, vehicle);
			id_num++;
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean UpdateVehicles(int vehicleId, int year, String make, String model) {
		if(!map.containsKey(vehicleId)) {
			System.out.println( "The ID is not exist, please enter a correct one!" );
			return false;
		}
		else {
			if(checkConditions(year, make, model)) {
				//update vehicles 
				map.get(vehicleId).setYear(year);
				map.get(vehicleId).setMake(make);
				map.get(vehicleId).setModel(model);
				System.out.println( "The Vehicle id: #" + vehicleId + 
						"'s info is successfully up to date!");
				return true;
			}
			else {
				return false;
			}
		}
	}

	@Override
	public boolean DeleteVehicles(int[] vehicleId) {
		int count = 0;
		for(int i = 0; i < vehicleId.length; i++) {
			if(!map.containsKey(vehicleId[i])) {
				count++;
				System.out.println( "The ID: " + vehicleId[i] + 
						" is not exist, please enter a correct one!" );
			}
			else if(map.containsKey(vehicleId[i])) {
				int v_Id = vehicleId[i];
				map.remove(v_Id);
				System.out.println( "vehicle #" + v_Id + " successfully deleted!" );
			}
		}
		
		System.out.println( "Current map size is: " + map.size());
		//if every id is not exist 
		if(count == vehicleId.length) {
			System.out.println( "None of ids exist! Please check the validation!");
			return false;
		}
		return true;
	}

	@Override
	public List<Vehicle> getVehicleByFilter(String make, String model){
		//case check, if no filter pass in, return base case
		if(make == null && model == null) {
			System.out.println( "no filter applied! return default setting" );
			return getVehicles();
		}
		else {
			//create a arraylist that store the vehicles
			List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		    // Getting a Set of Key-value pairs
		    Set<Entry<Integer, Vehicle>> entrySet = map.entrySet();
		    // Obtaining an iterator for the entry set
		    Iterator<Entry<Integer, Vehicle>> it = entrySet.iterator();
		    
			//case 1 make exist 
			if(model == null && make != null) {
			    	//iterator loop through and add to arraylist
			    	while(it.hasNext()) {
			    		Map.Entry<Integer, Vehicle> mapElement = it.next(); 		
			    		//check if the current make is valid. if not error mesg and move to next 
			    		if(make == mapElement.getValue().getMake()) {
			    			vehicleList.add(mapElement.getValue());	    			
			    		}
			    	}
			    if(vehicleList.size() == 0) {
			    	System.out.println( "The make: " + make + " is not exist!");
			    }
			}
			
			//case 2 model valid 
			else if(model != null && make == null) {
				//iterator loop through and add to arraylist
		    	while(it.hasNext()) {
		    		Map.Entry<Integer, Vehicle> mapElement = it.next(); 		
		    		//check if the current make is valid. if not error mesg and move to next 
		    		if(model == mapElement.getValue().getModel()) {
		    			vehicleList.add(mapElement.getValue());	    			
		    		}
		    	}
		    	if(vehicleList.size() == 0) {
		    		System.out.println( "The model: " + model + " is not exist!");
		    	}
			}
			
			//case 3 
			else if(model != null  && make != null) {
			    //iterator loop through and add to arraylist
			   	while(it.hasNext()) {
			   		Map.Entry<Integer, Vehicle> mapElement = it.next(); 		
			   		//check if the current make is valid. if not error mesg and move to next 
			   		if(model == mapElement.getValue().getModel()
		    				&& make == mapElement.getValue().getMake()) {
		    			vehicleList.add(mapElement.getValue());	    			
		    		}
			    }
			}
			return vehicleList;
		}
	}
	
	/*
	 * helper method that will check year make model infos 
	 */
	public boolean checkConditions(int year, String make, String model) {
		
		//set year and check the validation 
		if(year< EARLIEST_YEAR || year > LATEST_YEAR) {
			System.out.println( "Year out of range, must between 1950-2050!" );
			return false;
		}
			
		//set make and check if null
		else if(make == null) {
			System.out.println( "make must be non-empty!" );
			return false;
		}
		
		//set model and check if null
		else if(model == null) {
			System.out.println( "model must be non-empty!" );
			return false;
		}
		else
			return true;
		
	}

}
