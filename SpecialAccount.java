/**
 * A Client Class for banking system
 *
 * @author Jonathan Saad
 * @version 1.00 April 16,2021
 * Course: Software Engineering 1 CS251 2020/2021 - Homework 2
 * Account has special features.
 */

public class SpecialAccount extends Account {
    /**
     * Withdraw money from account's balance but it can be more than that in the balance.
     *
     * @param drawMoney the amount of money withdrawn.
     * @throws RuntimeException if Account's balance -  drawMoney less than -1000.
     * @throws RuntimeException if drawMoney is less than or equal zero.
     */
    public void withdraw(double drawMoney) throws RuntimeException {
        if (drawMoney <= 0) {
            RuntimeException e = new RuntimeException("invalid input");
            throw (e);
        }
        double diffTemp = this.balance - drawMoney;
        if (diffTemp >= -1000) {
            this.balance -= drawMoney;
            System.out.println("Operation completed successfully");
        } else {
            RuntimeException e = new RuntimeException("insufficient balance");
            throw (e);
        }
        System.out.println("Balance: " + this.balance);
    }
}
