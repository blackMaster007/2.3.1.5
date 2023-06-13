package spring.web.javas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import spring.web.javas.model.User;
import spring.web.javas.service.UserService;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public void newUser(@RequestBody User user) {
        userService.save(user);
    }


    @PutMapping("/users")
    public void update(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userService.remove(userService.findUserById(id));
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/name")
    public ResponseEntity<User> getAdminByName(Principal principal) {
        return ResponseEntity.ok(userService.findUserByEmail(principal.getName()));
    }

}
