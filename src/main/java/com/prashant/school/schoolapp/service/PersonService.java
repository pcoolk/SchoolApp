package com.prashant.school.schoolapp.service;

import com.prashant.school.schoolapp.constants.AppConstants;
import com.prashant.school.schoolapp.model.Person;
import com.prashant.school.schoolapp.model.Roles;
import com.prashant.school.schoolapp.repository.PersonRepository;
import com.prashant.school.schoolapp.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RolesRepository rolesRepository;

    public boolean createNewUser(Person person){
        boolean isSaved = false;
        Roles Role = rolesRepository.getByRoleName(AppConstants.STUDENT_ROLE);
        person.setRoles(Role);
        person = personRepository.save(person);
        if(null!=person && person.getPersonId()>0){
            isSaved = true;
        }
        return isSaved;
    }


}
