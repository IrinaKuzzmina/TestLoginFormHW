package com.academy.fx.service;

import com.academy.fx.dao.UserData;
import com.academy.fx.model.User;

import java.util.List;

public class UserService {

    private UserData userData;
    private static UserService instance;

    private UserService() {
        userData = UserData.getInstance();
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public List<User> getAll() {
        return userData.getAll();
    }

    public User getByEmail(String email) {
        return userData.getByEmail(email);
    }

    public void save(User user) {
        userData.save(user);
    }
}
