public class PaymentList extends ObjectList {
	
	// PaymentList default constructor
	public PaymentList()
	{
		
	}
	
	// PaymentList(int) constructor
	public PaymentList(int size)
	{
		
		// Call the superclass constructor, passing value of size local variable
		super(size);
	}
	
	// getPayment(int) method
	// Used to get chosen Payment object 
	public Payment getPayment(int numPayment)
	{
		// Return the result of calling the superclass (ObjectList) getObject method, passing in numPayment 
		return (Payment)super.getObject(numPayment);
	}
	
	// calculateTotalPaid() method
	// Used to calculate the total amount paid altogether from each held Payment object
	public double calculateTotalPaid()
	{
		// Initialize double local variable 'total' to hold our sum of payments
		double total = 0;
		
		// Begin-for-loop, looping each Payment object in PaymentList list 
		for (int index = 0; index < super.getTotal(); index++)
			// Add the value of each Payment amount to double variable total
			total += getPayment(index).getAmount();
		
		// Return the total amount paid to the user
		return total;
	}
}
