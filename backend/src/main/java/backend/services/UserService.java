package backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.models.User;
import backend.repos.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository users;

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return users.findAll();
    }

    @Transactional
    public void save(User user) {
        users.save(user);
    }

    @Transactional
    public void deleteById(long id) {
        users.deleteById(id);
    }

    @Transactional
    public boolean login(User user) {
        var checkUser = users.findById(user.getId()).get();
        if (user.getLogin() == checkUser.getLogin() && user.getPassword() == checkUser.getPassword()) {
            return true;
        }

        return false;
    }
}