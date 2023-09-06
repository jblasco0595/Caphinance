package com.caphinance.services;

import com.caphinance.entities.UserCredential;

import java.util.List;
import java.util.Optional;

public interface UserCredentialService {
    Optional<UserCredential> findById(Long id);
    List<UserCredential> findAll();
    UserCredential save(UserCredential userCredential);
    UserCredential update(UserCredential userCredential);
    void deleteById(Long id);
}
