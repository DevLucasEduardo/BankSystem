package edu.bank;

public interface BankInterface {
    public abstract String registration();
    String deleteRegistration();
    String openCurrentAcc();
    String openSavingsAcc();
    String closeCurrentAcc();
    String closeSavingsAcc();
    String depositCurrentAcc(int deposit);
    String withdrawCurrentAcc(int withdraw);
    String depositSavingsAcc(int deposit);
    String withdrawSavingsAcc(int withdraw);

}
