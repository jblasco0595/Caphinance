package com.caphinance.services.implementations;

import com.caphinance.entities.UserProfile;
import com.caphinance.repositories.UserProfileRepository;
import com.caphinance.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public Optional<UserProfile> findById(Long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
    @Override
    public UserProfile update(UserProfile userProfile) {
        // Aquí puedes agregar validaciones antes de actualizar
        return userProfileRepository.save(userProfile);
    }
    @Override
    public void deleteById(Long id) {
        userProfileRepository.deleteById(id);
    }
}
