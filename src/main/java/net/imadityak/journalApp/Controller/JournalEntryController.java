package net.imadityak.journalApp.Controller;

import net.imadityak.journalApp.Entity.JournalEntry;
import net.imadityak.journalApp.Service.JournalServices;
import net.imadityak.journalApp.Service.UserServices;
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

    //get_all(working)
    @GetMapping("/{username}")
    public ResponseEntity<?> getALlEntriesOfUser(@PathVariable String username){
        return journalServices.getAll(username);
    }

    //get_by_id(If you got the id then you can get the entry.)
    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getEntry(@PathVariable ObjectId myId){
        return journalServices.getEntry(myId);
    }

    //post(working)
    @PostMapping("/{username}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry, @PathVariable String username){
        return journalServices.createEntry(entry, username);
    }

    //delete(working)
    @DeleteMapping("/id/{username}/{myId}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId myId, @PathVariable String username){
        return journalServices.deleteEntry(myId, username);
    }

    //update()
    @PutMapping("/id/{username}/{myId}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId myId,
                                         @RequestBody JournalEntry entry,
                                         @PathVariable String username){
        return journalServices.updateEntry(myId, entry, username);
    }
}