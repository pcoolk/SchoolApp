package com.prashant.school.schoolapp.service;

import com.prashant.school.schoolapp.constants.AppConstants;
import com.prashant.school.schoolapp.model.Contact;
import com.prashant.school.schoolapp.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class contactService {

    @Autowired
    private ContactRepository contactRepository;

//    private static final Logger log = LoggerFactory.getLogger(contactService.class);

    public boolean saveMessage(Contact contact){
        boolean isSaved = false;
        contact.setStatus(AppConstants.OPEN);
        contact.setCreatedBy(AppConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0){
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(AppConstants.OPEN);
        return contactMsgs;
    }
    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,AppConstants.CLOSE, updatedBy);
        if(result>0){
            isUpdated=true;
        }
        return isUpdated;
    }
}

