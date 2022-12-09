package edu.bank;

public class BankMain {
    public static void main(String[] args) {

            Bank userA = new Bank(343, "cc", "Lucas");
            userA.openAccount();
            userA.deposit(45f);
            userA.withdraw(90f);
            userA.monthlyPayment();
            userA.withdraw(25f);
            userA.closeAccount();
    }
}
