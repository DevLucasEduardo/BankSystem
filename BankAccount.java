package edu.bank;

public class BankAccount extends BankRegistration {

    private float accBalanceSavings;
    private float accBalanceCurrent;


    // Método construtor

    public BankAccount(String accHolder){
        super(accHolder);
    }

    // Getters e Setters

    public float getAccBalanceSavings() {
        return accBalanceSavings;
    }

    public void setAccBalanceSavings(float accBalanceSavings) {
        this.accBalanceSavings = accBalanceSavings;
    }

    public float getAccBalanceCurrent() {
        return accBalanceCurrent;
    }

    public void setAccBalanceCurrent(float accBalanceCurrent) {
        this.accBalanceCurrent = accBalanceCurrent;
    }


    // Methods

    @Override
    public String openCurrentAcc() {
        if (!isStatus()) {
            return "Denied. You must register before opening an account.";
        } else if (isAccCurrentStatus()) {
            return "Denied. A Current Account has been opened before.";
        }   else {
            this.setAccCurrentStatus(true);
            return "A Current Account has been opened successfully.";
        }
    }

    @Override
    public String openSavingsAcc() {
        if (!isStatus()) {
            return "Denied. You must register before opening an account.";
        } else if (isAccSavingsStatus()) {
            return "Denied. A Savings Account has been opened before.";
        }   else {
            this.setAccSavingsStatus(true);
            return "A Savings Account has been opened successfully.";
        }
    }
    @Override
    public String withdrawCurrentAcc(int withdraw) {
        if (!this.isStatus()) {
            return "Denied. This registration has been shutdown";
        } else if (!this.isAccCurrentStatus()) {
            return "Current Account has not been opened.";
        } else if (this.getAccBalanceCurrent() >= withdraw) {
            this.accBalanceCurrent -= withdraw;
            return "Current Account balance after withdraw: $" + this.getAccBalanceCurrent() +
                    ". Bills received: " + Count.withdrawBills(withdraw);
        } else {
            return "Denied. The Current Account balance amount is lesser than the withdraw request. " +
                    "The maximum amount to be withdrawn is $" + this.getAccBalanceCurrent() + ".";
        }
    }

    @Override
    public String withdrawSavingsAcc(int withdraw) {
        if (!this.isStatus()) {
            return "Denied. This registration has been shutdown";
        } else if (!this.isAccSavingsStatus()) {
            return "Denied. The Savings Account has not been opened.";
        } else if (this.getAccBalanceSavings() >= withdraw) {
            this.accBalanceSavings -= withdraw;
            return "Savings Account balance after withdraw: $" + this.getAccBalanceSavings() +
                    ". Bills received: " + Count.withdrawBills(withdraw);
        } else {
            return "Denied. The Savings Account balance amount is lesser than the withdraw request. " +
                    "The maximum amount to be withdrawn is $" + this.getAccBalanceSavings() + ".";
        }
    }
    @Override
    public String depositCurrentAcc(int deposit) {
        if (!this.isStatus()) {
            return "Denied. This registration has been shutdown";
        } else if (!this.isAccCurrentStatus()) {
            return "Denied. The Current Account has not been opened.";
        } else {
            this.accBalanceCurrent += deposit;
            return "Current Account balance after deposit: $" + this.accBalanceCurrent + ".";
        }
    }

    @Override
    public String depositSavingsAcc(int deposit) {
        if (!this.isStatus()) {
            return "Denied. This account has been shutdown";
        } else if (!this.isAccSavingsStatus()) {
            return "Denied. The Savings Account has not been opened.";
        } else {
            this.accBalanceSavings += deposit;
            return "Savings Account balance after deposit: $" + this.accBalanceSavings + ".";
        }
    }

    @Override
    public String closeCurrentAcc() {
        if(!this.isStatus()) {
            return "Denied. The registration has not been created.";
        } else if (!this.isAccCurrentStatus()){
            return "Denied. The Current Account has already been shut down.";
        } else if (this.getAccBalanceCurrent() > 0){
            float auxBalance = getAccBalanceCurrent();
            setAccBalanceCurrent(0);
            this.setAccCurrentStatus(false);
            return "The Current Account has been shut down successfully. "
                    + "Last withdraw: $" + auxBalance + ". Bills received: " + Count.withdrawBills(auxBalance) + ".";
        } else {
            this.setAccCurrentStatus(false);
            return "The Current Account has been shutdown successfully.";
        }
    }
    @Override
    public String closeSavingsAcc() {
        if(!this.isStatus()) {
            return "Denied. The registration has not been created.";
        } else if (!this.isAccSavingsStatus()){
            return "Denied. The Savings Account has already been shut down.";
        } else if (this.getAccBalanceSavings() > 0){
            float auxBalance = getAccBalanceSavings();
            setAccBalanceSavings(0);
            this.setAccSavingsStatus(false);
            return "The Savings Account has been shut down successfully. "
                    + "Last withdraw: $" + auxBalance + ". Bills received: " + Count.withdrawBills(auxBalance) + ".";
        } else {
            this.setAccSavingsStatus(false);
            return "The Savings Account has been shutdown successfully.";
        }
    }

//    public void transactions(int transactionType, float amount, BankAccount a, BankRegistration b){
//        if(transactionType == 1){
//            this.accBalance -= amount;
//        }else if(transactionType == 2){
//            this.accBalance += amount;
//
//        }
//        System.out.println("Transaction made. Current balance: $" + this.getAccBalance());
//    }

}


