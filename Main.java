import java.util.Scanner;

/**
 * The entry class of the banking system
 *
 * @author Mohamed Ashraf, Kareem Morsy, Jonathan Saad.
 * @version 1.00 2021/16/4
 * Course: Software Engineering 1 CS251 2020/2021 - Homework 2
 */
public class Main {
    private static Bank bank;
    private static Scanner inputScanner;

    /**
     * The entry point function of the system
     */
    public static void main(String[] args) {
        bank = new Bank(
                "National Bank of Egypt",
                "NBE Tower, 1187 Corniche El Nile St., Boulak, Cairo, Egypt",
                "19623");
        inputScanner = new Scanner(System.in);

        System.out.println("Welcome to NBE");
        bankMenu();
    }

    /**
     * The function responsible for the bank main menu
     */
    public static void bankMenu() {
        boolean isInMenu = true;
        while (isInMenu) {
            System.out.println("Choose the operation you want to do:");
            System.out.println("1- Add a client");
            System.out.println("2- Display all clients");
            System.out.println("3- Search client by account id");
            System.out.println("4- Quit");

            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1 -> addAccount();
                case 2 -> System.out.println(bank.displayClients());
                case 3 -> {
                    System.out.println("Enter account ID to search:");
                    inputScanner.nextLine();
                    openAccount(inputScanner.nextInt());
                }
                case 4 -> isInMenu = false;
            }
        }
    }

    /**
     * The function responsible for adding account menu
     */
    public static void addAccount() {
        Client client = null;
        Account account = null;

        System.out.println("Choose the type of the client's account:");
        System.out.println("1- Normal Account");
        System.out.println("2- Special account");
        int choice = inputScanner.nextInt();
        switch (choice) {
            case 1 -> account = new Account();
            case 2 -> account = new SpecialAccount();
            default -> {
                return;
            }
        }

        System.out.println("Choose the type of the client:");
        System.out.println("1- Normal client");
        System.out.println("2- Commercial client");
        choice = inputScanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Please enter the following information in order (space separated):");
                System.out.println("Full name, national ID, address, phone number");
                inputScanner.nextLine();
                String input = inputScanner.nextLine();
                //TODO fix address can't have spaces

                String[] values = input.split(" ");
                try {
                    client = new Client(values[0], values[1], values[2], values[3], account);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            case 2 -> {
                System.out.println("Please enter the following information in order (space separated):");
                System.out.println("Full name, address, phone number, commercial ID");
                inputScanner.nextLine();
                String input = inputScanner.nextLine();
                //TODO fix address can't have spaces

                String[] values = input.split(" ");
                client = new CommercialClient(values[0], values[1], values[2], values[3], account);
            }
            default -> {
                return;
            }
        }
        System.out.println(client);
        System.out.println(account);
        bank.addClient(client, account);
    }

    /**
     * The function responsible for account menu
     * @param AccountId AccountID to search for
     */
    public static void openAccount(int AccountId) {
        boolean isInMenu = true;
        Client clientSearched = bank.getClientByAccountId(AccountId);
        if (clientSearched == null) {
            System.out.println("Wrong national ID or client doesn't exist");
            return;
        }
        Account accountSearched = clientSearched.getAccount();

        while (isInMenu) {
            System.out.println("Choose the operation you want to do:");
            System.out.println("1- Deposit Money");
            System.out.println("2- Withdraw Money");
            System.out.println("3- Edit client information");
            System.out.println("4- Show account's data");
            System.out.println("5- Show client's data");
            System.out.println("6- Return to bank menu");

            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("How much do you want to deposit?");
                    double depositMoney = inputScanner.nextDouble();
                    try {
                        accountSearched.deposit(depositMoney);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("How much do you want to withdraw?");
                    double withdrawMoney = inputScanner.nextDouble();
                    try {
                        accountSearched.withdraw(withdrawMoney);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    editClientInfo(clientSearched);
                }
                case 4 -> System.out.println(accountSearched);
                case 5 -> System.out.println(clientSearched);
                case 6 -> isInMenu = false;
            }
        }
    }

    /**
     * The function that is responsible of editing client object
     * @param  client Client object to edit
     */
    public static void editClientInfo(Client client) {
        System.out.println("Choose what you want to update");
        System.out.println("1- Name");
        System.out.println("2- Address");
        System.out.println("3- Phone number");
        int choice = inputScanner.nextInt();
        inputScanner.nextLine();
        switch (choice){
            case 1 -> {
                System.out.println("What is your new name?");
                client.setName(inputScanner.nextLine());
            }
            case 2 -> {
                System.out.println("What is your new address?");
                client.setAddress(inputScanner.nextLine());
            }
            case 3 -> {
                System.out.println("What is your new phone?");
                client.setPhone(inputScanner.nextLine());
            }
            default -> {
                System.out.println("Invalid input");
            }
        }
    }
}


