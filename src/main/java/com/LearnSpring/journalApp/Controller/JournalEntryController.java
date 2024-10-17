package com.LearnSpring.journalApp.Controller;

import com.LearnSpring.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// the end point path will be /journal/abc
//RequestMapping will map your whole class
@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    // creating a map with all the entries but it's efficient to use a Database
    // you can imagin it as an data storing
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    // because we haven't mapped any endpoint so this method is called if get request is there
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    // For POST request
    //it will give us all the entries in the map
    // we have created a instance of JournalEntry and we have used put method of map
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    // we will create an api so that we can fetch info according to id's in the map in the form of Long
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    //Creating Put Request for modifying any specific entry by ID
    @PutMapping("id/{myId}")
    public boolean updateJournalEntryById(@PathVariable Long myId, @RequestBody JournalEntry myEntry) {
        journalEntries.put(myId, myEntry);
        return true;
    }

    // Delete request for deleting a particular entry
    // and it will return the deleted entry
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return journalEntries.remove(myId);
    }
}