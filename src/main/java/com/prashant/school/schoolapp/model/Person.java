package com.prashant.school.schoolapp.model;

import com.prashant.school.schoolapp.annotation.FieldsValueMatch;
import com.prashant.school.schoolapp.annotation.PasswordValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.Set;
import java.util.HashSet;

@Getter
@Setter
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "pwd",
                fieldMatch = "confirmPwd",
                message = "Passwords do not match"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email address do not match"
        )

})

public class Person extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native", strategy = "native")
    private int personId;
    @NotBlank(message = "Enter a name.")
    @Size(min = 3,message = "name must be atleast 3 characters long.")
    private String name;
    @NotBlank(message = "enter a mobile number")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number consists of 10 digits.")
    private String mobileNumber;
    @NotBlank
    @Email(message = "enter a valid email")
    private String email;
    @NotBlank(message = "confirm email by retyping the email.")
    @Email
    @Transient
    private String confirmEmail;
    @NotBlank
    @Size(min = 5,message = "password should be atleast 5 characters long")
    @PasswordValidator
    private String pwd;
    @NotBlank
    @Transient
    private String confirmPwd;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false)
    private Roles roles;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = true)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "class_id", referencedColumnName = "classId", nullable = true)
    private EazyClass eazyClass;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_courses",
    joinColumns = {
            @JoinColumn(name = "person_id", referencedColumnName = "personId")},
            inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    })
    private Set<Courses> courses = new HashSet<>();
}
