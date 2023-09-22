// We are using extends keyword to inherit from ObjectList 
public class TenantList extends ObjectList {
	
	// TenantList default constructor
	public TenantList()
	{
		
	}
	
	// TenantList(int) constructor
	public TenantList(int size)
	{
		// Call the superclass ObjectList constructor, passing value of local variable size 
		super(size);
	}
	
	// getTenant(int numTenant) method
	// Used to retrieve Tenant object with Object ID tenantID
	public Tenant getTenant(int tenantID)
	{
		// Return the return result of the superclass (ObjectList) getObject method
		return (Tenant)super.getObject(tenantID);
	}
	
	// search(int numTenant) method
	// Used to retrieve Tenant reference, passing Object ID tenantID
	public Tenant search(int tenantID)
	{
		// Return the return result of the superclass (ObjectList) getObject method 
		return (Tenant)super.getObject(tenantID);
	}
	
	// removeTenant(int) method
	// Used to remove a Tenant from the TenantList 
	public boolean removeTenant(int numTenant)
	{
		// Return the return result of the superclass (ObjectList) remove method
		return super.remove(numTenant);
	}
}
