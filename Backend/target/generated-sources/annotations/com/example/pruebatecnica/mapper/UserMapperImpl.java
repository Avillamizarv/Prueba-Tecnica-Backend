package com.example.pruebatecnica.mapper;

import com.example.pruebatecnica.dto.UserDTO;
import com.example.pruebatecnica.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T12:43:13-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setIdentification( userDTO.getIdentification() );
        user.setName( userDTO.getName() );
        user.setTelephone( userDTO.getTelephone() );

        return user;
    }

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setIdentification( user.getIdentification() );
        userDTO.setName( user.getName() );
        userDTO.setTelephone( user.getTelephone() );

        return userDTO;
    }
}
