package edu.bank;

public interface BankInterface {
    public abstract void register();
    void closeAccount();
    void deposit(float deposit);
    void withdraw(float withdraw);
    void monthlyPayment();

}
