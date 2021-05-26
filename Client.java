/**
 * A Client Class for banking system
 *
 * @author Mohamed Ashraf
 * @version 1.00 2021/16/4
 * Course: Software Engineering 1 CS251 2020/2021 - Homework 2
 */

public class Client {
    private String name, nationalID, address, phone;
    private Account account;

    /**
     * Client constructor
     *
     * @param name        client's full name (String)
     * @param nationalID  client's national ID (String)
     * @param address     client's address (String)
     * @param phoneNumber client's phone number (String)
     * @param account     the account you would like to link to this client (Account Object)
     * @throws RuntimeException when national ID is not exactly 14 characters in length
     */
    Client(String name, String nationalID, String address, String phoneNumber, Account account)
            throws RuntimeException {
        this.name = name;
        this.address = address;
        this.phone = phoneNumber;
        this.account = account;
        if (nationalID.length() != 14) {
            RuntimeException e = new RuntimeException("Invalid national ID length");
            throw e;
        }
        this.nationalID = nationalID;
    }


    /**
     * From Client object to string object
     *
     * @return String version of the Client with all information within
     */
    @Override
    public String toString() {
        return "Normal Client\n" +
                "Name: " + name + '\n' +
                "NationalID: " + nationalID + '\n' +
                "Address: " + address + '\n' +
                "Phone: " + phone + '\n' +
                "Account: " + account;
    }

    /////////// Setters & Getters ///////////

    /**
     * @return String object containing the client's name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the client
     *
     * @param name String object containing new name of client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String object containing the client's national ID
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * Changes the national ID of the client
     *
     * @param nationalID String object containing new national ID of client
     * @throws RuntimeException when nationalID has an invalid length
     */
    public void setNationalID(String nationalID) {
        if (nationalID.length() != 14) {
            RuntimeException e = new RuntimeException("Invalid nationalID length");
            throw e;
        }
        this.nationalID = nationalID;
    }

    /**
     * @return String object containing the client's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Changes the address of the client
     *
     * @param address String object containing new address of client
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String object containing the client's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Changes the phone number of the client
     *
     * @param phone String object containing new phone number of client
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String object containing the client's bank account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Changes the phone number of the client
     *
     * @param account Account object containing new account of client
     */
    public void setAccount(Account account) {
        this.account = account;
    }
}
