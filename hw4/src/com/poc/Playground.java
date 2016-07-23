package com.poc;

/**
 * Created by poc on 7/22/16.
 */
class Book extends  Product{
    public String toString(){
        return "im book";
    }
}

class Computer extends Product{
    public String toString(){
        return "im Computer";
    }
    public Computer(){}
}

class House extends  Product{
    public void showPrice(){
        System.out.printf("hose is 123");
    }
}

class Product{
    protected int price = 200;
    public String toString(){
        return "Product";
    }
    public void setPrice(int newPrice){
        price=newPrice;
    }
    public void showPrice(){
        System.out.println(price);
    }
}

public class Playground {
    public static String name = "Myname";

    @Override
    public String toString(){
        return "Parent():"+super.toString()+"overrite string";
    }

    public static void main(String[] args) {
        Book bk = new Book();

        Product p;
        p = bk;
        showPrice(p);
//        System.out.println(p);
//        System.out.println("Print:"+new Playground());
    }

    public static void showPrice(Product p){
        p.showPrice();
    }
}
