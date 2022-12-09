package edu.bank;
import java.util.List;
import java.util.ArrayList;

public class Bank implements BankInterface {
    private int accNum;
    private int accType;
    private String accOwner;
    private float accBalance;
    private boolean status;

    // Método construtor

    public Bank(int accNum, int accType, String accHolder){
        this.setAccNum(accNum);
        this.setAccType(accType);
        this.setAccHolder(accHolder);
        this.setAccBalance(0);
        this.setStatus(false);
    }

    // Getters e setters

    public int getAccNum(){
        return this.accNum;
    }

    public void setAccNum(int accNum){
        this.accNum = accNum;
    }

    public int getAccType(){
        return this.accType;
    }

    public void setAccType(int accType){
        this.accType = accType;
    }

    public float getAccBalance(){
        return this.accBalance;
    }

    public void setAccBalance(int accBalance){
        this.accBalance = accBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public String getAccOwner(){
        return this.accOwner;
    }

    public void setAccHolder(String accHolder){
        this.accOwner = accHolder;
    }

    // Methods

    @Override
    public void register(){
        if (isStatus()){
            System.out.println("Denied. This account has been opened before.");
            return;
        }
        this.setStatus(true);
        System.out.printf("Welcome, %s. Account under code %d has been registered\n", this.getAccOwner(), this.getAccNum());
    }
    public void createAccType(){
        return;
    }
        public void changeAccType(){
            return;
    }


    @Override
    public void deposit(float deposit){
        if (this.isStatus()){
            this.accBalance += deposit;
            System.out.println("Account balance after deposit: $" + getAccBalance());
        }
        else{
            System.out.println("Denied. This account has been shutdown.");
        }

    }

    @Override
    public void withdraw(float withdraw){
        List<Integer> bills = new ArrayList<>();
        if(!isStatus()) {
            System.out.println("Denied. This account has been shutdown.");
            return;
        }
        if(this.getAccBalance() >= withdraw){
            this.accBalance -= withdraw;
            while (withdraw > 0){
                if (withdraw >= 100){
                    withdraw -= 100;
                    bills.add(100);
                } else if(withdraw >= 50){
                    withdraw -= 50;
                    bills.add(50);
                } else if(withdraw >= 20){
                    withdraw -= 20;
                    bills.add(20);
                } else if(withdraw >= 10){
                    withdraw -= 10;
                    bills.add(10);
                } else if(withdraw >= 5) {
                    withdraw -= 5;
                    bills.add(5);
                } else if(withdraw >= 2){
                    withdraw -= 2;
                    bills.add(2);
                } else{
                    withdraw -= 1;
                    bills.add(1);
                }
            }
            System.out.print("Account balance after withdraw: $" + this.getAccBalance() + ". Bills received: ");
            for(int values: bills){
                System.out.print("$" + values + " ");
            }
            System.out.print("\n");
        }
        else if(getAccBalance() <= withdraw && getAccBalance() >= 0){
            System.out.println("Denied. The account balance amount is lesser than the withdraw request. " +
                    "The maximum amount to be withdrawn is $" + this.getAccBalance() + ".");
        }
        else{
            System.out.println("Denied. This account is in debt in $" + this.getAccBalance() * - 1 + ".");
        }
    }


    @Override
    public void closeAccount(){
        if(!this.isStatus()) {
            System.out.println("Denied. This account has already been shut down.");
            return;
        }
        if(this.getAccBalance() > 0){
            System.out.println("This account has been shut down successfully. Last withdraw: $" + getAccBalance()+ ".");
            setAccBalance(0);
        }
        else {
            System.out.println("This account has been shutdown successfully.");
        }
        this.setStatus(false);
    }


    @Override
    public void monthlyPayment(){
        if (!isStatus()) {
            System.out.println("Denied. This account has been shutdown.");
            return;
        }
        if (getAccType() == 1){
            this.accBalance -= 12;
        }
        else if (getAccType() == 2) {
            this.accBalance -= 20;
        }
        System.out.println("Account balance after monthly payment: $" + getAccBalance());
        if (this.getAccBalance() < 0) {
            System.out.printf("WARNING! Overdraft identified. Please deposit $%.2f in order to keep this account " +
                    "running.\n", getAccBalance() * -1);
        }
    }
    public void transactions(int transactionType, float amount){
        if(transactionType == 1){
            this.accBalance -= amount;
        }else if(transactionType == 2){
            this.accBalance += amount;
        }
        System.out.println("Transaction made. Current balance: $" + this.getAccBalance());
    }
}

