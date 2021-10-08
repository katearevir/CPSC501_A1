package bank;

import java.util.List;
import java.util.ArrayList;

public class Customer {

	private String name;
	private int customerID;
	private List<Customer> customers = new ArrayList<Customer>();
	
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
	
	public void addCustomerToCollection(Customer c){
        customers.add(c);
    }

	public Customer getCustomerFromCollection(int id){
        for(int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getID() == id)
            {
                return customers.get(i);
            }
        }
        return null;
    }

	/*
	public static void main(String[] args) {
		Customer c = new Customer();
		String actualName = c.getName();
		int actualCustomerID = c.getID();
	}
	*/
}