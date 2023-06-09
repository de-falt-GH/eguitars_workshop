package backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.models.User;
import backend.services.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService users;

    @PostMapping("/login")
    public HttpStatus authorize(@RequestBody User user) {
        System.out.println(user.toString());
        if (user.getLogin().equals("admin") && user.getPassword().equals("admin")) {
            System.out.println("check");
            return HttpStatus.OK;
        }

        return HttpStatus.UNAUTHORIZED;
    }

    @PostMapping("/users")
    public HttpStatus saveUser(@RequestBody User user) {
        users.save(user);

        return HttpStatus.UNAUTHORIZED;
    }
}
