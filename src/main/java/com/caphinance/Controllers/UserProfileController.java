package com.caphinance.Controllers;

import com.caphinance.dtos.UserCredentialDTO;
import com.caphinance.dtos.UserProfileDTO;
import com.caphinance.entities.User;
import com.caphinance.entities.UserCredential;
import com.caphinance.entities.UserProfile;
import com.caphinance.exceptions.InvalidDataException;
import com.caphinance.services.UserProfileService;
import com.caphinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.text.ParseException;



@Controller
public class UserProfileController {
    private static final Logger logger = Logger.getLogger(UserCredentialController.class.getName());

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserService userService;

    @QueryMapping(name = "getUserProfiles")
    public List<UserProfile> getUserProfiles() {
        return userProfileService.findAll();
    }

    @QueryMapping(name = "getUserProfile")
    public Optional<UserProfile> getUserProfile(@Argument(name = "profileId") Long id) {
        return userProfileService.findById(id);
    }

    @MutationMapping
    public UserProfile createUserProfile(@Argument(name = "userProfileInput") UserProfileDTO userProfileDTO) {
        Optional<User> user = userService.findById(userProfileDTO.getUserId());
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user.orElseThrow(() -> new InvalidDataException("User " + userProfileDTO.getUserId() + " not exist")));
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setSecondName(userProfileDTO.getSecondName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setSecondLastName(userProfileDTO.getSecondLastName());
        userProfile.setNickname(userProfileDTO.getNickname());
        /*userProfile.setDateOfBirth();*/

        userProfile.setCountry(userProfileDTO.getCountry());
        userProfile.setAddress(userProfileDTO.getAddress());
        userProfile.setPostalCode(userProfileDTO.getPostalCode());
        userProfile.setPhoneNumber(userProfileDTO.getPhoneNumber());

        return userProfileService.save(userProfile);
    }

    @MutationMapping
    public UserProfile updateUserProfile(@Argument(name = "profileId") Long id, @Argument(name = "userProfileInput") UserProfileDTO userProfileDTO) {
        UserProfile userProfile = userProfileService.findById(id).orElseThrow(() -> new InvalidDataException("Profile not found"));
        userProfile.setFirstName(userProfileDTO.getFirstName());
        userProfile.setSecondName(userProfileDTO.getSecondName());
        userProfile.setLastName(userProfileDTO.getLastName());
        userProfile.setSecondLastName(userProfileDTO.getSecondLastName());
        userProfile.setNickname(userProfileDTO.getNickname());
        /*userProfile.setDateOfBirth();*/

        userProfile.setCountry(userProfileDTO.getCountry());
        userProfile.setAddress(userProfileDTO.getAddress());
        userProfile.setPostalCode(userProfileDTO.getPostalCode());
        userProfile.setPhoneNumber(userProfileDTO.getPhoneNumber());
        return userProfileService.update(userProfile);
    }
    @MutationMapping
    public Boolean deleteUserProfile(@Argument(name = "profileId") Long id) {
        userProfileService.deleteById(id);
        return true;
    }
}
