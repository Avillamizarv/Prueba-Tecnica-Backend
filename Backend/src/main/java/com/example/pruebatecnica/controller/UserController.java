package com.example.pruebatecnica.controller;

import com.example.pruebatecnica.dto.UserDTO;
import com.example.pruebatecnica.mapper.UserMapper;
import com.example.pruebatecnica.model.User;
import com.example.pruebatecnica.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.transaction.TransactionScoped;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class for User
 *
 * @author Adriana Villamizar Vera
 * @since 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    private IUserService iUserService;

    /**
     * Return a list of all Users
     *
     * @return List<User>
     */
    @GetMapping(value = "/getUsers")
    public ResponseEntity<List<UserDTO>> findAll() throws ResponseStatusException{
        List<User> usersList = iUserService
                .findAll();
        if (usersList.isEmpty() || usersList == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay usuarios registrados." );
        } else
        {
            return new ResponseEntity<>(usersList.stream()
                    .map(UserMapper.INSTANCE::toUserDTO).collect(Collectors.toList()),
                    HttpStatus.OK);
        }

    }
    /**
     * Create User
     * @return UserDTO
     */
    @TransactionScoped
    @PostMapping(value = "/newUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO aUserDTO) {
        var user = this.iUserService.createUser(UserMapper.INSTANCE.toUser(aUserDTO));
        return new ResponseEntity<>(UserMapper.INSTANCE.toUserDTO(user), HttpStatus.CREATED);
    }

    /**
     * Update User
     */

    @PutMapping("/updateUser")
    public ResponseEntity<UserDTO> updateUser( @RequestBody UserDTO aUserDTO) {
        this.iUserService.updateUser(UserMapper.INSTANCE.toUser(aUserDTO));
        return new ResponseEntity<>(aUserDTO, HttpStatus.CREATED);
    }

    /**
     * Delete User
     */
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "id") Long aId) {
        this.iUserService.deleteUser(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //Injections
    @Autowired
    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }
}
