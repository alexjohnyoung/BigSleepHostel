import java.util.Arrays;

public class ObjectList {

	// private Object[] instance variable 'list'
	private Object[] list;
	
	// private int instance variable 'total' 
	private int total;
	
	// default constructor 
	public ObjectList()
	{
	}
	
	// ObjectList(int) constructor 
	// Dynamically allocates 'list' array to size of 'size' local variable 
	public ObjectList(int size)
	{
		this.list = new Object[size];
	}
	
	// ObjectList.add method (Object)
	// Returns true if successful
	public boolean add(Object object)
	{
		
		// If the array is full:
		if (isFull()) {
			
			// Return false as we were not able to add this Object to the array 
			return false;
		}
		
		int totalEntries = getTotal();
		
		// Assign the current total in that position of Object[] array variable 'list'
		list[totalEntries] = object;
		
		// Increment 'total' variable by 1, as we have just added an Object into 'list'
		total++;
		
		// Return true as the add was successful
		return true;
	}
	
	// ObjectList.remove method (int objectID)
	// Returns true if successful
	public boolean remove(int objectID)
	{
		
		// If the array is empty:
		if (isEmpty())	
			// Return false as we cannot remove an element in the array that does not exist
			return false;
		
		// Initialize local variable totalEntries to getTotal()
		int totalEntries = getTotal();
		
		// Begin for-loop, starting at the position we removed
		for (int index = objectID; index < totalEntries; index++)
			// Append the value of the next position to the position we are at
			// This will allow us to shift the list properly
			list[index] = list[index+1];
		
		// Decrement total variable as we have removed a Tenant 
		total--;
		
		// Return true as the remove operation was successful 
		return true;
	}
	
	// ObjectList.getObject method (int itemNo)
	// Returns item at index 'itemNo' of list instance variable 
	public Object getObject(int itemNo)
	{
		
		// Return the Object located at the index 'itemNo' of 'list' Object[] variable 
		return list[itemNo];
	}
	
	// ObjectList.getTotal() method 
	// Returns total number of entries in the 'list' instance variable array
	public int getTotal() 
	{
		// Return the total amount of Objects in the array using 'total' int instance variable 
		return total;
	}
	
	// ObjectList.isFull() method 
	// Returns true if the 'list' array is full 
	public boolean isFull() 
	{
		// Return true if the 'list' array is not empty and total is greater than or equal to the maximum length of the Object[] array 
		return !isEmpty() && total >= list.length;
	}
	
	// ObjectList.isEmpty() method 
	// Returns true if the 'list' array is empty 
	public boolean isEmpty() 
	{
		// Return true as there are no Object objects in the array if 'total' is 0
		return total == 0;
	}
}
