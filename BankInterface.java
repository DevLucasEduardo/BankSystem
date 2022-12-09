package edu.bank;

public interface BankInterface {
    void openAccount();
    void closeAccount();
    void deposit(float deposit);
    void withdraw(float withdraw);
    void monthlyPayment();
    String accountType();
}
