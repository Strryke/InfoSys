package pset;

public class CheckingAccount extends Account{
    private double overdraftLimit = 5000;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < -overdraftLimit) {
            System.out.println("over limit");
        } else {
            super.withdraw(amount);
        }
    }
}
