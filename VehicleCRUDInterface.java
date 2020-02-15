import java.util.List;

public interface VehicleCRUDInterface {
	/*get vehicles*/
	List<Vehicle> getVehicles();
	List<Vehicle> getVehiclesId(int[] idList);
    	boolean CreateVehicles(int year, String make, String model);
	boolean UpdateVehicles(int id, int year, String make, String model);
	boolean DeleteVehicles(int[] vehicleId);
	List<Vehicle> getVehicleByFilter(String make, String model);
}
