package com.autentia.cqrs.domain.create;

import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreator {

    private final UserRepository userRepository;

    @Autowired
    public UserCreator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

}
