import java.io.PrintStream;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public void calculateMonthlyInterest(){
        double monthlyInterest;

        monthlyInterest = savingsBalance * annualInterestRate / 12;
        savingsBalance = monthlyInterest + savingsBalance;
    }

    public static void modifyInterestRate(int newRate){
        annualInterestRate = newRate / 100.00;
    }

    public void setSavingsBalance(double newBalance){
        savingsBalance = newBalance;
    }

    public void print(){
        System.out.printf("$%.2f\n", savingsBalance);
    }
}