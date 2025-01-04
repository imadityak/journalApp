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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalServices {

    @Autowired
    private JournalRepo journalRepo;

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepo userRepo;

    //get_all
    public ResponseEntity<?> getAll(String username){
        User user = userRepo.findByUsername(username);
        List<JournalEntry> allEntries = user.getEntries();
        if(allEntries!= null && !allEntries.isEmpty()){
            return new ResponseEntity<>(allEntries, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //get_by_id
    public ResponseEntity<?> getEntry(ObjectId id){
        Optional<JournalEntry> entry = journalRepo.findById(id);
        if(entry.isPresent()){
            return new ResponseEntity<>(entry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //post
    public ResponseEntity<JournalEntry> createEntry(JournalEntry entry, String username){
        try {
            User user = userRepo.findByUsername(username);
            entry.setDate(LocalDateTime.now());
            JournalEntry saved = journalRepo.save(entry);
            user.getEntries().add(saved);
            userServices.createEntry(user);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //delete
    public ResponseEntity<?> deleteEntry(ObjectId id){
        journalRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //put
    public ResponseEntity<?> updateEntry(ObjectId id, JournalEntry entry){
        JournalEntry existingEntry = journalRepo.findById(id).orElse(null);
        if(existingEntry == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingEntry.setTitle(entry.getTitle());
        existingEntry.setContent(entry.getContent());
        journalRepo.save(existingEntry);
        return new ResponseEntity<>(existingEntry, HttpStatus.OK);
    }
}