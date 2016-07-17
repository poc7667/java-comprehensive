package com.poc;

/**
 * Created by poc on 7/16/16.
 */
public class PairOfDice {
    private Die[] dies = new Die[2];

    public PairOfDice(){
         for(int i=0;i< dies.length;i++){
             dies[i] = new Die();
         }
    }

    public PairOfDice(int sides){
        for(int i=0;i< dies.length;i++){
            dies[i] = new Die(sides);
        }
    }

    public void roll(){
        for(int i=0;i< dies.length;i++) {
            dies[i].roll();
        }
    }

    public int getValue1(){
        return dies[0].getValue();
    }

    public int getValue2(){
        return dies[1].getValue();
    }

    public int getSum(){
        return getValue1()+getValue2();
    }

    public static void main(String[] args) {
        PairOfDice app = new PairOfDice();
        app.roll();
        System.out.println(app.getSum());
    }

}
