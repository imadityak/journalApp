package com.LearnSpring.journalApp.services;

import com.LearnSpring.journalApp.entity.JournalEntry;
import com.LearnSpring.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// here we write all the code and all the controllers will call this class,
// although you can do everything in the controller but its a best practice to bifurcate
// so that they can be managed easily
// controller --> services --> repository(here you will write code for mongoDb)
//make it component so that spring can make a bean of it
@Component
public class JournalEntryServices {

    //dependency injection
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> entryById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepo.deleteById(id);
    }
}
