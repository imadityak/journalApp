package net.imadityak.journalApp.Service;

import net.imadityak.journalApp.Entity.JournalEntry;
import net.imadityak.journalApp.Repo.JournalRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalServices {

    @Autowired
    private JournalRepo journalRepo;

    public List<JournalEntry> getAll(){
        return journalRepo.findAll();
    }

    public JournalEntry getEntry(ObjectId id){
        return journalRepo.findById(id).orElse(null);
    }

    public boolean createEntry(JournalEntry entry){
        entry.setDate(LocalDateTime.now());
        journalRepo.save(entry);
        return true;
    }

    public boolean deleteEntry(ObjectId id){
        journalRepo.deleteById(id);
        return true;
    }

    public JournalEntry updateEntry(ObjectId id, JournalEntry entry){
        JournalEntry existingEntry = journalRepo.findById(id).orElse(null);
        if(existingEntry == null){
            return null;
        }
        existingEntry.setId(entry.getId());
        existingEntry.setTitle(entry.getTitle());
        existingEntry.setContent(entry.getContent());
        journalRepo.save(existingEntry);
        return existingEntry;
    }
}