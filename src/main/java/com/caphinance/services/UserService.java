package com.caphinance.services;

import com.caphinance.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    User update(User user);
    void deleteById(Long id);
}
