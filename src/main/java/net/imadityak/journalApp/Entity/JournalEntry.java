package net.imadityak.journalApp.Entity;

//POJO class to represent a Journal Entry

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

//This annotation is used to specify the name of the collection in MongoDB
// and the object of this class will be stored as documents in that collection
@Document(collection="journal_entries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    private String title;
    private String content;
    private LocalDateTime date;

}
