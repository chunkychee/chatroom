package com.example.chatserver.view;

import com.example.chatserver.model.ChatDB;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userdetails") //This means that the User class will map to the MongoDB collection named "users".
                                    // All the instances of the userdetails class that you save via your repository will be stored in the "userdetails" collection in your MongoDB database.

public class UserDetails {//setting the parameter for service class
    @Id
    private ObjectId id;
    private String username;
    private String email;
    private String password;


    protected void setUsername(String username){
        this.username = username;
    }
    protected void setEmail(String email){
        this.email = email;
    }
    protected void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }

}
