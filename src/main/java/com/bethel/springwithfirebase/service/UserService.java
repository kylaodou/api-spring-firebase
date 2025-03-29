package com.bethel.springwithfirebase.service;

import com.bethel.springwithfirebase.dao.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private Firestore firestore;

    //CREATE USER
    public String createUser(User user)  {
        try {
            ApiFuture<DocumentReference> users = firestore.collection("users").add(user);
            return "Document saved : userID " + users.get().getId();
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public User getUser(String userId)  {
        ApiFuture<DocumentSnapshot> users = firestore.collection("users").document(userId).get();
        try {
            return users.get().toObject(User.class);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
