package com.autentia.cqrs.domain.update;

import com.autentia.cqrs.adapter.secondary.DatabaseRepository;
import com.autentia.cqrs.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserUpdater {

    private final DatabaseRepository databaseRepository;

    public UserUpdater(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public void updateUser(User user) {
        databaseRepository.updateUser(user);
    }
}
