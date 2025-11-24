package org.example.springbootsentry.service;

import org.example.springbootsentry.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();

        User user1 = new User(1, "Anh1", 18, "Anh1@gmail.com");
        User user2 = new User(2, "Anh2", 19, "Anh2@gmail.com");
        User user3 = new User(3, "Anh3", 20, "Anh3@gmail.com");
        User user4 = new User(4, "Anh4", 21, "Anh4@gmail.com");

        users.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUser(int id) {
        Optional optional = Optional.empty();
        for (User user : users) {
            if (user.getId() == id) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
