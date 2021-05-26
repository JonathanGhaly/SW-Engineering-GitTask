/** A Client Class for banking system
 * @author Jonathan Saad
 * @version 1.00 April 16,2021
 * Course: Software Engineering 1 CS251 2020/2021 - Homework 2
 * Represents Balance and Account number of normal bank account.
 */

public class Account {
    /**
     * The account's balance.
     * Account's id.
     * counter that add the account number automated.
     *
     */
    protected double balance;
    private int accountNum;
    private static int accountNumCount;

    /**
     * Creates a new Account.
     * The account balance is set to zero.
     * Account number is increment then gives the Account id.
     *
     */
    public Account() {
        this.balance = 0;
        accountNumCount += 1;
        accountNum = accountNumCount;
    }

    /**
     * Set the Account balance with the given Value.
     *
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Set the Account Number with the given Value.
     * The Account number must be positive and non-zero.
     *
     * @param accountNum account number will changed to.
     */
    public void setAccountNum(int accountNum) {
        if (accountNum < 1) {
            System.out.println ("Invalid account number");
        } else {
            this.accountNum = accountNum;
        }
    }

    /**
     * Gets the balance of the Account.
     *
     * @return this Account's balance.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Gets the ID (Number) of the Account.
     *
     * @return this Account's ID (Number).
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * overrides toString() function.
     *
     * @return the Account's data.
     */
    @Override
    public String toString() {
        String accountData = "Balance: " + this.balance + "\nAccount number: " + accountNum;
        return accountData;
    }

    /**
     * Withdraw money from account's balance.
     *
     * @param drawMoney the amount of money withdrawn from the account.
     * @throws RuntimeException if drawMoney is more than in the Account's balance.
     * @throws RuntimeException if drawMoney is less than or equal zero.
     */
    public void withdraw(double drawMoney) throws RuntimeException {
        if (drawMoney <= 0) {
            RuntimeException e = new RuntimeException ("invalid input");
            throw (e);
        }
        if (this.balance >= drawMoney) {
            this.balance -= drawMoney;
            System.out.println ("Operation completed successfully");
        } else {
            RuntimeException e = new RuntimeException ("Insufficient funds");
            throw (e);
        }
        System.out.println ("Balance: " + this.balance);
    }

    /**
     * Add amount of money to Account's balance.
     *
     * @param moneyToDeposit the amount of money added to the account's balance.
     * @throws RuntimeException if moneyToDeposit is zero or negative number.
     */
    public void deposit(double moneyToDeposit) throws RuntimeException {
        if (moneyToDeposit > 0) {
            this.balance += moneyToDeposit;
            System.out.println ("Operation completed successfully");
        } else {
            throw new RuntimeException ("Deposit is less than 0");
        }
        System.out.println ("Balance: " + this.balance);
    }
}


