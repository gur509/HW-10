//Gurion Marks
//gmarks2
//HW 10

public class Performer extends Provider {

	/**
	* The time that the performer is meant to perform
	*/
	private String schedule;

	/**
	* Creates an food vendor object
	*
	* @param name 	the name of the vendor
	* @param what 	the type of vendor
	* @param fee	the vendor's appearance fee
	* @param sales	the amount of sales the vendor did at the previous venue
	*/
	Performer(String name, String what, double fee, String schedule) {
		super(name, what, fee, 0.0);
		this.schedule = schedule;
	}

	/**
	 * Creates a String representation of a performer.
     * Any double values appearing in the representation are formatted to two decimal places. 
     *
	 * @return the String representation of a food vendor
	 */
	public String toString() {
		String str = name + " [" + what + "], fee: $" + String.format("%.2f", fee) + ", " + schedule; 
		return str;		
	}
}