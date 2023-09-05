package com.caphinance.Controllers;

import com.caphinance.dtos.UserDTO;
import com.caphinance.entities.User;
import com.caphinance.exceptions.InvalidDataException;
import com.caphinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @QueryMapping(name = "getUsers")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @QueryMapping
    public Optional<User> getUser(@Argument(name = "userId") Long id) {
        return userService.findById(id);
    }

    // Mutation: Crea un nuevo usuario
    @MutationMapping
    public User createUser(@Argument(name = "userInput") UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        return userService.save(user);
    }

    // Mutation: Actualiza un usuario existente
    @MutationMapping
    public User updateUser(@Argument(name = "userId") Long id, @Argument(name = "userInput") UserDTO userDTO) {
        User user = userService.findById(id).orElseThrow(() -> new InvalidDataException("User not found"));
        user.setEmail(userDTO.getEmail());
        return userService.update(user);
    }

    // Mutation: Elimina un usuario por su ID
    @MutationMapping
    public Boolean deleteUser(@Argument(name = "userId") Long id) {
        userService.deleteById(id);
        return true;
    }
}
