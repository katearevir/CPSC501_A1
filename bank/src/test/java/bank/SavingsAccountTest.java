package bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class SavingsAccountTest {
    
    //refactorings affected withdraw, getMonthlyFeesAndInterest, and transfer

    @Test
    public void testWithdrawMoreThanMinimumBalance() 
    {
        Customer c = new Customer("John Doe", 123);
        SavingsAccount sAccount = new SavingsAccount(c, 1000);
        sAccount.setMinimumBalance(20);
        sAccount.withdraw(1000);
        assertEquals(1000, sAccount.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawLessThanMinimumBalance() 
    {
        Customer c = new Customer("John Doe", 123);
        SavingsAccount sAccount = new SavingsAccount(c, 1000);
        sAccount.setMinimumBalance(20);
        sAccount.withdraw(980);
        assertEquals(20, sAccount.getBalance(), 0.001);
    }

    @Test
    public void testGetMonthlyFeesAndInterest()
    {
        Customer c = new Customer("John Doe", 123);
        SavingsAccount sAccount = new SavingsAccount(c, 1000); //annual interest = 0.05

        //annualInterestRate / 12 * balance;
        double monthlyFeesAndInterest = 4.167;
        assertEquals(monthlyFeesAndInterest, sAccount.getMonthlyFeesAndInterest(), 0.001);

    }

    @Test
    public void testTransfer() 
    {
        Customer c = new Customer("John Doe", 123);
        ChequingAccount cAcc = new ChequingAccount(c, 50, 10);
        SavingsAccount sAcc = new SavingsAccount(c, 1000);

        sAcc.transfer(30, cAcc);
        
        //Test SavingsAccount balance
        assertEquals(970, sAcc.getBalance(), 0.001);

        //Test ChequingAccount balance
        assertEquals(80, cAcc.getBalance(), 0.001);
    }

}
