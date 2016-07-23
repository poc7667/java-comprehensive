package com.company;

/**
 * Created by poc on 7/23/16.
 */
public abstract class Person {

    private String firstName ="";
    private String lastName ="";
    private String email="";

    public Person(){}

    @Override
    public String toString(){
        return String.format("Name: %s %s\nEmail: %s \n",
                getFirstName(),
                getLastName(),
                getEmail());
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public abstract String getDisplayText();
}