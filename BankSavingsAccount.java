package edu.bank;
import java.util.List;
import java.util.ArrayList;

public class BankSavingsAccount extends BankRegistration implements BankInterface {

    private float accBalance;
    public byte accType = 0;

    // Método construtor

    public BankSavingsAccount(String accHolder){
        super(accHolder);
        
    }

    // Getters e setters


    public float getAccBalance() {
        return this.accBalance;
    }

    public void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }

    public byte getAccType() {
        return accType;
    }

    public void setAccType(byte accType) {
        this.accType = accType;
    }
    // Methods

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
        if(!this.isStatus()) {
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

    public void transactions(int transactionType, float amount){
        if(transactionType == 1){
            this.accBalance -= amount;
        }else if(transactionType == 2){
            this.accBalance += amount;
        }
        System.out.println("Transaction made. Current balance: $" + this.getAccBalance());
    }
}

