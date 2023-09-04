package com.caphinance.services;

import com.caphinance.entities.UserCredential;

import java.util.List;

public interface UserCredentialService {
    UserCredential findById(Long id);
    List<UserCredential> findAll();
    UserCredential save(UserCredential userCredential);
    UserCredential update(UserCredential userCredential);
    void deleteById(Long id);
}
