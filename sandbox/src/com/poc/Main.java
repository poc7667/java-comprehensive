package com.poc;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [][]a ={{1,3}}; //[[1,2], [3,4]];
        System.out.println(a[0][0]);
        System.out.println(a); // memory address
        System.out.println(a.length); // memory address
        System.out.println(a[0].length); // memory address

        double []num_list = {213.31, 323, 3, 312};
        for(int i=0;i< num_list.length;i++){
            System.out.println(num_list[i]);
        }

        Stack stk = new Stack();
        stk.showStack();
        System.out.println(Arrays.toString( stk.push(10)));
        System.out.println(Arrays.toString( stk.push(110)));
        System.out.println(stk.pop());
        stk.showStack();

        InheritanceCircle ic = new InheritanceCircle();
        ic.getArea(100);
//        System.out.println(stk.push(13));
    }
}
