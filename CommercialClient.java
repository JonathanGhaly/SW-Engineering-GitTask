/**
 * A CommercialClient Class for banking system
 *
 * @author Mohamed Ashraf
 * @version 1.00 2021/16/4
 * Course: Software Engineering 1 CS251 2020/2021 - Homework 2
 */

public class CommercialClient extends Client {
    private String commercialID;

    /**
     * CommercialClient constructor
     *
     * @param name         is client's full name (String)
     * @param address      is client's address (String)
     * @param commercialID is client's Commercial ID (String)
     * @param phoneNumber  is client's phone number (String)
     * @param account      the account linked with this client (Account Object)
     */
    CommercialClient(String name, String address, String phoneNumber, String commercialID, Account account) {
        super(name, "00000000000000", address, phoneNumber, account);
        this.commercialID = commercialID;
    }

    /**
     * From CommercialClient object to string object
     *
     * @return String version of the CommercialClient with all information within
     */
    @Override
    public String toString() {
        return "Commercial Client\n" +
                "Name: " + super.getName() + '\n' +
                "CommercialID: " + commercialID + '\n' +
                "Address: " + super.getAddress() + '\n' +
                "Phone: " + super.getPhone() + '\n' +
                "Account: " + super.getAccount();
    }

    /////////// Setters & Getters ///////////

    /**
     * @return String object containing the client's Commercial ID
     */
    public String getCommercialID() {
        return commercialID;
    }

    /**
     * Changes the name of the client
     *
     * @param commercialID String object containing new commercial ID of client
     */
    public void setCommercialID(String commercialID) {
        this.commercialID = commercialID;
    }
}
