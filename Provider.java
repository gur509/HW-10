//Gurion Marks
//gmarks2
//HW 10

public class Provider implements Provides {
	
	/**
	* The name of the provider
	*/
	protected String name;

	/**
	* The type of the provider
	*/	
	protected String what;

	/**
	* The appearance fee of the provider
	*/	
	protected double fee;

	/**
	* The sales the provider did at a previous venue
	*/	
	protected double sales;

	/**
	* Creates a new Provider with the given data.
	*
	* @param name 	The name of the Provider
	* @param what 	What the Provider provides
	* @param fee 	Provider's appearance fee
	* @param sales 	Total sales at the previous event
	*/ 
	Provider(String name, String what, double fee, double sales) {
		this.name = name;
		this.what = what;
		this.fee = fee;
		this.sales = sales;
	}

	/**
	 * Returns the name of the provider.
	 *
	 * @return the provider name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns what type of goods/services are supplied by provider.
	 *
	 * @return the type of goods/services supplied
	 */
	public String getWhat() {
		return what;
	}

	/**
	 * Returns the appearance fee charged by the provider.
	 *
	 * @return the appearance fee amount (0.0 if no charge)
	 */
	public double getFee() {
		return fee;
	}

 	/**
	 * Get the total sales by this provider during previous event.
	 *
	 * @return the total sales from previous event
	 */
	public double getTotalPreviousSales() {
		return sales;
	}

	/**
	 * Checks if two providers are equal by checking if their 
     * names are equal (ignoring case).
	 *
	 * @param o 	the object being compared
	 * @return true if the provider names match, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Provider) {
			Provider temp = (Provider) o;
			if (temp.getName().equalsIgnoreCase(name))
				return true;
			else
				return false;
		} else 
			return false;
	}

	/**
	 * Creates a String representation of a provider.
     * Any double values appearing in the representation are formatted to two decimal places. 
     *
	 * @return the String representation of a transactor
	 */
	@Override
	public String toString() {
		String str = name + " [" + what + "], fee: $" + String.format(".2f", fee) + ", sales: $" + String.format(".2f", sales); 
		return str;
	}

	/**
	 * Compares two providers based on how much they sold at previous events
	 *
	 * @param o 	the Provider being compared
	 * @return 1 if this Provider grossed more than the other, 0 if they're equal, and -1 if this one grossed less.
	 */
	@Override
	public int compareTo(Object o) {
		int compare;
		if (o instanceof Provider) {
			Provider temp = (Provider) o;
			if (this.getTotalPreviousSales() < temp.getTotalPreviousSales())
				compare = -1;
			else if (this.getTotalPreviousSales() == temp.getTotalPreviousSales())
				compare = 0;
			else 
				compare = 1;
		}
		else 
			compare = 2;			
		return compare;
	}
	
	
}











