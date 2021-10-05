
public class SavingsAccount extends BankAccount {

	// instance variables
	private double annualInterestRate;
	private double minimumBalance;

	// constructors
	public SavingsAccount() {
		annualInterestRate = 0.05;
		minimumBalance = 0.0;
	}

	public SavingsAccount(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public SavingsAccount(double balance, double annualInterestRate) {
		super(balance);
		this.annualInterestRate = annualInterestRate;
	}

	public SavingsAccount(Customer c, double initialBalance) {
		super(c, initialBalance);
		this.annualInterestRate = 0.05;
	}

	public SavingsAccount(Customer c, double balance, double annualInterestRate) {
		super(c, balance);
		this.annualInterestRate = annualInterestRate;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/**
	transfer: This method takes in an amount and an account to transfer to. It makes sure that the balance
	in the account to transfer from has sufficient funds and then subtracts the amount from the current account
	and then adds the amount to the new account in the parameter.
	*/
	public void transfer(double amount, BankAccount account) {
		if (sufficientFunds(amount) == true) {
			account.deposit(amount);
			withdraw(amount);
		}
	}

	//refactored: replace temp with query
	double balance(double amount) {
		return super.getBalance() - amount;
	}

	/**
	 * withdraw: This method takes in an amount, makes sure that there are
	 * sufficient funds in the balance to withdraw from.
	 */
	@Override
	public void withdraw(double amount) {
		if (balance(minimumBalance) < amount) {
			super.withdraw(0.0);
		} else if (amount <= balance(0) && amount > 0) {
			super.withdraw(amount);
		}
	}

	public void setAnnualInterestRate(double a) {
		if (a < 0 || a > 1) {
			this.annualInterestRate = 0.05;
		} else {
			this.annualInterestRate = a;
		}
	}

	public void setMinimumBalance(double b) {
		this.minimumBalance = b;
	}

	/**
	 * calculates the monthly interest for balance and returns it.
	 */
	@Override
	protected double getMonthlyFeesAndInterest() {
		return annualInterestRate / 12 * balance(0);
	}

	public static void main(String[] args) {
	}

}