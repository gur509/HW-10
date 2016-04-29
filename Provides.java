/**
 * Intro to Java (600.107) - Spring 2016 - HW10
 *
 * interface Provides
 */
public interface Provides extends Comparable<Object> 
{

	/**
	 * Returns the name of the provider.
	 *
	 * @return the provider name
	 */
	String getName();

	/**
	 * Returns what type of goods/services are supplied by provider.
	 *
	 * @return the type of goods/services supplied
	 */
	String getWhat();

	/**
	 * Returns the appearance fee charged by the provider.
	 *
	 * @return the appearance fee amount (0.0 if no charge)
	 */
	double getFee();

 	/**
	 * Get the total sales by this provider during previous event.
	 *
	 * @return the total sales from previous event
	 */
	double getTotalPreviousSales();

	/**
	 * Checks if two providers are equal by checking if their 
     * names are equal (ignoring case).
	 *
	 * @param o
	 *            the object being compared
	 * @return true if the provider names match, false otherwise
	 */
	@Override
	boolean equals(Object o);

	/**
	 * Creates a String representation of a provider.
     * Any double values appearing in the representation are formatted to two decimal places. 
     *
	 * @return the String representation of a transactor
	 */
	@Override
	public String toString();
}
