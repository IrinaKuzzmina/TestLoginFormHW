package com.academy.fx.dao;

import com.academy.fx.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {

    private Map<String, User> users;

    private static UserData instance;

    private UserData() {
        this.users = new HashMap<>();
        init();
    }

    private void init() {
        save(User.newUser()
            .withFirstName("test")
            .withLastName("test")
            .withMail("test@mail.com")
            .withPassword("test")
            .build());
    }

    public static UserData getInstance() {
        synchronized (UserData.class) {
            if (instance == null) {
                instance = new UserData();
            }
        }

        return instance;
    }

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public User getByEmail(String email) {
        return users.get(email);
    }

    public void save(User user) {
        users.put(user.getMail(), user);
    }

    public void delete(User user) {
        this.users.remove(user.getMail());
    }
}
