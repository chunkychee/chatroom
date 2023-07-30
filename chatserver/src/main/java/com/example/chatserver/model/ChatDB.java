package com.example.chatserver.model;

import com.example.chatserver.view.UserDetails;
import com.example.chatserver.view.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
@Repository
public interface ChatDB extends MongoRepository<UserDetails, ObjectId> {


}
