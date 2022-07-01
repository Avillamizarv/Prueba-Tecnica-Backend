package com.example.pruebatecnica.service.impl;

import com.example.pruebatecnica.model.User;
import com.example.pruebatecnica.repository.IUserRepository;
import com.example.pruebatecnica.service.interfaces.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.beans.FeatureDescriptor;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class for service of table User
 *
 * @author Adriana Villamizar Vera
 * @since 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository iUserRepository;

    /**List all Users*/
    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }

    /**Create a new User*/
    @Override
    @Transactional
    public User createUser(User aUser) {
        return this.iUserRepository.save(aUser);
    }

    /**Delete a User*/
    @Override
    @Transactional
    public void updateUser(User aUser) {
        var userBD = this.iUserRepository.findById(aUser.getId()).orElse(null);
        if(userBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe.");
        }
        else{
            this.copiarPropiedadesObjetoAHaciaBIgnorandoNulosDeA(aUser, userBD);
            userBD.setIdentification(aUser.getIdentification());
            userBD.setName(aUser.getName());
            userBD.setTelephone(aUser.getTelephone());
            aUser = userBD;
            this.iUserRepository.save(aUser);
        }

    }

    /**Delete a User*/
    @Override
    @Transactional
    public void deleteUser (Long aId) throws ResponseStatusException {
        var userBD = this.iUserRepository.findById(aId).orElse(null);
        if(userBD == null ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario a eliminar no existe.");
        }
        else{
            this.iUserRepository.deleteById(userBD.getId());
        }

    }

    /**
     * One by one, the properties from the source to the destination are set, ignoring the fields null
     *
     * @param aOrigenA
     * @param aDestinoB
     * @return aDestinoB
     */
    public static Object copiarPropiedadesObjetoAHaciaBIgnorandoNulosDeA(Object aOrigenA, Object aDestinoB) {
        String[] ignoredAttributes = getAttributesNull(aOrigenA);
        BeanUtils.copyProperties(aOrigenA, aDestinoB, ignoredAttributes);
        return aDestinoB;
    }

    /**
     * Gets the null fields of the object to be analyzed
     *
     * @param object
     * @return wrappedSource
     */
    private static String[] getAttributesNull(Object object) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(object);
        return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
    }

    //Injections
    @Autowired
    public void setiUserRepository(
            IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
}
