
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
	 * withdraw: This method takes in an amount, makes sure that there are
	 * sufficient funds in the balance to withdraw from.
	 */
	@Override
	public void withdraw(double amount) {
		//refactored: Introduce explaining variables
		final boolean amountWithdrawnMoreThanMinimumBalance = balance(minimumBalance) < amount;
		final boolean balanceMoreThanAmount = amount <= balance(0);
		final boolean amountIsNotNegative = amount > 0;

		if (amountWithdrawnMoreThanMinimumBalance) {
			super.withdraw(0.0);
		} else if (balanceMoreThanAmount && amountIsNotNegative) {
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