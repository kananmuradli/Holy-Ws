package com.holy.ws.entities.concretes.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
class AddressEmbed {

    private String country;

    private String city;

    private String street;

    private String postalCode;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressEmbed)) return false;
        AddressEmbed addressEmbed = (AddressEmbed) o;
        return  Objects.equals(getCountry(), addressEmbed.getCountry()) && Objects.equals(getCity(), addressEmbed.getCity()) && Objects.equals(getStreet(), addressEmbed.getStreet()) && Objects.equals(getPostalCode(), addressEmbed.getPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getCountry(), getCity(), getStreet(), getPostalCode());
    }
}
