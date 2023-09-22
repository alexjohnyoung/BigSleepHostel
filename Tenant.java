public class Tenant {
	
	// Initialize final private static int maxNoOfPayments as we know it won't change
	final private static int maxNoOfPayments = 12;
	
	// Initialize private String variable name 
	private String name;
	
	// Initialize private int variable room 
	private int room;
	
	// Initialize private PaymentList variable payments 
	private PaymentList payments;
	
	// Tenant default constructor
	public Tenant()
	{
		
	}
	
	// Tenant(String, int) constructor
	public Tenant(String name, int room)
	{
		
		// Assign value of private String variable name to reference of String object name 
		this.name = name;
		
		// Assign value of private int variable room to value of local varaible room 
		this.room = room;
		
		// Create new PaymentList object, passing in size of maxNoOfPayments (12)
		payments = new PaymentList(maxNoOfPayments);
	}
	
	// getName() getter method
	// Used to return Tenant name to the user 
	public String getName()
	{
		// Return String reference variable 'name'
		return name;
	}
	
	// getRoom() getter method
	// Used to return value of private instance variable room to the user 
	public int getRoom()
	{
		// Return the value of private instance variable room 
		return room;
	}
	
	// makePayment(Payment) method
	// Used to make a payment 
	public void makePayment(Payment payment)
	{
		
		// If we have too many payments:
		if (getPayments().getTotal() >= maxNoOfPayments)
			// Return here to end execution, as we don't need more payments
			return;
		
		// If we are here, we are okay to add the new Payment to 
		payments.add(payment);
		
		// Print a newline to standard output
		System.out.println();
		
		// Tell the user that this Tenant has made a payment
		System.out.printf("Tenant %s made a payment of %.2f!%n", getName(), payment.getAmount());
		
		// Print a newline to standard output
		System.out.println();
	}
	
	// getPayments() getter method
	// Used to return the Tenants PaymentList payments
	public PaymentList getPayments()
	{
		// Return the reference to the Tenant objects PaymentList, payments
		return payments;
	}
	
	// toString() method
	// Used to nicely format a String containing Tenant details
	public String toString()
	{
		// Return a nicely formatted String containing Tenant details
		return String.format("Tenant %s -> Room %d%n", getName(), getRoom());
	}
	
	// print() method
	// Used to print nicely formatted String from toString() to standard output
	public void print()
	{
		System.out.println(toString());
	}
}
