package com.autentia.cqrs.adapter.primary.vo;

import lombok.Data;

@Data
public class AddressVO {
    private final String address;
    private final String city;
    private final String region;
    private final String postalCode;
}
