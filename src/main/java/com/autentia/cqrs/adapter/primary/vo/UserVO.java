package com.autentia.cqrs.adapter.primary.vo;

import com.autentia.cqrs.domain.Address;
import lombok.Data;

import java.util.Set;

@Data
public class UserVO {
    private final String nif;
    private final String name;
    private final String surname;
    private final String email;
    private final Set<AddressVO> addresses;
}
