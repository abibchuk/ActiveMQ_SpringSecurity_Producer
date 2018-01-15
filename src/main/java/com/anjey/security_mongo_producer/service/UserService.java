package com.anjey.security_mongo_producer.service;

import com.anjey.security_mongo_producer.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List getAllUsers() {
        return userRepository.getAllUsers();
    }

    public JSONObject createUser(String username, String password, List roles) {
        return new JSONObject(userRepository.createUser(username, password, roles).toMap());
    }

    public JSONObject getUserByUsername(String username) {
        return new JSONObject(userRepository.findUserByUsername(username).toMap());
    }

}
