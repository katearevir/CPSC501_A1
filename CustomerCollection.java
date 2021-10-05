import java.util.List;
import java.util.ArrayList;

public class CustomerCollection {
    private List<Customer> customers = new ArrayList<Customer>();

    public void addCustomer(Customer c){
        customers.add(c);
    }

    public Customer getCustomer(int id){
        for(int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getID() == id)
            {
                return customers.get(i);
            }
        }

        return null;
    }
}
