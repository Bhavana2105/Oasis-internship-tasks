import java.util.Scanner;

interface BankOperations {
    public void credentialsCheck(String Username, String password) throws Exception;
    public void credit(double amount) throws Exception;
    public void debit(double amount) throws Exception;
    public void displayBalance() throws Exception;
    public void exit();
}

class BankAccount implements BankOperations {
    private double balance;
    private String username;
    private String password;
    private static final String[] ACCOUNTS = { "pooja", "@123", "polkam", "@321","bargavi","231" };

    public BankAccount(String username, String password) throws Exception {
        this.username = username;
        this.password = password;
        credentialsCheck(username, password);
    }

    public void credentialsCheck(String username, String password) throws Exception {
        boolean isValid = false;
        for (int i = 0; i < ACCOUNTS.length; i += 2) {
            if (ACCOUNTS[i].equals(username) && ACCOUNTS[i + 1].equals(password)) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new Exception("credentials mismatch");
        }
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Requested amount is unavailable");
        }
        balance -= amount;
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void exit() {
        System.out.println("Exiting the system");
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        try 
        {
            BankAccount account = new BankAccount(username, password);
            while (true) 
            {
                System.out.println("Select an option:");
                System.out.println("1. Credit");
                System.out.println("2. Debit");
                System.out.println("3. Display balance");
                System.out.println("4. Exit");
                int option = sc.nextInt();
                switch (option) {
                case 1:
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = sc.nextDouble();
                    account.credit(creditAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = sc.nextDouble();
                    try 
	     {
                        account.debit(debitAmount);
                         } 
	  catch (Exception e) 
	  {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.exit();
                    System.exit(0);
                }
            }
        } 
       catch (Exception e)
      {
	System.out.println(e);
      }
     finally
     {
	System.out.println("final");
      }
 }
}