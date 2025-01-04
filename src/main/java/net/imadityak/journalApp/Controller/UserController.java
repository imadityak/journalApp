package net.imadityak.journalApp.Controller;

import net.imadityak.journalApp.Entity.User;
import net.imadityak.journalApp.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userServices.createEntry(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username){
        return userServices.updateUser(user, username);
    }

}
