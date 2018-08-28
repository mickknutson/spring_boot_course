package com.springclass.boot.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    // Select u from User u WHERE u.firstName == 'Mick'

    User findUserByFirstName(String firstName);

    User findUserByFirstNameAndLastName(String firstName, String lastName);

//    User findUserByLastName(String lastName);
//
//    User findUserByFirstNameAndLastName(String fName, String lName);
//
    Boolean existsByFirstName(String firstName);
    Boolean existsByLastName(String lastName);

}