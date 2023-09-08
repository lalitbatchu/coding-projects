import java.util.*;

public class BankAccountProject {
    Locale locale = Locale.US;
    Currency cur1 = Currency.getInstance(locale);
    String symbol = cur1.getSymbol(locale);
    int accNum;
    int balance;
    String accName;
    int pin;
    String streetNum;
    String cityName;
    String stateName;
    int zipCode;

    //Creating Account Method
    public void createAcc(int accNum, String accName, int pin, String streetNum, String cityName, String stateName, int zipCode) {
        this.accNum = accNum;
        this.accName = accName;
        this.balance = 0;
        this.pin = pin;
        this.streetNum = streetNum;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipCode = zipCode;

        System.out.println("Account was created successfully!");
        System.out.println("----------------------------------------------");
        System.out.println(" ");

    }
    //Depositing Money Method
    public void depositMoney(String accName, int accNum, int pin, double depositAmount) {
        if(this.accNum != accNum) {
            System.out.println("You've entered the wrong account number. Please try again");
            System.out.println(" ");
        } else if (!this.accName.equals(accName)) {
            System.out.println("You've entered the wrong name. Please try again");
            System.out.println(" ");
        } else if(this.pin != pin) {
            System.out.println("You've entered the wrong pin. Please try again");
            System.out.println(" ");
        }else {
            this.balance += depositAmount;
            System.out.println("----------------------------------------------");
            System.out.println("Deposit is successful!");
            System.out.println("----------------------------------------------");
            System.out.println(" ");
        }

    }

    //Withdrawing Money Method
    public void withdrawMoney(String accName, int accNum, int pin, double withdrawAmount) {
        if(this.accNum != accNum) {
            System.out.println("You've entered the wrong account number. Please try again");
            System.out.println(" ");
        } else if (!this.accName.equals(accName)) {
            System.out.println("You've entered the wrong name. Please try again");
            System.out.println(" ");
        } else if(this.pin != pin) {
            System.out.println("You've entered the wrong pin. Please try again");
            System.out.println(" ");
        }else {
            if (this.balance >= withdrawAmount) {
                this.balance -= withdrawAmount;
                System.out.println("----------------------------------------------");
                System.out.println("Withdrawal is successful");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            } else {
                System.out.println("Balance is insufficient");
                System.out.println("----------------------------------------------");
                System.out.println(" ");
            }
        }
    }

    //Giving Account Details Method
    public void searchAccount(String accName, int accNum, int pin) {
        if(this.accNum != accNum) {
            System.out.println("You've entered the wrong account number. Please try again");
            System.out.println(" ");
        } else if (!this.accName.equals(accName)) {
            System.out.println("You've entered the wrong name. Please try again");
            System.out.println(" ");
        } else if(this.pin != pin) {
            System.out.println("You've entered the wrong pin. Please try again");
            System.out.println(" ");
        }else {
            System.out.println("These are your account details: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Your Balance is " + symbol + this.balance);
            System.out.println("Your Account Number is " + this.accNum);
            System.out.println("Your Account Name is " + this.accName);
            System.out.println("Your address is: " + this.streetNum + " " + this.cityName + ", " + this.stateName + " " + this.zipCode);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }

    //Find the account
    public static BankAccountProject findAccount(ArrayList<BankAccountProject> accounts, int accNum) {
        for (BankAccountProject account : accounts) {
            if (account.accNum == accNum) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Locale locale = Locale.US;
        Currency cur1 = Currency.getInstance(locale);
        String symbol = cur1.getSymbol(locale);
        ArrayList<BankAccountProject> accountList = new ArrayList<>();
        int choice;

        do {
            System.out.println(("********************************"));
            System.out.println("1. Create A New Account");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Check Your Account Information");
            System.out.println("5. Exit");
            System.out.println(("********************************"));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Full Name
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter Your Full Name: ");
                    String accName = scanner.nextLine();
                    accName = scanner.nextLine();
                    System.out.println("----------------------------------------------");

                    //Pin
                    System.out.println("Make a pin (4 digits): ");
                    int pin = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    //Street Name
                    System.out.println("Enter Your Street Name (eg. 1234 Main Street): ");
                    String streeetNum = scanner.nextLine();
                    String streetNum = scanner.nextLine();
                    System.out.println("----------------------------------------------");

                    //City Name
                    System.out.println("Enter Your City Name");
                    String cityName = scanner.nextLine();
                    System.out.println("----------------------------------------------");

                    //State Name
                    System.out.println("Enter Your State Name");
                    String stateName = scanner.nextLine();
                    System.out.println("----------------------------------------------");

                    //Zip code
                    System.out.println("Enter Your Zip Code");
                    int zipCode = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    //Giving Random Account Number
                    int min = 10000000; // Minimum value of range
                    int max = 100000000; // Maximum value of range
                    int accNum = (int)Math.floor(Math.random() * (max - min + 1) + min);
                    System.out.println("This is your account number " + accNum);
                    System.out.println("----------------------------------------------");

                    // Adding Accountfin
                    BankAccountProject newAccount = new BankAccountProject();
                    newAccount.createAcc(accNum, accName, pin, streetNum, cityName, stateName, zipCode);
                    accountList.add(newAccount);
                    break;
                case 2:
                    //Name
                    System.out.println(" ");
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter your Name: ");
                    String accccname = scanner.nextLine();
                    accName = scanner.nextLine();
                    System.out.println("----------------------------------------------");

                    //Account Number
                    System.out.println("Enter your account number: ");
                    accNum = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    //Pin
                    System.out.println("Enter your pin: ");
                    pin = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    //Withdraw Amount
                    System.out.print("Enter the amount you want to withdraw: " + symbol + " ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println("----------------------------------------------");

                    // Find the account and perform the withdrawal
                    BankAccountProject accountForWithdrawal = findAccount(accountList, accNum);
                    if (accountForWithdrawal != null) {
                        accountForWithdrawal.withdrawMoney(accName, accNum, pin, withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    //Name
                    System.out.println(" ");
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter your Name: ");
                    String acccName = scanner.nextLine();
                    accName = scanner.nextLine();
                    System.out.println("----------------------------------------------");

                    //Account Number
                    System.out.println("Enter your account number: ");
                    accNum = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    //Pin
                    System.out.println("Enter your pin: ");
                    pin = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    //Deposit Amount
                    System.out.print("Enter deposit amount: " + symbol + "");
                    double depositAmount = scanner.nextDouble();
                    System.out.println("----------------------------------------------");

                    // Find the account and perform the deposit
                    BankAccountProject accountForDeposit = findAccount(accountList, accNum);
                    if (accountForDeposit != null) {
                        accountForDeposit.depositMoney(accName, accNum, pin, depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    //Name
                    System.out.println(" ");
                    System.out.println("----------------------------------------------");
                    System.out.println("Enter your Name: ");
                    String acccname = scanner.nextLine();
                    accName = scanner.nextLine();
                    System.out.println("----------------------------------------------");

                    //Account Number
                    System.out.println("Enter your account number: ");
                    accNum = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    //Pin
                    System.out.println("Enter your pin: ");
                    pin = scanner.nextInt();
                    System.out.println("----------------------------------------------");

                    // Find the account and display its details
                    BankAccountProject accountForDetails = findAccount(accountList, accNum);
                    if (accountForDetails != null) {
                        accountForDetails.searchAccount(accName, accNum, pin);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
    }
}

