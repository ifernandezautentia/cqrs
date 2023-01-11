package com.autentia.cqrs.domain;

import lombok.Data;

@Data
public class Address {
    private final String address;
    private final String city;
    private final String region;
    private final String postalCode;
}
