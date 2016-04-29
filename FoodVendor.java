//Gurion Marks
//gmarks2
//HW 10

public class FoodVendor extends GoodsVendor {
	
	/**
	* whether or not the vendor is allowed to sell food.
	* True if yes, otherwise false
	*/
	private boolean license;

	/**
	* Creates an food vendor object
	*
	* @param name 	the name of the vendor
	* @param what 	the type of vendor
	* @param fee	the vendor's appearance fee
	* @param sales	the amount of sales the vendor did at the previous venue
	*/	
	FoodVendor(String name, String what, double sales, boolean license) {
		super(name, what, sales);
		license = false;
	}

	/**
	 * Creates a String representation of a food vendor.
     * Any double values appearing in the representation are formatted to two decimal places. 
     *
	 * @return the String representation of a food vendor
	 */
	public String toString() {
		String str = name + " [" + what + "], sales: $" + String.format("%.2f", sales) + ", license: " + license; 
		return str;
	}

	/**
	* Sets food vendors selling license to true
	*/
	public void setLicense() {
		this.license = true;
	}
}