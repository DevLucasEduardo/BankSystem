package edu.bank;

public class BankMain {
    public static void main(String[] args) {

            Bank userA = new Bank(343, 3, "Lucas");
            userA.openAccount();
            userA.deposit(45);
            userA.withdraw(95);

    }
}
