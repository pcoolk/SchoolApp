package com.prashant.school.schoolapp.service;

import com.prashant.school.schoolapp.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class contactService {

    private static final Logger log = LoggerFactory.getLogger(contactService.class);

    public boolean saveMessage(Contact contact){
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }
}

