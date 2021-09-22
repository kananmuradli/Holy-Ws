package com.holy.ws.entities.concretes.utilities;


import com.holy.ws.entities.concretes.pages.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
/**
 * @author Vugar Mammadli
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address implements Comparable<Address> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "pageId")
    private Page page;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return  Objects.equals(getCountry(), address.getCountry()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getPostalCode(), address.getPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getCountry(), getCity(), getStreet(), getPostalCode());
    }

    @Override
    public int compareTo(Address o) {
        return Integer.compare(o.country.length(), this.country.length());
    }
}
