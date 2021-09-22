package com.holy.ws.entities.concretes.utilities;


import com.holy.ws.entities.abstracts.Occupant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/**
 * @author Vugar Mammadli
 */

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phoneNumberId;

    @Column(name = "PHONE_NUMBER_TYPE")
    private PhoneNumberType phoneNumberType;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
