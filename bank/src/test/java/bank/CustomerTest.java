package bank;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

public class CustomerTest {
    
    @Test
    public void testAddCustomersToCollection_AndGetCustomer(){
        Customer c1 = new Customer("John Doe", 314);
        Customer c2 = new Customer("Jane Doe", 123);
        List<Customer> collection = new ArrayList<Customer>();
        collection.add(c1);
        collection.add(c2);

        Customer cc = new Customer(collection);

        assertEquals("John Doe 314", cc.getCustomerFromCollection(314).toString());
    }

    @Test
    public void testNoCustomerWithIDInCollection(){
        Customer c1 = new Customer("John Doe", 314);
        Customer c2 = new Customer("Jane Doe", 123);
        List<Customer> collection = new ArrayList<Customer>();
        collection.add(c1);
        collection.add(c2);
        Customer cc = new Customer(collection);
        assertEquals(null, cc.getCustomerFromCollection(200));
    }

}
