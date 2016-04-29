//Gurion Marks
//gmarks2
//HW 10

public class ActivitySupplier extends Provider {
	
	/**
	* Creates an activity supplier object
	*
	* @param name 	the name of the activity supplier
	* @param what 	the type of supplier
	* @param fee	the activity supplier's appearance fee
	* @param sales	the amount of sales the supplier did at the previous venue
	*/
	ActivitySupplier(String name, String what, double fee, double sales) {
		super(name, what, fee, sales);
	}

	/**
	 * Creates a String representation of an activity supplier.
     * Any double values appearing in the representation are formatted to two decimal places. 
     *
	 * @return the String representation of a transactor
	 */
	public String toString() {
		String str = name + " [" + what + "], fee: $" + String.format("%.2f", fee) + ", sales: $" + String.format("%.2f", sales); 
		return str;
	}
}