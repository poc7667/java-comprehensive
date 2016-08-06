package com.company;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by poc on 8/6/16.
 */
public class User {

    private String userId;
    private String name;
    Account account ;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.account = new Account(this);
    }

    public String getUserId() {
        return userId;
    }

    public String toString() {
        List<String> toks = Arrays.asList(super.toString(), this.userId, this.name);
        return StringUtils.join(toks, ":");
    }



}
