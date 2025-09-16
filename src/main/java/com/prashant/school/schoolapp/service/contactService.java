package com.prashant.school.schoolapp.service;

import com.prashant.school.schoolapp.constants.AppConstants;
import com.prashant.school.schoolapp.model.Contact;
import com.prashant.school.schoolapp.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class contactService {

    @Autowired
    private ContactRepository contactRepository;

//    private static final Logger log = LoggerFactory.getLogger(contactService.class);

    public boolean saveMessage(Contact contact){
        boolean isSaved = false;
        contact.setStatus(AppConstants.OPEN);
//now handled by jpa auditor, configured in BaseEntity:
//        contact.setCreatedBy(AppConstants.ANONYMOUS);
//        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact  = contactRepository.save(contact);
        if(null!=savedContact && savedContact.getContactId()>0){
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(AppConstants.OPEN);
        return contactMsgs;
    }
//    , String updatedBy - parameter removed from updateMsgStatus
    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(AppConstants.CLOSE);
//            now handled by jpa auditor, configured in BaseEntity
//            contact1.setUpdatedBy(updatedBy);
//            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if (null != updatedContact && updatedContact.getUpdatedBy()!=null){
            isUpdated = true;
        }

        return isUpdated;
    }
}

