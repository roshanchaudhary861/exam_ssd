package vehicles;

/**
 * A kind of vehicle that represents a private car.
 * 
 * @author mdixon
 */
public class Car extends Vehicle {

	/**
	 * The size of the fuel tank (in gallons). If 0 the car is electric.
	 */
	private int tankSize;
	
	/**
	 * The range of the vehicle (total range if electric, otherwise a per-gallon range)
	 */
	private int range;
	
	///////////////////////////////////////////////////////////////////////

	@Override
	public double getMaxRange() {

		//  Calculate and return the max range using the tankSize multiplied by the range (unless electric).		
		if ( tankSize > 0 )
			return tankSize * range;
		
		// If the tankSize is zero return the range only (since the car is electric).
		return range;
	}
	
	
	/**
	 * @return the tankSize
	 */
	public int getTankSize() {
		
		return tankSize;
	}

	/**
	 * Sets the tankSize
	 * 
	 * @param tankSize the tankSize
	 */
	public void setTankSize(int tankSize) {
		
		this.tankSize = tankSize;
	}

	/**
	 * @return the range per gallon.
	 */
	public int getRange() {
		
		// return the range
		return range;
	}

	/**
	 * @param range the range per gallon.
	 */
	public void setRange(int range) {
		
		this.range = range;
	}

	/**
	 * @return true if the car is electric (has a tank size of 0)
	 */
	public boolean isElectric() {
		
		// return true if the car is electric
		return tankSize == 0;
	}
	
	///////////////////////////////////////////////////////////////////////

	
	/**
	 * Constructor
	 * 
	 * Creates a car (which always has 4 wheels).
	 * 
	 * By default a car is has a range of 100, and a tank size of 0 (it is electric).
	 * 
	 * @param model the model name of the vehicle
	 * @param regNo the registration number of the vehicle
	 */
	public Car(String model, String regNo) {
		
		// pass the correct number of wheels, model name, and regNo to the super() type constructor.
		super(4, model, regNo);
		
		// set the range and tank size attributes to the default values specified 
		tankSize = 0;
		range = 100;
	}
	
}
