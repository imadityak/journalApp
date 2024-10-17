package com.LearnSpring.journalApp.repository;

import com.LearnSpring.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//here you have to give <entity-->JournalEntry-->POJO, Id>
// by this we can use services
// mongo only takes only two things document and id.
public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {

}
