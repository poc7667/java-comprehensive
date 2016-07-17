package com.poc;

import java.util.Scanner;

/**
 * Created by poc on 7/16/16.
 */
public class Dice_3_2 extends HomeWorkWrapper{
    private Scanner rd = new Scanner(System.in);

    public Dice_3_2(){}
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        DiceRollerApp this_instance = new DiceRollerApp();
        worker.doIt(this_instance);
    }

}
