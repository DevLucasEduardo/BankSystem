package edu.bank;

public class BankRegistration implements BankInterface{

    private int accNum;
    private boolean status;
    private String accOwner;

    @Override
    public void register() {

    }

    @Override
    public void closeAccount() {

    }

    @Override
    public void deposit(float deposit) {

    }

    @Override
    public void withdraw(float withdraw) {

    }

    @Override
    public void monthlyPayment() {

    }


    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAccOwner() {
        return accOwner;
    }

    public void setAccOwner(String accOwner) {
        this.accOwner = accOwner;
    }



}
