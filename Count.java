package edu.bank;

import java.util.ArrayList;
import java.util.List;

public class Count {
    public static List<Integer> withdrawBills(float withdraw){
        List<Integer> bills = new ArrayList<>();
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
        return bills;
    }
}
