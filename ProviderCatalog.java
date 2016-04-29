import java.util.Scanner;

/**
 * Intro to Java (600.107) - Spring 2016 - HW10
 *
 * interface ProviderCatalog - do not modify 
 */
public interface ProviderCatalog {

	/** The default initial size of the catalog */
	public static final int START_SIZE = 5;

	/**
	 * Adds a new Provider, as long as no other Provider in the catalog has the 
     * same name (ignoring case).
	 *
	 * @param p
	 *            the new Provider to add
	 * @return true if the Provider was added, false otherwise
	 */
	public boolean add(Provider p);

	/**
	 * Removes all Providers from the list whose total sales in the previous
	 * event is less than the amount of the parameter, and returns the number 
     * of Providers that were removed from the list.  This can never cause
     * the removal of a Performer, since Performers always have zero sales.
	 *
	 * @param minSales
	 *            the minimum threshold for sales in the previous event
	 * @return the number of Providers removed
	 */
	public int remove(double minSales);

	/**
	 * Sorts the Providers by sales during the previous event (descending order).
	 */
	public void sort();

	/**
	 * Outputs to the screen all the Providers in the list.
	 */
	public void display();

	/**
	 * Indicates that a given FoodVendor's license to serve is confirmed.  The method
	 * first supplies a list of existing food vendors, with indices, then asks the user
     * for the index of the FoodVendor to confirm. If the user enters an index which
     * does not represent a FoodVendor, no status is changed.
	 *
	 * @param kb
	 *            a Scanner which can collect keyboard input, needed because
	 *            the current method will collect user input
	 */
	public void confirmLicenseToServeFood(Scanner kb);

	/**
	 * Displays the Providers in the list grouped by type (performers, activity suppliers, 
	 * (non-food) goods vendors, food vendors).
	 */
	public void displayGroups();

	/**
	 * Returns the Performer or ActivitySupplier with the greatest appearance fee.
     * If there is a tie, returns just one such provider. If there are no Performers 
     * or ActivitySuppliers in the list, returns null.
	 *
	 * @return the Performer or ActivitySupplier with the greatest appearance fee,
     * or null if no Performers or ActivitySuppliers in list
	 */
	public Provider getPerfOrActSuplLargestFee();

}
