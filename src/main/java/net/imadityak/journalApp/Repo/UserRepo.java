package net.imadityak.journalApp.Repo;

import net.imadityak.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
    //we have to create the method so that we can search the user by its username
    User findByUsername(String username);
}
