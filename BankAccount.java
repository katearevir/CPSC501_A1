
public abstract class BankAccount extends Customer {

	// Instance variables
	private double balance;
	private String accountNumber;
	private Customer accountHolder;
	// add account type

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

	public static void main(String[] args) {

	}
}
