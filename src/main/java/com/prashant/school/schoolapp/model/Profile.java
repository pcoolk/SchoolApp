package com.prashant.school.schoolapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Profile {
    @NotBlank(message = "enter your full name.")
    @Size(min = 3, message = "enter a valid name.")
    private String name;
    @NotBlank(message = "enter your phone.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "enter a valid phone.")
    private String mobileNumber;
    @NotBlank
    @Email(message = "enter a valid email address.")
    private String email;
    @NotBlank
    @Size(min = 5, message = "enter a valid address.")
    private String address1;
    private String address2;
    @NotBlank
    @Size(min = 5, message = "enter a valid city.")
    private String city;
    @NotBlank
    @Size(min = 5, message = "enter a valid state.")
    private String state;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{6})", message = "valid pincode is of 6 digits.")
    private String zipCode;
}
