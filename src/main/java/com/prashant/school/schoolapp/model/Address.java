package com.prashant.school.schoolapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native", strategy = "native")
    private int addressId;
    @NotBlank(message = "enter address")
    @Size(min = 5, message = "write a valid address.")
    private String address1;
    private String address2;
    @NotBlank(message = "enter your city")
    private String city;
    @NotBlank(message = "enter your state")
    private String state;
    @NotBlank(message = "enter your Zipcode")
    @Pattern(regexp = "(^$|[0-9]{6})", message = "enter a valid Pin/Zip code")
    private int pincode;
}
