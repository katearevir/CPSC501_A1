import java.lang.Math;

public class ChequingAccount extends BankAccount {
	// instance variables
	private double overdraftFee;
	private double overdraftAmount;

	// constructors
	public ChequingAccount(Customer accountHolder, double startBalance, double overdraftFee) {
		super(accountHolder, startBalance);
		this.overdraftFee = overdraftFee;
	}

	public void setOverdraftFee(double fee) {
		if (fee >= 0)
			this.overdraftFee = fee;
	}

	public Double getOverdraftFee() {
		if (overdraftFee < 0) {
			return 1.0;
		} else {
			return overdraftFee;
		}
	}

	public void setOverdraftAmount(double fee) {
		if (fee >= 0)
			this.overdraftAmount = fee;
	}

	public Double getOverdraftAmount() {
		return overdraftAmount;
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

	// Overridden methods

	/**
	 * Returns true if the amount specified (for withdrawal) will result in a
	 * balance that might be less than zero, but never more than overdraftAmount
	 * below zero.
	 */
	@Override
	public boolean sufficientFunds(double amount) {
		double abs = Math.abs(balance(amount));
		if (balance(amount) >= 0 || balance(amount) <= 0 && abs <= overdraftAmount) { 
			return true;
		} 
		else {
			return false;
		}

	}

	/**
	 * It updates the amount to withdraw to add the overdraftFee if the withdraw
	 * would result in a negative balance.
	 */
	@Override
	public void withdraw(double amount) {
		if (balance(amount) < 0) {
			amount += overdraftFee;
			super.withdraw(amount);
		} else
			super.withdraw(amount);

	}

	/**
	 * It returns 0 if the balance is greater than or equal to zero but returns 20%
	 * of the balance if the balance is less than zero.
	 */
	@Override
	protected double getMonthlyFeesAndInterest() {
		if (balance(0) >= 0) {
			return 0.0;
		} else {
			double change = 0.2 * balance(0);
			return change;
		}
	}
}