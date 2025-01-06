package net.imadityak.journalApp.Service;

import net.imadityak.journalApp.Entity.User;
import net.imadityak.journalApp.Repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepo userRepo;

    //get
    public List<User> getAll(){
        return userRepo.findAll();
    }

    //post
    public User saveEntry(User user){
            return userRepo.save(user);
    }

    //put
    public ResponseEntity<User> updateUser(User user, String username){
        User userName = userRepo.findByUsername(username);
        if(userName == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userName.setUsername(user.getUsername());
        userName.setPassword(user.getPassword());
        return new ResponseEntity<>(userRepo.save(userName), HttpStatus.OK);
    }
}
