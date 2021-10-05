
public class Customer {

	private String name;
	private int customerID;
	
	public Customer() {
		
	}

	public Customer(Customer c) {
		this.name = c.getName();
		this.customerID = c.getID();
	}
	
	public Customer(String nam, int custID) {
		setName(nam);
		setCustomerID(custID);
		
	}
	
	public void setName(String x) {
		this.name = x;
	}
	public void setCustomerID(int cID) {
		this.customerID = cID;
	}
	
	public String getName() {
		return this.name;
	} 
	public int getID() {
		return this.customerID;
	}
	public String toString() {
		return name + " " + customerID;
	}
	
	/*
	public static void main(String[] args) {
		Customer c = new Customer();
		String actualName = c.getName();
		int actualCustomerID = c.getID();
	}
	*/
}