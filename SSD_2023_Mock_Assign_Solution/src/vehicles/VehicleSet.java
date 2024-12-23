package vehicles;

import java.util.HashSet;
import java.util.Set;

/**
 * Implements the {@link VehicleCollection} interface using an underlying set.
 * 
 * @author mdixon
 */
public class VehicleSet implements VehicleCollection {

	/**
	 * The set of vehicles
	 */
	private Set<Vehicle> vehicles = new HashSet<Vehicle>();

	///////////////////////////////////////////////////////////////////////

	@Override
	public int addVehicle(Vehicle vehicle) {

		// add the vehicle to the list, then return the size of the list once added
		vehicles.add(vehicle);

		return vehicles.size();
	}

	@Override
	public boolean removeVehicle(Vehicle vehicle) {

		// remove the vehicle to the list, returning true if actually removed, else returning false.
		return vehicles.remove(vehicle);
	}

	@Override
	public boolean containsVehicle(Vehicle vehicle) {

		// return true if the list contains the given vehicle, else return false.
		return vehicles.contains(vehicle);
	}

	@Override
	public int vehicleCount() {

		// return the size of the list
		return vehicles.size();
	}

	@Override
	public void clearAllVehicles() {

		// remove all elements from the list
		vehicles.clear();
	}

	@Override
	public Vehicle getLargestRange() {

		Vehicle largest = null;
		double range = 0;

		// iterate the set, finding the vehicle with the largest range
		for (Vehicle vehicle : vehicles) {

			if (vehicle.getMaxRange() > range) {
				range = vehicle.getMaxRange();
				largest = vehicle;
			}
		}

		return largest;
	}

	@Override
	public int countVehiclesOfModel(String model) {

		int count = 0;

		// Check if given model is null
		if (model != null) {

			// iterate the set, counting the number of vehicles with the given model
			for (Vehicle vehicle : vehicles) {

				// call getModel() for each vehicle and compare with given model using a equalsIgnoreCase()
				if (model.equalsIgnoreCase(vehicle.getModel()))
					count++;
			}
		}

		// note: a streams based solution is also valid
		return count;
	}

	@Override
	public boolean containsVehicleWithReg(String regNo) {

		// Check if given regNo is null
		if (regNo != null) {
			// iterate the set, checking if any vehicles have the given regNo
			for (Vehicle vehicle : vehicles) {

				// call getRegistration() for each vehicle and compare with given regNo
				if (regNo.equals(vehicle.getRegistration()))
					return true;
			}
		}

		return false;
	}

	///////////////////////////////////////////////////////////////////////

}
