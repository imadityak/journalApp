package net.imadityak.journalApp.Service;

import net.imadityak.journalApp.Entity.JournalEntry;
import net.imadityak.journalApp.Entity.User;
import net.imadityak.journalApp.Repo.JournalRepo;
import net.imadityak.journalApp.Repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalServices {

    @Autowired
    private JournalRepo journalRepo;

    @Autowired
    private UserServices userServices;

    //get_all(working)
    public List<JournalEntry> getAll(String username){
        return journalRepo.findAll();
    }

    //get_by_id
    public Optional<JournalEntry> findById(ObjectId id){
        return journalRepo.findById(id);
    }

    //post(working)
    @Transactional //this annotation is used for atomicity
    public void saveEntry(JournalEntry entry, String username){
        try {
            User user = userServices.findByUserName(username);
            entry.setDate(LocalDateTime.now());
            JournalEntry saved = journalRepo.save(entry);
            user.getEntries().add(saved);
            userServices.saveEntry(user);
        }catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("Error while saving the entry");
        }
    }

    //method overload
    public void saveEntry(JournalEntry entry){
        journalRepo.save(entry);
    }

    //delete(working) - also deletes the entry from the user's list of entries
    public void deleteById(ObjectId id, String username){
        User user = userServices.findByUserName(username);
        user.getEntries().removeIf(entry -> entry.getId().equals(id));
        userServices.saveEntry(user);
        journalRepo.deleteById(id);
    }
}