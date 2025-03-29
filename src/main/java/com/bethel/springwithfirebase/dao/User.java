package com.bethel.springwithfirebase.dao;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.ServerTimestamp;
import lombok.Data;

import java.util.Date;
@Data
public class User {
    @DocumentId
    private String id;
    
    private String username;
    private String emailId;

    @ServerTimestamp
    private Date createdAt;
}
