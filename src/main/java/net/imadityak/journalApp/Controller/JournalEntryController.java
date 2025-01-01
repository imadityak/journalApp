package net.imadityak.journalApp.Controller;

import net.imadityak.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping()
    public List<JournalEntry> getALl(){
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getEntry(@PathVariable long myId){
        return journalEntries.get(myId);
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(), entry);
        return true;
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteEntry(@PathVariable long myId){
        journalEntries.remove(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateEntry(@PathVariable long myId, @RequestBody JournalEntry entry){
        return journalEntries.put(myId, entry);
    }
}