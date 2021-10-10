package bank;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    
    // refactoring added collection methods, 
    // balance (tested in ChequingAccountTest & SavingsAccountTest), 
    // and transfer (tested in ChequingAccountTest & SavingsAccountTest)

    public class BankAccClass extends BankAccount
    { 
        public BankAccClass(){};
        public BankAccClass(double initialBalance){super(initialBalance);}
        public BankAccClass(double initialBalance, String accountNumber) {super(initialBalance,accountNumber);}
        public BankAccClass(Customer c, double initialBalance){super(c,initialBalance);}
        public BankAccClass(BankAccount acc){super(acc);}
        double amount = 0.0;
        protected double getMonthlyFeesAndInterest() 
        { 
            return amount;
        }
    }

    @Test
    public void testAddAndGetChequingAccountToCollection()
    {
        Customer c1 = new Customer("John Doe", 123);
        Customer c2 = new Customer("Jane Doe", 321);
        ChequingAccount john = new ChequingAccount(c1, 1000, 10);
        ChequingAccount jane = new ChequingAccount(c2, 1000, 10);
        BankAccount b = new BankAccClass();

        b.addAccountToCollection(john);
        b.addAccountToCollection(jane);

        assertEquals(john, b.getChequingAccountFromCollection(c1));
        assertEquals(jane, b.getChequingAccountFromCollection(c2));
    }

    @Test
    public void testDuplicateCustomersInChequingCollection()
    {
        Customer c1 = new Customer("John Doe", 123);
        Customer c2 = new Customer("John Doe", 123);
        ChequingAccount john1 = new ChequingAccount(c1, 1000, 10);
        ChequingAccount john2 = new ChequingAccount(c2, 1000, 10);
        BankAccount b = new BankAccClass();

        b.addAccountToCollection(john1);
        b.addAccountToCollection(john2);

        //only adds the first John Doe
        assertEquals(1, b.getChequingAccs().size());
    }


    @Test
    public void testAddAndGetSavingsAccountToCollection()
    {
        Customer c1 = new Customer("John Doe", 123);
        Customer c2 = new Customer("Jane Doe", 321);
        SavingsAccount john = new SavingsAccount(c1, 1000);
        SavingsAccount jane = new SavingsAccount(c2, 1000);
        BankAccount b = new BankAccClass();

        b.addAccountToCollection(john);
        b.addAccountToCollection(jane);
        
        assertEquals(john, b.getSavingsAccountFromCollection(c1));
        assertEquals(jane, b.getSavingsAccountFromCollection(c2));
    }

    @Test
    public void testDuplicateCustomersInSavingsCollection()
    {
        Customer c1 = new Customer("John Doe", 123);
        Customer c2 = new Customer("John Doe", 123);
        SavingsAccount john1 = new SavingsAccount(c1, 1000, 10);
        SavingsAccount john2 = new SavingsAccount(c2, 1000, 10);
        BankAccount b = new BankAccClass();

        b.addAccountToCollection(john1);
        b.addAccountToCollection(john2);

        //only adds the first John Doe
        assertEquals(1, b.getSavingsAccs().size());
    }

    @Test
    public void testAddAndGetChequingSavingsToCollection()
    {
        Customer c1 = new Customer("John Doe", 123);
        Customer c2 = new Customer("Jane Doe", 321);
        ChequingAccount john = new ChequingAccount(c1, 1000, 10);
        SavingsAccount jane = new SavingsAccount(c2, 1000);
        BankAccount b = new BankAccClass();

        b.addAccountToCollection(john);
        b.addAccountToCollection(jane);
        
        assertEquals(john, b.getChequingAccountFromCollection(c1));
        assertEquals(jane, b.getSavingsAccountFromCollection(c2));
    }


}
