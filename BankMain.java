package edu.bank;

public class BankMain {
    public static void main(String[] args) {

        BankAccount userA = new BankAccount("Lucas Eduardo");
        System.out.println(userA.registration());
        System.out.println(userA.openCurrentAcc());
        System.out.println(userA.openSavingsAcc());
        System.out.println(userA.depositCurrentAcc(50));
        System.out.println(userA.depositSavingsAcc(35));




    }
}
