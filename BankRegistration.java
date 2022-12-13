package edu.bank;

import java.util.Random;

public abstract class BankRegistration implements BankInterface {

    private final int accNum;
    private boolean status;
    private String accHolder;
    private boolean accCurrentStatus;
    private boolean accSavingsStatus;

    public BankRegistration(String accHolder) {
        Random random = new Random();
        accNum = random.nextInt(20000);
        this.accHolder = accHolder;
        this.accSavingsStatus = false;
        this.accCurrentStatus = false;
    }

    public int getAccNum() {
        return accNum;
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

    public boolean isAccSavingsStatus() {
        return accSavingsStatus;
    }

    public void setAccSavingsStatus(boolean accSavingsStatus) {
        this.accSavingsStatus = accSavingsStatus;
    }

    public boolean isAccCurrentStatus() {
        return accCurrentStatus;
    }

    public void setAccCurrentStatus(boolean accCurrentStatus) {
        this.accCurrentStatus = accCurrentStatus;
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
    public String deleteRegistration(){
        if(!isStatus()){
            return "The registration under code " + this.getAccNum() + " has been deleted before.";
        } else {
            if (isAccCurrentStatus() && isAccSavingsStatus()) {
                return "Close your accounts before deleting the registration.";
            } else {
                this.setStatus(false);
                return "Registration under code " + this.getAccNum() + " deleted.";
            }
        }
    }

}
