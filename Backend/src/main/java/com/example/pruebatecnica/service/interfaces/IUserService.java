package com.example.pruebatecnica.service.interfaces;

import com.example.pruebatecnica.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for User
 *
 * @author Adriana Villamizar Vera
 * @since 1.0
 */
@Service
public interface IUserService {

    List<User> findAll();

    User createUser(User aUser);

    void deleteUser(Long aId);

    void updateUser(User aUser);
}
