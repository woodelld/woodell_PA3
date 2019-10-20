public class Application {
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        //Set balances
        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);
        //calculate savings for 12 months at 4%
        SavingsAccount.modifyInterestRate(4);
        for(int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        //print balance after 12 months
        System.out.print("Saver1's balance: ");
        saver1.print();
        System.out.print("Saver2's balance: ");
        saver2.print();
        //calculate savings for one more month at 5%
        SavingsAccount.modifyInterestRate(5);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        //print balance after 1 month
        System.out.print("Saver1's balance: ");
        saver1.print();
        System.out.print("Saver2's balance: ");
        saver2.print();
    }
}
