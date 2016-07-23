package com.company;

/**
 * Created by poc on 7/23/16.
 */
public class Customer extends Person {


    private String customerNumber = "";
    public Customer(){

    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getDisplayText(){
        String appendedDisplayText = String.format("Customer Number:%s\n",getCustomerNumber());
        return String.format("%s%s",super.toString(), appendedDisplayText );
    };

}
