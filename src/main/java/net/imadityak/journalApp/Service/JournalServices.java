package net.imadityak.journalApp.Service;

import net.imadityak.journalApp.Entity.JournalEntry;
import net.imadityak.journalApp.Repo.JournalRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

    public ResponseEntity<?> getAll(){
        List<JournalEntry> entry = journalRepo.findAll();
        if(entry!= null && !entry.isEmpty()){
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //This methods get entry by id with http status
    public ResponseEntity<?> getEntry(ObjectId id){
        Optional<JournalEntry> entry = journalRepo.findById(id);
        if(entry.isPresent()){
            return new ResponseEntity<>(entry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<JournalEntry> createEntry(JournalEntry entry){
        try {
            entry.setDate(LocalDateTime.now());
            journalRepo.save(entry);
            return new ResponseEntity<>(entry, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> deleteEntry(ObjectId id){
        journalRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

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