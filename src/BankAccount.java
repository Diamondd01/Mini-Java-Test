import java.util.Random;

public class BankAccount {
      private   double checkingBalance;
       private  double savingsBalance;
    private static int numberOfAccounts = 0;

    private static double moneyStored = 0.0;

    private String accountNumber;
    public BankAccount() {
        numberOfAccounts++;
        accountNumber = generateRandomAccountNumber();
    }
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }
    private String generateRandomAccountNumber() {
        Random random = new Random();
        StringBuilder randomAccountNumber = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digit = random.nextInt(10); // Generate a random digit (0-9)
            randomAccountNumber.append(digit);
        }

        return randomAccountNumber.toString();
    }
    public void deposit(double amount, boolean isChecking) {
        if (isChecking) {
            checkingBalance += amount;
        } else {
            savingsBalance += amount;
        }
        moneyStored+=amount;
    }

    public void withdraw(double amount, boolean isChecking) {
        if (isChecking) {
            if (checkingBalance >= amount) {
                checkingBalance -= amount;
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else {
            if (savingsBalance >= amount) {
                savingsBalance -= amount;
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        }

       moneyStored -= amount;
    }
    public double Total (){
        return savingsBalance + checkingBalance;
    }
    public static void main(String[] args) {
        System.out.println(moneyStored);

    }
}