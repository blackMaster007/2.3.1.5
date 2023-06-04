package spring.web.javas.service;

import spring.web.javas.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void save(User user);
    void remove(User user);
    User findUserById(Long id);
    User findUserByEmail (String email);
}
