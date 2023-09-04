package com.caphinance.services;

import com.caphinance.entities.UserProfile;

import java.util.List;

public interface UserProfileService {
    UserProfile findById(Long id);
    List<UserProfile> findAll();
    UserProfile save(UserProfile userProfile);
    UserProfile update(UserProfile userProfile);
    void deleteById(Long id);
}
