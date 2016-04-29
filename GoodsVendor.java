//Gurion Marks
//gmarks2
//HW 10

public class GoodsVendor extends Provider {

	/**
	* Creates an goods vendor object
	*
	* @param name 	the name of the vendor
	* @param what 	the type of vendor
	* @param fee	the goods vendor's appearance fee
	* @param sales	the amount of sales the vendor did at the previous venue
	*/	
	GoodsVendor(String name, String what, double sales) {
		super(name, what, 0.0, sales);
	}

	/**
	 * Creates a String representation of a goods vendor.
     * Any double values appearing in the representation are formatted to two decimal places. 
     *
	 * @return the String representation of a goods vendor
	 */
	public String toString() {
		String str = name + " [" + what + "], sales: $" + String.format("%.2f", sales); 
		return str;
	}
}