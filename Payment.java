public class Payment {
	
	// Initialize private String variable month 
	private String month;
	
	// Initialize private double variable amount 
	private double amount;
	
	// Payment default constructor
	public Payment()
	{
		
	}
	
	// Payment(String, double) constructor
	public Payment(String month, double amount)
	{
		this.month = month;
		this.amount = amount;
	}
	
	// getMonth() getter method
	// Used to retrieve reference of month 
	public String getMonth()
	{
		// Return the reference of private String variable month 
		return month;
	}
	
	// getAmount() getter method
	// Used to retrieve value of amount (amount paid in month)
	public double getAmount()
	{
		// Return the value of private double variable amount 
		return amount;
	}
	
	// toString() method
	// Used to create a nicely formatted String to the user, displaying Payment details
	public String toString()
	{
		return String.format("Month: %s%nAmount: %.2f%n", getMonth(), getAmount());
	}
	
	// print() method
	// Used to print the nicely formatted String variable from toString() method
	public void print()
	{
		
		// Output the return String object to standard output (stdout) from toString() 
		System.out.println(toString());
	}
}
