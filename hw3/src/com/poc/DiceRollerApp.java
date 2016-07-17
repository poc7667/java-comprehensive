package com.poc;

/**
 * Created by poc on 7/16/16.
 */
public class DiceRollerApp extends HomeWorkWrapper{
    private static int roll_count = 0;
    public DiceRollerApp(){}

    public void execute(){
        roll_count++;
        System.out.println("Roll:"+ roll_count);
        PairOfDice app = new PairOfDice();
        app.roll();
        System.out.println(app.getValue1());
        System.out.println(app.getValue2());
        if(app.getSum()==7){
            System.out.println("Craps!!");
        }else if(app.getValue1()==1 && app.getValue2()==1){
            System.out.println("Snake eyes!!");
        }else if(app.getValue1()==1 && app.getValue2()==1) {
            System.out.println("Box cars!!");
        }
    }

    public static void main(String[] args) {

    }
}
