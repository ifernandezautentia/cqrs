package com.autentia.cqrs.domain;

public interface UserRepository {
    void createUser(User user);

    User findUserByNif(String nif);

    void updateUser(User user);

    void deleteUserByNif(String nif);
}
