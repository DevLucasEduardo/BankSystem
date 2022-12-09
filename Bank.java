package edu.bank;

public class Bank implements BankInterface {
    private int accNum;
    private String accType;
    private String accOwner;
    private float accBalance;
    private boolean status;
    private String auxAccType;
    // Método construtor

    public Bank(int accNum, String accType, String accHolder){
        this.setAccNum(accNum);
        this.setAccType(accType);
        this.setAccHolder(accHolder);
        this.setAccBalance(0f);
        this.setStatus(false);
    }

    // Getters e setters

    public int getAccNum(){
        return this.accNum;
    }

    public void setAccNum(int accNum){
        this.accNum = accNum;
    }

    public String getAccType(){
        return this.accType;
    }

    public void setAccType(String accType){
        this.accType = accType;
    }

    public float getAccBalance(){
        return this.accBalance;
    }

    public void setAccBalance(float accBalance){
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
    public void openAccount(){
        if (isStatus()) {
            System.out.println("Denied. This account has been opened before.");
            return;
        }
        this.setStatus(true);
        if (this.getAccType().equals("cp")) {
            this.setAccBalance(150.0f);
        }
        else if (this.getAccType().equals("cc")) {
            this.setAccBalance(50.0f);
        }
        System.out.printf("Welcome, %s. %s under code %d has been created. Account balance: $%.1f.\n",
                this.getAccOwner(), this.accountType(), this.getAccNum(), this.getAccBalance());
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
        if(!isStatus()) {
            System.out.println("Denied. This account has been shutdown.");
            return;
        }
        if(this.getAccBalance() >= withdraw){
            this.accBalance -= withdraw;
            System.out.println("Account balance after withdraw: $" + this.getAccBalance());
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
        if (getAccType().equals("cc")) {
            this.accBalance -= 12;
        }
        else if (getAccType().equals("cp")) {
            this.accBalance -= 20;
        }
        System.out.println("Account balance after monthly payment: $" + getAccBalance());
        if (this.getAccBalance() < 0) {
            System.out.printf("WARNING! Overdraft identified. Please deposit $%.1f in order to keep this account " +
                    "running.\n", getAccBalance() * -1);
        }
    }

    @Override
    public String accountType(){
        if(this.getAccType().equals("cc")){
            auxAccType = "checking account";
        } else if(this.getAccType().equals("cp")){
            auxAccType = "savings account";
        }
        return auxAccType;
    }
}
