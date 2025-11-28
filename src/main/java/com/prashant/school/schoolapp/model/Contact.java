package com.prashant.school.schoolapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

//@Data is the annotation provided by lombok.
@Data
@Entity
@Table(name = "contact_msg")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "SqlResultSetMapping.count", columns = @ColumnResult(name = "cnt"))
})
@NamedQueries({
        @NamedQuery(name = "Contact.findOpenMsgs",
        query = "select c from Contact c where c.status = :status"),
        @NamedQuery(name = "Contact.updateMsgStatus", query = "update Contact c set c.status = ?1 where c.contactId = ?2")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "Contact.findOpenMsgsNative", query = "select * from contact_msg c where c.status = :status", resultClass = Contact.class),
        @NamedNativeQuery(name = "Contact.findOpenMsgsNative.count", query = "select count(*) as cnt from contact_msg c where c.status = :status",
                resultSetMapping = "SqlResultSetMapping.count"),
        @NamedNativeQuery(name = "Contact.updateMsgStatusNative", query = "update contact_msg c set c.status = ?1 where c.contact_id = ?2")
})


public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "contact_id")
    private int contactId;

    //variable names from contact.html
    @NotBlank(message = "enter a name!")
    @Size(min = 3, message = "enter a valid name!")
    private String name;
    @NotBlank(message = "enter a phone number!")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "enter a valid phone number!")
    private String mobileNum;
    @NotBlank(message = "enter an email address!")
    @Email(message = "enter a valid email address!")
    private String email;
    @NotBlank(message = "enter the subject!")
    @Size(min = 5, message = "Subject should be atleast 5 characters!")
    private String subject;
    @NotBlank(message = "enter a message!")
    @Size(min = 5, message = "message should be atleast 5 characters!")
    private String message;

    /*all the getter setter and toString methods deleted to use Lombok, which automatically initializes
    them automatically
    */
    private String status;
}
