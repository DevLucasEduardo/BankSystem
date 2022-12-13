package edu.bank;

import java.util.Random;

public abstract class BankRegistration implements BankRegistrationInterface {

    private final int accNum;
    private boolean status;
    private String accHolder;
    private float accBalance;

    public BankRegistration(String accHolder) {
        Random random = new Random();
        accNum = random.nextInt(20000);
        this.accHolder = accHolder;
        this.accBalance = 0;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(String accHolder) {
        this.accHolder = accHolder;
    }

    public float getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

    @Override
    public String registration() {
        if (isStatus()){
            return "Denied. This account has been opened before.";

        }
        this.setStatus(true);
        return "Welcome, " + this.getAccHolder() + ". Account under code " + this.accNum + " created.";
    }


    @Override
    public void closeAcc() {
        if(!this.isStatus()) {
            System.out.println("Denied. This account has already been shut down.");
            return;
        }
        if(this.getAccBalance() > 0){
            System.out.println("This account has been shut down successfully. Last withdraw: $" + this.getAccBalance()+ ".");
            setAccBalance(0);
        }
        else {
            System.out.println("This account has been shutdown successfully.");
        }
        this.setStatus(false);
    }

}
