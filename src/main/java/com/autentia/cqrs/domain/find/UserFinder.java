package com.autentia.cqrs.domain.find;

import com.autentia.cqrs.adapter.secondary.DatabaseRepository;
import com.autentia.cqrs.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFinder {

    private final DatabaseRepository databaseRepository;

    @Autowired
    public UserFinder(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public User findUserByNif(String nif) {
        return databaseRepository.findUserByNif(nif);
    }
}
