package bank;

import java.util.List;
import java.util.ArrayList;

public abstract class BankAccount extends Customer {

	// Instance variables
	private double balance;
	private String accountNumber;
	private Customer accountHolder;
	private List<ChequingAccount> cAccs = new ArrayList<ChequingAccount>();
    private List<SavingsAccount> sAccs = new ArrayList<SavingsAccount>();

	// Constructors
	public BankAccount() {
		balance = 0.0;
		accountNumber = "1234";
	}

	public BankAccount(double initialBalance) {
		balance = initialBalance;
		accountNumber = "1234";
	}

	public BankAccount(double initialBalance, String accNum) {
		balance = initialBalance;
		accountNumber = accNum;
	}

	public BankAccount(Customer c, double initialBalance) {
		this.accountHolder = c;
		balance = initialBalance;
	}

	public BankAccount(BankAccount oldAccount) {
		balance = oldAccount.balance;
		accountNumber = oldAccount.accountNumber;
		setAccountHolder(oldAccount.accountHolder);

	}

	/**
	 * deposit: This method takes in an amount, makes sure the amount is not a
	 * negative amount, and adds it to this.balance
	 */
	public void deposit(double amount) {
		if (amount >= 0) {
			balance = balance + amount;
		}
	}

	/**
	 * withdraw: This method takes in an amount, makes sure it is not a negative
	 * amount and also that there are sufficient funds in the balance to withdraw
	 * from.
	 */
	public void withdraw(double amount) {
		if (sufficientFunds(amount) == true) {
			balance = balance - amount;
		}
	}

	public void setAccountHolder(Customer x) {
		this.accountHolder = x;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public List<ChequingAccount> getChequingAccs(){
		return cAccs;
	}

	public List<SavingsAccount> getSavingsAccs(){
		return sAccs;
	}

	//refactored: replace temp with query
	//refactored: pull up method
	double balance(double amount) {
		return getBalance() - amount;
	}

	/**
	transfer: This method takes in an amount and an account to transfer to. It makes sure that the balance
	in the account to transfer from has sufficient funds and then subtracts the amount from the current account
	and then adds the amount to the new account in the parameter.
	*/
	//refactored: pull up method
	public void transfer(double amount, BankAccount account) {
		if (sufficientFunds(amount) == true) {
			account.deposit(amount);
			withdraw(amount);
		}
	}

	@Override
	public String toString() {
		return "(" + accountHolder + ") " + accountNumber + ": " + balance;
	}

	public Customer getAccountHolder() {
		return this.accountHolder;
	}

	// abstract method
	protected abstract double getMonthlyFeesAndInterest();

	/**
	 * Calls getMonthlyFeesAndInterest and updates the balance by the amount
	 * returned.
	 */
	public void monthEndUpdate() {
		double amount = getMonthlyFeesAndInterest();
		if (amount < 0) {
			balance += amount;
		} else {
			balance += amount;
		}
	}

	/**
	 * Takes an amount value and checks if there is sufficient funds in the account
	 * to withdraw the specified amount.
	 */
	public boolean sufficientFunds(double amount) {
		if (amount <= balance && amount > 0) {
			return true;
		} else {
			return false;
		}
	}

	//refactored: Move method
	public void addChequingAccountToCollection(ChequingAccount cAcc){
		//Check if not duplicate
		Customer check = getChequingAccountFromCollection(cAcc.getAccountHolder());
		if (check == null)
        	cAccs.add(cAcc);
    }

    public void addSavingsAccountToCollection(SavingsAccount sAcc){
        //check if not duplicate
		Customer check = getSavingsAccountFromCollection(sAcc.getAccountHolder());
		if (check == null)
			sAccs.add(sAcc);
    }

    public ChequingAccount getChequingAccountFromCollection(Customer c){
        for(int i = 0; i < cAccs.size(); i++)
        {
            if (cAccs.get(i).getAccountHolder().equals(c))
            {
                return cAccs.get(i);
            }
        }
        return null;
    }

    public SavingsAccount getSavingsAccountFromCollection(Customer c){
        for(int i = 0; i < sAccs.size(); i++)
        {
            if(sAccs.get(i).getAccountHolder().equals(c))
            {
                return sAccs.get(i);
            }
        }

        return null;
    }

	public static void main(String[] args) {

	}
}
