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

    @PostMapping
    public void createEntry(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(), entry);
    }
}
