package com.caphinance.Controllers;

import com.caphinance.dtos.UserCredentialDTO;
import com.caphinance.entities.User;
import com.caphinance.entities.UserCredential;
import com.caphinance.services.UserCredentialService;
import com.caphinance.services.UserService;
import com.caphinance.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;
import java.util.List;
import java.util.Optional;

@Controller
public class UserCredentialController {
    private static final Logger logger = Logger.getLogger(UserCredentialController.class.getName());

    @Autowired
    private UserCredentialService userCredentialService;

    @Autowired
    private UserService userService;

    @QueryMapping(name = "getUserCredentials")
    public List<UserCredential> getUserCredentials() {
        return userCredentialService.findAll();
    }

    @QueryMapping
    public Optional<UserCredential> getUserCredential(@Argument(name = "credentialId") Long id) {
        return userCredentialService.findById(id);
    }

    @MutationMapping
    public UserCredential createUserCredential(@Argument(name = "userCredentialInput") UserCredentialDTO userCredentialDTO) {
        Optional<User> user = userService.findById(userCredentialDTO.getUserId());
        UserCredential userCredential = new UserCredential();
        userCredential.setUser(user.orElseThrow(() -> new InvalidDataException("User " + userCredentialDTO.getUserId() + " not exist")));
        userCredential.setPasswordHash(userCredentialDTO.getPasswordHash());
        userCredential.setAccessToken(userCredentialDTO.getAccessToken());
        userCredential.setRefreshToken(userCredentialDTO.getRefreshToken());
        return userCredentialService.save(userCredential);
    }

    @MutationMapping
    public UserCredential updateUserCredential(@Argument(name = "credentialId") Long id, @Argument(name = "userCredentialInput") UserCredentialDTO userCredentialDTO) {
        UserCredential userCredential = userCredentialService.findById(id).orElseThrow(() -> new InvalidDataException("Credential not found"));
        userCredential.setPasswordHash(userCredentialDTO.getPasswordHash());
        userCredential.setAccessToken(userCredentialDTO.getAccessToken());
        userCredential.setRefreshToken(userCredentialDTO.getRefreshToken());
        return userCredentialService.update(userCredential);
    }
    @MutationMapping
    public Boolean deleteUserCredential(@Argument(name = "credentialId") Long id) {
        userCredentialService.deleteById(id);
        return true;
    }
}
