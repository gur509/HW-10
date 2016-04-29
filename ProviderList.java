//Gurion Marks
//gmarks2
//HW 10

import java.util.Scanner;

public class ProviderList implements ProviderCatalog {
	
	/**
	* The start size of the provider list
	*/
	public static final int START_SIZE = 5;

	/**
	* The current size of the provider list
	*/
	private int CURRENT_SIZE = START_SIZE;

	/**
	* Instantiates an array of providers called list
	*/
	private Provider[] list;

	/**
	* The number of providers in the provider list
	*/
	private int numProviders;

	/**
	* Creates an array of providers, initially START_SIZE
	* Number of providers initially zero
	* 
	* @param START_SIZE 	the starting size of the provider list
	*/
	ProviderList(int START_SIZE) {
		list = new Provider[START_SIZE];
		numProviders = 0;
	}

	/**
	 * Adds a new Provider, as long as no other Provider in the catalog has the 
     * same name (ignoring case).
	 *
	 * @param p 	the new Provider to add
	 * @return true if the Provider was added, false otherwise
	 */
	public boolean add(Provider p) {
		for (int i = 0; i < numProviders; i++) {
			if (list[i].equals(p))
				return false;
		}

		if (numProviders == START_SIZE) {
		augmentArray();
		}

		list[numProviders] = p;
		numProviders++;
		return true;
	}

	/**
	* Doubles array size and copies over components to the first half of the larger list
	*/
	private void augmentArray() {
		Provider[] temp = new Provider[CURRENT_SIZE * 2];
		for (int i = 0; i < CURRENT_SIZE; i++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
		CURRENT_SIZE *= 2;
	}

	/**
	* Gets rid of empty spaces within data in an array, puts all data at the front
	*/
	private void condenseArray() {
		Provider[] temp = new Provider[CURRENT_SIZE];
		int counter = 0;
		for (int i = 0; i < CURRENT_SIZE; i++) {
			if (this.list[i] != null) {
				temp[counter] = this.list[i];
				counter++;
			}
		}
		this.list = temp;
	}

	/**
	 * Removes all Providers from the list whose total sales in the previous
	 * event is less than the amount of the parameter, and returns the number 
     * of Providers that were removed from the list.  This can never cause
     * the removal of a Performer, since Performers always have zero sales.
	 *
	 * @param minSales	 the minimum threshold for sales in the previous event
	 * @return the number of Providers removed
	 */
	
	public int remove(double minSales) {
		int numRemoved = 0;
		for (int i = 0; i < numProviders; i++) {
			//make sure the object is one of the possible removable types
			if (list[i] instanceof GoodsVendor || list[i] instanceof FoodVendor || list[i] instanceof ActivitySupplier) {
				//if total sales is less than required, remove the provider
				if (list[i].getTotalPreviousSales() < minSales) {
					list[i] = null;
					numRemoved++;
					numProviders--;
				}
			}			
		}
		//push all data to the front
		condenseArray();
		return numRemoved;
	}
	

	/**
	 * Sorts the Providers by sales during the previous event (descending order).
	 */
	public void sort() {
		//bubble sort, used similar to algorithm used in class
		Provider temp = new Provider("", "", 0.0, 0.0);
		for (int done = numProviders - 1; done > 0; done--) {
			for (int i = 0; i < done; i++) {
				if (list[i].getTotalPreviousSales() < list[i + 1].getTotalPreviousSales()) {
					temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}

	/**
	 * Outputs to the screen all the Providers in the list.
	 */ 
	public void display() {
		for (int i = 0; i < numProviders; i++) {
			System.out.println(list[i].toString());
		}
		if (numProviders == 0) {
			System.out.println("There are currently no providers in the list.");
		}
	}

	/**
	 * Indicates that a given FoodVendor's license to serve is confirmed.  The method
	 * first supplies a list of existing food vendors, with indices, then asks the user
     * for the index of the FoodVendor to confirm. If the user enters an index which
     * does not represent a FoodVendor, no status is changed.
	 *
	 * @param kb 	a Scanner which can collect keyboard input, needed because
	 *            	the current method will collect user input
	 */
	public void confirmLicenseToServeFood(Scanner kb) {
		int numFood = 0;
		//search for food vendors, check for null case
		for (int i = 0; i < numProviders; i++) {
			if (list[i] instanceof FoodVendor) 
				numFood++;
		}

		//null case
		if (numFood == 0) {
			System.out.println("There are currently no food vendors in the list.");
		} else { //output all food vendors
			for (int i = 0; i < numProviders; i++) {
				if (list[i] instanceof FoodVendor)
					System.out.println(i + ") " + list[i].toString());
			}
			//choose the one to confirm, and confirm it
			System.out.print("Enter index --> ");
			int index = kb.nextInt();
			//make sure input is valid, then set license
			if (index > numProviders || !(list[index] instanceof FoodVendor)) {
				System.out.println("Invalid input.");
			} else {
				((FoodVendor) list[index]).setLicense();
			}
		}
	}

	/**
	 * Displays the Providers in the list grouped by type (performers, activity suppliers, 
	 * (non-food) goods vendors, food vendors).
	 */
	public void displayGroups() {
		System.out.print("-- Groups --\n");
		//Initial strings
		String performers = "Performers:\n";
		String activity = "Activity Suppliers:\n";
		String goods = "Goods Vendors:\n";
		String foods = "Food Vendors:\n";
		//number of each type, used to check null cases
		int perf = 0;
		int act = 0;
		int good = 0;
		int food = 0;

		//augment strings to put all the providers in the list into their specific group
		for (int i = 0; i < numProviders; i++) {
			if (list[i] instanceof Performer) {
				performers += list[i].toString() + "\n";
				perf++;
			} else if (list[i] instanceof ActivitySupplier) {
				activity += list[i].toString() + "\n";
				act++;
			} else if (list[i] instanceof GoodsVendor && !(list[i] instanceof FoodVendor)) {
				goods += list[i].toString() + "\n";
				good++;							
			} else if (list[i] instanceof FoodVendor) {
				foods += list[i].toString() + "\n";
				food++;
			}
		}

		//null cases
		if (perf == 0) {
			performers += "There are currently no performers in the list.\n";
		}
		if (act == 0) {
			activity += "There are currently no activity suppliers in the list.\n";
		}
		if (good == 0) {
			goods += "There are currently no goods vendors in the list.\n";
		}
		if (food == 0) {
			foods += "There are currently no food vendors in the list.\n";
		}
		System.out.println(performers + "\n" + activity + "\n" + goods + "\n" + foods);
	}

	/**
	 * Returns the Performer or ActivitySupplier with the greatest appearance fee.
     * If there is a tie, returns just one such provider. If there are no Performers 
     * or ActivitySuppliers in the list, returns null.
	 *
	 * @return the Performer or ActivitySupplier with the greatest appearance fee,
     * or null if no Performers or ActivitySuppliers in list
	 */
	public Provider getPerfOrActSuplLargestFee() {
		Provider p = new Provider("", "", 0.0, 0.0);
		double largestFee = 0;
		for (int i = 0; i < numProviders; i++) {
			if (list[i] instanceof Performer || list[i] instanceof ActivitySupplier) {
				if (list[i].getFee() > largestFee) {
					largestFee = list[i].getFee();
					p = list[i];
				}
			}
		}
		return p;
	}
}



































