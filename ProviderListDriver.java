//Gurion Marks
//gmarks2
//HW 10

import java.util.Scanner;

public class ProviderListDriver {
	/**
	* Main method printing out a menu, collecting user input, and using a switch statement to respond to the input.
	*/
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int START_SIZE = 5;
		//Instance variables - these will be used later
		String name;
		String type;
		String schedule;
		double fee;
		double sales;
		boolean added;
		Provider p;
		//instantiate a provider list
		ProviderList list = new ProviderList(START_SIZE);
		int choice = 1;

		//loop as long as the user does not opt to quit
		while (choice != 0) {
			//print the option menu, collect and switch on the input
			printMenu();
			choice = kb.nextInt();
			String line = kb.nextLine();

			//cases 1 - 4 collect input and construct new providers in the array
			//cases 5 - 10 call methods in the ProviderList class
			//default gives invalid input message 
			switch (choice) {
				case 1:
					System.out.print("Enter name for performer --> ");
					name = kb.nextLine();
					System.out.print("Enter what type --> ");
					type = kb.nextLine();
					System.out.print("Enter schedule of performances --> ");
					schedule = kb.nextLine();
					System.out.print("Enter appearance fee --> ");
					fee = kb.nextDouble();
					line = kb.nextLine();
					p = new Performer(name, type, fee, schedule);
					added = list.add(p);
					if (added)
						System.out.printf("Performer %s successfully added.\n", name);
					else 
						System.out.println("Add failed.\n");
					break;
				case 2:
					System.out.print("Enter name for activity supplier --> ");
					name = kb.nextLine();
					System.out.print("Enter what type --> ");
					type = kb.nextLine();
					System.out.print("Enter appearance fee --> ");
					fee = kb.nextDouble();
					line = kb.nextLine();
					System.out.print("Enter total sales at previous event --> ");
					sales = kb.nextDouble();
					line = kb.nextLine();
					p = new ActivitySupplier(name, type, fee, sales);
					added = list.add(p);
					if (added)
						System.out.printf("Activity supplier %s successfully added.\n", name);
					else 
						System.out.println("Add failed.");
					break;
				case 3:
					System.out.print("Enter name for goods vendor --> ");
					name = kb.nextLine();
					System.out.print("Enter what type --> ");
					type = kb.nextLine();
					System.out.print("Enter total sales at previous event --> ");
					sales = kb.nextDouble();
					line = kb.nextLine();
					p = new GoodsVendor(name, type, sales);
					added = list.add(p);
					if (added)
						System.out.printf("Goods vendor %s successfully added.\n", name);
					else 
						System.out.println("Add failed.\n");
					break;
				case 4:
					System.out.print("Enter name for food vendor --> ");
					name = kb.nextLine();
					System.out.print("Enter what type --> ");
					type = kb.nextLine();
					System.out.print("Enter total sales at previous event --> ");
					sales = kb.nextDouble();
					line = kb.nextLine();
					p = new FoodVendor(name, type, sales, false);
					added = list.add(p);
					if (added)
						System.out.printf("Food vendor %s successfully added.\n", name);
					else 
						System.out.println("Add failed.\n");
					break;
				case 5:
					list.display();
					break;
				case 6:
					list.displayGroups();
					break;
				case 7:
					list.sort();
					System.out.println("Providers sorted.\n");
					break;
				case 8:
					System.out.print("Enter sales threshold --> ");
					double threshold = kb.nextDouble();
					line = kb.nextLine();
					int num = list.remove(threshold);
					System.out.printf("Removed %d Providers.\n", num);
					break;
				case 9:
					list.confirmLicenseToServeFood(kb);
					break;
				case 10:
					System.out.println(list.getPerfOrActSuplLargestFee().toString());
					break;
				default:
					if (choice == 0) {
					} else
						System.out.println("Invalid input.");
					break;
			}
		}
		System.out.println("Goodbye!");
	}

	/**
	* Prints the menu of possible options for the user to pick
	*/
	private static void printMenu() {
		System.out.print( 	"\n0) Quit\n" +
							"1) Add new performer\n" +
							"2) Add new activity supplier\n" +
							"3) Add new goods vendor\n" + 
							"4) Add new food vendor\n" +
							"5) Print all the providers\n" +
							"6) Display providers in groups\n" +
							"7) Sort all providers sorted by total sales at previous event (descending)\n" +
							"8) Remove all goods and food vendors below a total sales threshold\n" +
							"9) Record that a food vendor’s license to serve has been confirmed\n" +
							"10) Get performer or activity supplier with largest appearance fee\n" +
							"Choice --> ");
	}
}

