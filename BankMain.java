package edu.bank;

public class BankMain {
    public static void main(String[] args) {

            Bank userA = new Bank(343, 2, "Lucas");
            userA.register();
            userA.deposit(45);
            userA.withdraw(95);
            userA.transactions(1, 300.43f);
    }
}
