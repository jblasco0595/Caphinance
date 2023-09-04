package com.caphinance.Resolvers;

import com.caphinance.dtos.UserDTO;
import com.caphinance.entities.User;
import com.caphinance.exceptions.InvalidDataException;
import com.caphinance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;


import java.util.Optional;
import java.util.List;
import java.util.logging.Logger;

@Component
public class UserResolver {
    private static final Logger logger = Logger.getLogger(UserResolver.class.getName());

    @Autowired
    private UserService userService;

    // Query: Obtiene todos los usuarios
   /* @QueryMapping
    public List<User> getUsers() {
        return userService.findAll();
    }
    */

    @QueryMapping(name = "getUsers")
    public List<User> getUsers() {
        System.out.println("Hola");
        logger.info("Executing getUsers method"); // Agregar log de información
        List<User> users = userService.findAll();
        logger.info("Found " + users.size() + " users"); // Agregar log con información adicional
        return users;
    }

    // Query: Obtiene un usuario por su ID
    @QueryMapping
    public Optional<User> getUser(@Argument Long id) {
        return userService.findById(id);
    }

    // Mutation: Crea un nuevo usuario
    @MutationMapping
    public User createUser(@Argument(name = "UserInput") UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        return userService.save(user);
    }

    // Mutation: Actualiza un usuario existente
    @MutationMapping
    public User updateUser(@Argument Long id, @Argument(name = "UserInput") UserDTO userDTO) {
        User user = userService.findById(id).orElseThrow(() -> new InvalidDataException("User not found"));
        user.setEmail(userDTO.getEmail());
        return userService.update(user);
    }

    // Mutation: Elimina un usuario por su ID
    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        userService.deleteById(id);
        return true;
    }
}
