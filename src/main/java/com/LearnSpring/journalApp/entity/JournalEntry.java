package com.LearnSpring.journalApp.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

// plain old java object(POJO) class - This is the basic structure of the journal entries
// here we are converting this class to relate with database
// now every journal will act as a document in mongoDb
// Lombok -> 1 annotation(@Data) can clearly add all these plugins -> Setter,Getter,RequiredConstructor

@Document(collection = "journal_entries")
@Data
public class JournalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;
}