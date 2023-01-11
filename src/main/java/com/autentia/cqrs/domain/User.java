package com.autentia.cqrs.domain;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private final String nif;
    private final String name;
    private final String surname;
    private final String email;
    private final Set<Address> addresses;
}
