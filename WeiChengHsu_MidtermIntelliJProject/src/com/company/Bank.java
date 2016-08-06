package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by poc on 8/6/16.
 */
public class Bank {
    private String name;
    private Map<String, User> users = new HashMap<String, User>();
    void addUser(User user) {
        users.put(user.getUserId(), user);
    }
    User getUser(String userId) {
        return users.get(userId);
    }
}
