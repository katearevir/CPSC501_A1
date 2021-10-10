package bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChequingAccountTest {

    //refactorings affected sufficientFunds, withdraw, getMonthlyFeesAndInterest, and transfer

    @Test
    public void testWithdrawSufficientBalance() 
    {
        Customer c = new Customer("John Doe", 123);
        ChequingAccount cAccount = new ChequingAccount(c, 1234.56, 10);
        cAccount.withdraw(12.34);
        assertEquals(1222.22, cAccount.getBalance(), 0.001);
    }
    
    @Test
    public void testWithdrawAmountIsMoreThanBalance() 
    {
        Customer c = new Customer("John Doe", 123);
        ChequingAccount cAcc = new ChequingAccount(c, 1000, 10);
        cAcc.setOverdraftAmount(50);
        cAcc.withdraw(1030);
        assertEquals(-40.0, cAcc.getBalance(), 0.001);
    }
    
    @Test
    public void testGetMonthlyFeesAndInterestZeroBalance() 
    {
        Customer c = new Customer("John Doe", 123);
        ChequingAccount cAcc = new ChequingAccount(c, 0.0, 10);

        assertEquals(0.0, cAcc.getMonthlyFeesAndInterest(), 0.001);
        //Test account balance (unchanged)
        assertEquals(0.0, cAcc.getBalance(), 0.001);
    }

    @Test
    public void testGetMonthlyFeesAndInterestNegativeBalance()
    {
        Customer c = new Customer("John Doe", 123);
        ChequingAccount cAcc = new ChequingAccount(c, -50, 10);
        System.out.println(cAcc.getBalance());
        assertEquals((0.2*-50), cAcc.getMonthlyFeesAndInterest(), 0.001);
    }
    
    @Test
    public void testTransfer() 
    {
        Customer c = new Customer("John Doe", 321);
        ChequingAccount cAcc = new ChequingAccount(c, 1000, 10);
        SavingsAccount sAcc = new SavingsAccount(c, 50);

        cAcc.transfer(30, sAcc);
        
        //Test ChequingAccount balance
        assertEquals(970, cAcc.getBalance(), 0.001);

        //Test SavingsAccount balance
        assertEquals(80, sAcc.getBalance(), 0.001);
    }
}