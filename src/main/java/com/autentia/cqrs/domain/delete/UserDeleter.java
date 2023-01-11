package com.autentia.cqrs.domain.delete;

import com.autentia.cqrs.adapter.secondary.DatabaseRepository;
import org.springframework.stereotype.Component;

@Component
public class UserDeleter {

    private final DatabaseRepository databaseRepository;

    public UserDeleter(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public void deleteUser(String nif) {
        databaseRepository.deleteUserByNif(nif);
    }
}
