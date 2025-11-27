package org.example.springbootsentry.api.controller;

import io.sentry.Sentry;
import io.sentry.SentryLevel;
import org.example.springbootsentry.api.model.User;
import org.example.springbootsentry.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        Sentry.setTag("user.id.requested", String.valueOf(id));
        log.info("Requesting user with id={}", id);

        Optional user = userService.getUser(id);
        if (user.isPresent()) {
            return (User) user.get();
        } else {
            log.warn("User not found with id={}", id);
            Sentry.captureMessage("User not found: " + id, SentryLevel.WARNING);
        }
        return null;
    }

    @GetMapping("/errors")
    public String triggerException(){
        throw new RuntimeException("error roài hẹ hẹ hẹ");
    }
}
