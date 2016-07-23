package com.company;

/**
 * Created by poc on 7/23/16.
 */
public class Employee extends Person {
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    private String socialSecurityNumber = "";

    public String getDisplayText(){
        String appendedDisplayText = String.format("Social Security Number:%s\n", getSocialSecurityNumber());
        return String.format("%s%s",super.toString(), appendedDisplayText );
    };
}
