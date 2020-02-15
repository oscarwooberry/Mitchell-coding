import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class VehicleServiceInMemoryTest{

	@Test
	public void testGetVehicles() {
		String[] makes = {"Mercedes", "Tesla", "Honda", "BMW", "Audi", "Ford","Toyota", "Ford", "Ford"};
        String[] models = {"CLA45", "Model 3", "Odyssey", "X6", "R8", "F-150", "Corolla", "F-150", "F-350"};
        int[] years = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
        
        // new vehicleServiceinmemory to catch method 
        VehicleServiceInMemory v = new VehicleServiceInMemory();
        
        //put the data into vehicle list
        for (int i = 0; i < makes.length; i++) {
        	v.CreateVehicles(years[i], makes[i], models[i]);
        }
        
        for(int i = 0; i < makes.length; i++) {
            assertEquals(v.getVehicles().get(i).getYear(), years[i]);
            assertEquals(v.getVehicles().get(i).getModel(), models[i]);
            assertEquals(v.getVehicles().get(i).getMake(), makes[i]);
        }
	}

	@Test
	public void testGetVehiclesId() {
		String[] makes = {"Mercedes", "Tesla", "Honda", "BMW", "Audi", "Ford","Toyota", "Ford", "Ford"};
        String[] models = {"CLA45", "Model 3", "Odyssey", "X6", "R8", "F-150", "Corolla", "F-150", "F-350"};
        int[] years = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
        
        // new vehicleServiceinmemory to catch method 
        VehicleServiceInMemory v = new VehicleServiceInMemory();
        
        //put the data into vehicle list
        for (int i = 0; i < makes.length; i++) {
        	v.CreateVehicles(years[i], makes[i], models[i]);
        }
        
        //int[] id2 = {0,1,2,3,4,5,6,7,8};
        int[] id2 = {0,1,2,3,4,5,6,7,8,9,10,11};
        for(int i = 0; i < makes.length; i++) {
            assertEquals(v.getVehiclesId(id2).get(i).getYear(), years[i]);
            assertEquals(v.getVehiclesId(id2).get(i).getModel(), models[i]);
            assertEquals(v.getVehiclesId(id2).get(i).getMake(), makes[i]);
        }
  
	}

	@Test
	public void testCreateVehicles() {
		String[] makes = {"Mercedes", "Tesla", "Honda", "BMW", "Audi", "Ford","Toyota", "Ford", "Ford"};
        String[] models = {"CLA45", "Model 3", "Odyssey", "X6", "R8", "F-150", "Corolla", "F-150", "F-350"};
        int[] years = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
        
        // new vehicleServiceinmemory to catch method 
        VehicleServiceInMemory v = new VehicleServiceInMemory();
        List<Vehicle> vList = new ArrayList<Vehicle>();
        //put the data into vehicle list
        for (int i = 0; i < makes.length; i++) {
        	Vehicle vehicle = new Vehicle();
            vehicle.setYear(years[i]);
            vehicle.setModel(models[i]);
            vehicle.setMake(makes[i]);
            vehicle.setId(i);
            vList.add(vehicle);
        }
        
        for (int i = 0; i < makes.length; i++) {
        	v.CreateVehicles(years[i], makes[i], models[i]);
        	//System.out.println( v.getVehicles().get(i).getMake());
        }
        
        for(int i = 0; i < makes.length; i++) {
            assertEquals(v.getVehicles().get(i).getYear(), vList.get(i).getYear());
            assertEquals(v.getVehicles().get(i).getModel(), vList.get(i).getModel());
            assertEquals(v.getVehicles().get(i).getMake(), vList.get(i).getMake());
            assertEquals(v.getVehicles().get(i).getId(), vList.get(i).getId());
        }
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateVehicles() {
		String[] makes = {"Mercedes", "Tesla", "Honda", "BMW", "Audi", "Ford","Toyota", "Ford", "Ford"};
        String[] models = {"CLA45", "Model 3", "Odyssey", "X6", "R8", "F-150", "Corolla", "F-150", "F-350"};
        int[] years = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
        
        // new vehicleServiceinmemory to catch method 
        VehicleServiceInMemory v = new VehicleServiceInMemory();
        //put the data into vehicle list
        for (int i = 0; i < makes.length; i++) {
        	v.CreateVehicles(years[i], makes[i], models[i]);
        }
        v.UpdateVehicles(0, 2020, "Nissan", "GTR");
        int[] id2 = {0,1};
        assertEquals(v.getVehiclesId(id2).get(0).getMake(), "Nissan");
        assertEquals(v.getVehiclesId(id2).get(0).getYear(), 2020);
        assertEquals(v.getVehiclesId(id2).get(0).getModel(), "GTR");
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteVehicles() {
		String[] makes = {"Mercedes", "Tesla", "Honda", "BMW", "Audi", "Ford","Toyota", "Ford", "Ford"};
        String[] models = {"CLA45", "Model 3", "Odyssey", "X6", "R8", "F-150", "Corolla", "F-150", "F-350"};
        int[] years = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
        
        // new vehicleServiceinmemory to catch method 
        VehicleServiceInMemory v = new VehicleServiceInMemory();
        
        //put the data into vehicle list
        for (int i = 0; i < makes.length; i++) {
        	v.CreateVehicles(years[i], makes[i], models[i]);
        }
        int[] idlist = {0,1,2,3,4,5,6,7,8};
        v.DeleteVehicles(idlist);

        assertEquals(0, v.getVehicles().size());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetVehicleByFilter() {
		String[] makes = {"Mercedes", "Tesla", "Honda", "BMW", "Audi", "Ford","Toyota", "Ford", "Ford"};
        String[] models = {"CLA45", "Model 3", "Odyssey", "X6", "R8", "F-150", "Corolla", "F-150", "F-350"};
        int[] years = {2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017};
        
        // new vehicleServiceinmemory to catch method 
        VehicleServiceInMemory v = new VehicleServiceInMemory();
        List<Vehicle> vList = new ArrayList<Vehicle>();
        //put the data into vehicle list
        for (int i = 0; i < 4; i++) {
        	v.CreateVehicles(years[i], makes[i], models[i]);
        	//System.out.println( v.getVehicles().get(i).getMake());
        }
        
        //int[] id2 = {0,1,2,3,4,5,6,7,8};
        int[] id2 = {0,1,2,3,4,5,6,7,8,9,10,11};
        for(int i = 0; i<4; i++) {
	        assertEquals(v.getVehicleByFilter(makes[i], null).get(0).getMake(), makes[i]);
	        assertEquals(v.getVehicleByFilter(null, models[i]).get(0).getModel(), models[i]);
	        assertEquals(v.getVehicleByFilter(makes[i],models[i]).get(0).getMake(), makes[i]);
	        assertEquals(v.getVehicleByFilter(makes[i],models[i]).get(0).getModel(), models[i]);
	        
	        assertEquals(v.getVehicleByFilter(null,null).get(i).getModel(), models[i]);
        }
	}
}
