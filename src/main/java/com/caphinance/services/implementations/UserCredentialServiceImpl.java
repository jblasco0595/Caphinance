package com.caphinance.services.implementations;

import com.caphinance.entities.UserCredential;
import com.caphinance.repositories.UserCredentialRepository;
import com.caphinance.services.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCredentialServiceImpl implements UserCredentialService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public Optional<UserCredential> findById(Long id) {
        return userCredentialRepository.findById(id);
    }

    @Override
    public List<UserCredential> findAll() {
        return userCredentialRepository.findAll();
    }

    @Override
    public UserCredential save(UserCredential userCredential) {
        return userCredentialRepository.save(userCredential);
    }

    @Override
    public UserCredential update(UserCredential userCredential) {
        // Aquí puedes agregar validaciones antes de actualizar
        return userCredentialRepository.save(userCredential);
    }

    @Override
    public void deleteById(Long id) {
        userCredentialRepository.deleteById(id);
    }
}
