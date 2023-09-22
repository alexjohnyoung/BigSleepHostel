
// Importing the Scanner class for taking user inputs
import java.util.Scanner;

public class BigSleepHostel {
	
	public static void addTenant(Scanner scanner, TenantList tenantlist)
	{
		System.out.print("Please enter tenant name: ");
		
		String name = scanner.nextLine();
		
		int currentTotal = tenantlist.getTotal();
		
		// Try avoid duplicate rooms
		// If tenant is removed from list, we cannot rely on getTotal() to pick our room number
		// Workaround: Get the highest room number from all tenants
		// So get highest room number and then just add one 
		int highestRoom = 0;
		
		// Begin for-loop, looping all Tenants in tenantlist 
		for (int index = 0; index < currentTotal; index++)
		{
			// Assign currentTenant to tenantlist.getObject(index);
			// This will allow us to work with each Tenant object 
			Tenant currentTenant = (Tenant)tenantlist.getObject(index);
			
			// Assign tenantRoom variable to currentTenant.getRoom();
			// Used for comparing to highest room
			int tenantRoom = currentTenant.getRoom();
				
			// If this Tenant's room number is higher than our highest room so far
			if (tenantRoom > highestRoom)
				// Set highestRoom to new highest 
				highestRoom = tenantRoom;
		}
		
		// Create new Tenant object newTenant, passing name and highestRoom variables
		Tenant newTenant = new Tenant(name, highestRoom + 1);
		
		// Attempt to add new Tenant object to TenantList tenantlist 
		boolean successful = tenantlist.add(newTenant);
		
		// If the add operation was successful: 
		if (successful)
		{
			// Notify to the user that we added a new Tenant to the list 
			System.out.println("New Tenant added!\n");
			
			// Tell the user the details of the Tenant we just added
			System.out.printf("Name: %s%nRoom: %d%n", name, highestRoom + 1);
		}
		else 
			// Notify to the user that we were not able to add a Tenant to the list
			System.out.println("Sorry, we could not add this Tenant to the list!\n");
		
		// Print a newline to stdout 
		System.out.println();
	}
	
	// listTenants(tenantList) method
	// Used to list all Tenants 
	public static void listTenants(TenantList tenantlist)
	{
		
		// Output a newline to standard output 
		System.out.println();
		
		// Begin for-loop, looping through each Tenant 
		for (int count = 0; count < tenantlist.getTotal(); count++)
		{
			// Assign Tenant currentTenant reference to tenantlist.getTenant(count)
			// This will allow us to work with each Tenant object in the TenantList 
			Tenant currentTenant = tenantlist.getTenant(count);
			
			// Output the details of this Tenant to standard output 
			System.out.printf("%s", currentTenant);
		}
		
		// Print a newline to standard output 
		System.out.println();
		
	}
	
	// getTenantAt() method
	// Used to get Tenant Object ID with given room number 
	public static int getTenantAt(TenantList tenantlist, int room)
	{
		// Initialize integer variable objectID to -1 to compare if we found something
		int objectID = -1;
		
		// Initialize integer variable currentTotal to getTotal() as number of entries
		int currentTotal = tenantlist.getTotal();
		
		// Begin for-loop, looping through each Tenant 
		for (int index = 0; index < currentTotal; index++)
		{	
			// Assign Tenant currentTenant reference to tenantlist.getObject(index)
			Tenant currentTenant = (Tenant)tenantlist.getObject(index);
			
			// If the room of Tenant currentTenant matches the room we passed into the method:
			if (currentTenant.getRoom() == room)
			{
				// Assign objectID to index as we found the index we wanted
				objectID = index;
				
				// Break out of the loop as we are now done finding 
				break;
			}
		}
		
		// Return the objectID to the user 
		return objectID;
	}
	
	
	public static void addPayment(Scanner scanner, TenantList tenantlist)
	{
		// Ask user to enter room number 
		System.out.print("Please enter room number to make payment: ");
		
		// Initialize room integer variable to scanner.nextInt()
		// This will capture next integer from the user 
		int room = scanner.nextInt();
		
		// Call scanner.nextLine() to flush stdin
		scanner.nextLine();
		
		// Ask the user to enter month to pay for 
		System.out.print("Please enter month: ");
		
		// Get the next line from Scanner and assign it to String variable month 
		String month = scanner.nextLine();
		
		// Ask the user to enter amount to pay 
		System.out.print("Please enter amount: ");
		
		// Assign local double variable amount to scanner.nextDouble()
		// This will get the next Double from the user 
		double amount = scanner.nextDouble();
		
		// Initialize new Payment object, passing in our month and amount
		Payment newPayment = new Payment(month, amount);
		
		// Get tenant ID with this room number 
		int tenantID = getTenantAt(tenantlist, room);
		
		// Pass tenant ID to tenantlist.getTenant to obtain Tenant reference
		Tenant chosenTenant = tenantlist.getTenant(tenantID);
		
		// Finally, call makePayment() on our Tenant reference, passing our new Payment object newPayment 
		chosenTenant.makePayment(newPayment);
	}
	
	// listPayments(TenantList) method
	// Used to list Tenant Payments 
	public static void listPayments(TenantList tenantlist)
	{
		
		// Begin for-loop, looping all Tenants
		for (int count = 0; count < tenantlist.getTotal(); count++)
		{
			// Assign Tenant currentTenant to tenantlist.getTenant(count)
			// This will allow us to work with each Tenant reference
			Tenant currentTenant = tenantlist.getTenant(count);
			
			// Assign PaymentList payments to currentTenant.getPayments()
			// This will allow us to work with the PaymentList for each Tenant 
			PaymentList payments = currentTenant.getPayments();
			
			// Initialize local integer variable totalPayments to number of payments Tenant has made 
			int totalPayments = payments.getTotal();
			
			// Begin for-loop, looping through all payments
			for (int paymentIndex = 0; paymentIndex < totalPayments; paymentIndex++)
				// Print details relating to each payment 
				System.out.printf("%s%n", payments.getPayment(paymentIndex));
			
		}
		
		// Print a newline to stdout 
		System.out.println();
	}
	
	// removeTenant(Scanner, TenantList) method
	// Used to remove a Tenant from the TenantList
	public static void removeTenant(Scanner scanner, TenantList tenantlist)
	{
		
		// Initialize local integer variable currentTotal to the number of entries (Tenants) in tenantlist 
		int currentTotal = tenantlist.getTotal(); 
		
		// Ask the user to enter a room number 
		System.out.print("Please enter room number: ");
		
		// Get the next integer from the user to capture room number 
		int room = scanner.nextInt();
		
		// Get the Object ID of the Tenant living in this room number 
		int objectID = getTenantAt(tenantlist, room);
		
		// If we are not able to find this room:
		if (objectID == -1)
		{
			// Tell the user we could not find this room
			System.out.println("We could not find this room!");
			
			// And return to end execution here 
			return;
		}
		
		// Attempt to remove the Tenant with Object ID objectID (matching our chosen room)
		boolean successful = tenantlist.remove(objectID);
		
		// Output a newline to standard output
		System.out.println();
		
		// If the remove operation was successful:
		if (successful)
			System.out.println("Remove operation successful!\n");
		else 
			// Otherwise, apologize to the user as we could not remove this Tenant 
			System.out.println("Sorry, the remove operation was not successful.\n");
		
	}
	
	public static void getNumPayments(TenantList tenantlist)
	{
		// Initialize local variable integer 'numPayments' to hold our number of payments
		int numPayments = 0; 
		
		// Initialize local variable integer 'currentTotal' to hold our number of entries 
		int currentTotal = tenantlist.getTotal();
		
		// Append a newline to output 
		System.out.println();
		
		// Begin for-loop, looping each Tenant in the list 
		for (int count = 0; count < currentTotal; count++)
		{
			
			// Initialize currentTenant to tenantlist.getTenant(count);
			// Allowing us to work with each Tenant reference 
			Tenant currentTenant = tenantlist.getTenant(count);
			
			// Initialize tenantPayments to the total number of entries in getPayments() list 
			int tenantPayments = currentTenant.getPayments().getTotal();
			
			// Print out Tenant information (name and number of payments)
			System.out.printf("Tenant name: %s%n", currentTenant.getName());
			
			// If this Tenant has not made payments..
			if (tenantPayments == 0)
				// Tell the user that this tenant has not made any payments
				System.out.printf("Number of payments: None%n");
			else 
				// Otherwise, tell the user how many payments they have made 
				System.out.printf("Number of payments: %d%n", tenantPayments);
			
			// Print a newline to standard output
			System.out.println();
			
			// Add tenantPayments local variable to numPayments local variable
			numPayments += tenantPayments;
		}
		
		// Print a newline to standard output
		System.out.println();
		
		// Tell the user the total number of payments 
		System.out.printf("Total number of payments: %d%n%n", numPayments);
	}
	
	public static void getTotalPayments(TenantList tenantlist)
	{
		
		// Initialize local integer variable numTenants to tenantlist.getTotal();
		int numTenants = tenantlist.getTotal();
		
		// Print a newline to standard output
		System.out.println();
		
		// Begin for-loop, looping all Tenants in the list 
		for (int count = 0; count < numTenants; count++)
		{	
			// Initialize currentTenant to tenantlist.getTenant(count);
			// This allows us to work with each Tenant reference
			Tenant currentTenant = tenantlist.getTenant(count);
			
			// Initialize sumPayments local double variable to hold Tenant's total payments
			double sumPayments = 0;
			
			// Output Tenant Object information to standard output
			System.out.printf("%s", currentTenant);
			
			// Initialize payments reference to currentTenant.getPayments();
			// This allows us to work with the PaymentList of each Tenant
			PaymentList payments = currentTenant.getPayments();
			
			// Initialize numPayments local integer variable to the number of entries in this Tenant's PaymentList 
			int numPayments = payments.getTotal();
			
			// If this Tenant has not made any payments:
			if (numPayments == 0) {
				
				// Tell the user that this Tenant has paid nothing 
				System.out.println("Total paid: Nothing\n\n");
				
				// And continue to the next loop iteration, skipping the rest of below logic
				continue;
			}
			else 
			{
				// Otherwise, if we are here, we know the Tenant has made payments
				System.out.printf("Total paid: %.2f%n%n", payments.calculateTotalPaid());
		
			}
		}
		
		// Print a newline to standard output
		System.out.println();
		
	}
	
	public static void getTotalPaymentsHostel(TenantList tenantlist)
	{
		
		// Initialize local double variable hostelPayments to hold summed payments
		double hostelPayments = 0.0;
		
		// Begin for-loop, looping over each Tenant in TenantList tenantlist
		for (int count = 0; count < tenantlist.getTotal(); count++)
		{
			
			// Assign local Tenant variable currentTenant to tenantlist.getTenant(count)
			// This allows us to work with each Tenant 
			Tenant currentTenant = tenantlist.getTenant(count);
			
			// Add the total paid of the current Tenant object to hostelPayments variable 
			hostelPayments += currentTenant.getPayments().calculateTotalPaid();
		}
		
		// Output to the user the total payments that have been made to the hostel 
		System.out.printf("%nTotal payments made to hostel: %.2f%n%n", hostelPayments);
	}
	
	public static void main(String[] args)
	{
		
		// Initialise TenantList tenantlist variable with capacity of 20
		TenantList tenantlist = new TenantList(20);
		
		// Initialize Scanner scanner variable passing in System.in (stdin)
		Scanner scanner = new Scanner(System.in);
		
		// Initialize local integer variable option and set to 0
		int option = 0;
		
		// Begin while-loop
		while (option == 0)
		{
			
			// List number of options to the user 
			System.out.println("1. Add a Tenant");
			System.out.println("2. List all Tenants");
			System.out.println("3. Add a payment");
			System.out.println("4. List all payments");
			System.out.println("5. Remove a Tenant");
			System.out.println("6. Get number of payments made (per Tenant)");
			System.out.println("7. Get total payments made (per Tenant)");
			System.out.println("8. Get total payments made for the entire hostel");
			System.out.println("9. Quit");
			
			// Get the next integer from the user 
			option = scanner.nextInt();
			
			// Call scanner.nextLine() to flush stdin 
			scanner.nextLine();
			
			// Switch-case statement start, checking option variable value 
			switch (option)
			{
				// If user entered 1:
				case 1: 
					// Call addTenant method passing in Scanner scanner and TenantList tenantlist 
					addTenant(scanner, tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break; 
				case 2:
					// Call listTenants method, passing in TenantList tenantlist
					listTenants(tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break;
				case 3:
					// Call addPayment method, passing in Scanner scanner and TenantList tenantlist
					addPayment(scanner, tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break;
				case 4: 
					// Call listPayments method, passing in TenantList tenantlist 
					listPayments(tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break;
				case 5:
					// Call removeTenant method, passing in Scanner scanner and TenantList tenantlist
					removeTenant(scanner, tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break;
				case 6:
					// Call getNumPayments method, passing in TenantList tenantlist
					getNumPayments(tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break;
				case 7:
					// Call getTotalPayments method, passing in TenantList tenantlist
					getTotalPayments(tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break;
				case 8:
					// Call getTotalPaymentsHostel method, passing in TenantList tenantlist 
					getTotalPaymentsHostel(tenantlist);
					
					// Break out of switch-case as we are done handling option value
					break;
				case 9:
					// Break out of switch-case as the user wishes to exit
					break;
			}
			
			// If the value of option is not 9 (quit):
			if (option != 9)
				// Set option back to 0, staying in the while-loop
				option = 0;
		}
	}
}
