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

    @GetMapping("/login")
    public HttpStatus authorize(@RequestBody User user) {
        if (users.login(user)) {
            return HttpStatus.OK;
        }

        return HttpStatus.UNAUTHORIZED;
    }
}
