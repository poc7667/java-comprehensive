package com.poc;

/**
 * Created by poc on 7/16/16.
 */
public class Die {
    private int sides =6;
    private int value;
    public Die(){

    }
    public Die(int sides){
        this.sides = sides;
    }

    public void roll(){
        this.value = (int)(Math.random() * sides)+1;
    }

    public int getValue(){
        return this.value;
    }

    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        System.out.println("value is:"+ die.getValue());
    }
}
