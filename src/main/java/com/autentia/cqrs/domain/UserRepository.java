package com.autentia.cqrs.domain;

public interface UserRepository {

    void createUser(User user);

    User findUserByNif(String nif);
}
