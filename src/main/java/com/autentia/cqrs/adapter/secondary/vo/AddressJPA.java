package com.autentia.cqrs.adapter.secondary.vo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "address")
@NoArgsConstructor
public class AddressJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", allocationSize = 1)
    private Long id;
    private String address;
    private String city;
    private String region;
    private String postalCode;

    private Long userId;

    public AddressJPA(String address, String city, String region, String postalCode, Long userId) {
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.userId = userId;
    }
}
