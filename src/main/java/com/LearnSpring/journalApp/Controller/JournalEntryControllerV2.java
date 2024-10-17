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
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return null;
    }

    @PutMapping("id/{myId}")
    public boolean updateJournalEntryById(@PathVariable Long myId, @RequestBody JournalEntry myEntry) {
        return true;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return null;
    }
}