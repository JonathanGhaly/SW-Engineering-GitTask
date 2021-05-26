/*
 * Author: Kareem Mohamed Morsy Ismail
 * Date: 16/04/2021
 */

import java.util.ArrayList;

/**
 * A Class representing a Bank
 *
 * @author Kareem Morsy
 * @version 1.00 2021/04/16
 * Course: Software Engineering 1 CS251 2020/2021 - Homework 2
 */
public class Bank {
    /**
     * Name of the bank
     */
    private String name;
    /**
     * Address of the bank
     */
    private String address;
    /**
     * Bank's phone number
     */
    private String phone;

    /**
     * ArrayList of accounts registered in the bank
     */
    private final ArrayList<Account> accountList = new ArrayList<>();
    /**
     * ArrayList of clients registered in the bank
     */
    private final ArrayList<Client> clientsList = new ArrayList<>();

    /**
     * The constructor of the bank class
     *
     * @param name    Bank's name
     * @param address Bank's address
     * @param phone   Bank's phone number
     */
    public Bank(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Name getter
     *
     * @return The name of the bank
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter
     *
     * @param name The new name of the bank
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Address getter
     *
     * @return The address of the bank
     */
    public String getAddress() {
        return address;
    }

    /**
     * Address setter
     *
     * @param address The new address of the bank
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Phone getter
     *
     * @return The phone of the bank
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Phone setter
     *
     * @param phone The new phone of the bank
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * A function to register a new client to the bank
     *
     * @param client  The client object to be registered
     * @param account The client's account object to be registered with the client
     */
    public void addClient(Client client, Account account) {
        clientsList.add(client);
        accountList.add(account);
    }

    /**
     * A function to show all registered clients in the bank object
     *
     * @return A string with all clients in the bank
     */
    public String displayClients() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < clientsList.size(); i++) {
            builder.append("==========================\n");
            builder.append(i + 1).append("-");
            builder.append("Client:\n");
            builder.append(clientsList.get(i).toString());
            builder.append("\n");
            builder.append("Account:\n");
            builder.append(accountList.get(i).toString());
            builder.append("\n");
        }

        return builder.toString();
    }

    /**
     * A function to search a client by his national id
     *
     * @param id National id of the client
     * @return A client object with national ID = id. null if not found
     */
    public Client getClientByAccountId(int id) {
        for (Client client : clientsList) {
            if (client.getAccount().getAccountNum() == id) {
                return client;
            }
        }

        return null;
    }
}
