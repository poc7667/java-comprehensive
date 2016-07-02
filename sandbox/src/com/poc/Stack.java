package com.poc;

import java.util.Arrays;

/**
 * Created by poc on 7/1/16.
 */
public class Stack {

//    int a[1000]= {};
    int stk[] = new int[10];
    int pos = 0;

//    public static void main(String[] args) {
//        System.out.println(a[0]);
//        System.out.println("opop");
//    }

    public  void showStack(){
        System.out.println(Arrays.toString(stk));
    }

    public int[] push(int i){
        stk[pos] = i;
        pos+=1;
        return stk;
    }

    public  int pop(){
        int rtn_value = stk[pos-1];
        stk[pos-1] = 0;
        pos-=1;
        return rtn_value;
    }
}
