package net.imadityak.journalApp.Controller;

import net.imadityak.journalApp.Entity.JournalEntry;
import net.imadityak.journalApp.Service.JournalServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalServices journalServices;

    @GetMapping()
    public ResponseEntity<?> getALl(){
        return journalServices.getAll();
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getEntry(@PathVariable ObjectId myId){
        return journalServices.getEntry(myId);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry){
        return journalServices.createEntry(entry);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId myId){
        return journalServices.deleteEntry(myId);
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry entry){
        return journalServices.updateEntry(myId, entry);
    }
}