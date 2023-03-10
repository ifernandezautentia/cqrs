package com.autentia.cqrs.application.user.create;

import com.autentia.cqrs.adapter.primary.vo.AddressVO;
import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.domain.Address;
import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.domain.create.UserCreator;
import com.autentia.cqrs.shared.command.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    private final UserCreator userCreator;

    @Autowired
    public CreateUserCommandHandler(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @Override
    public void handle(CreateUserCommand command) {
        User user = toUser(command.getUser());
        userCreator.createUser(user);
    }

    @Override
    public Class<?> getSupportedCommandClass() {
        return CreateUserCommand.class;
    }

    private User toUser(UserVO user) {
        return new User(user.getNif(), user.getName(), user.getSurname(), user.getEmail(), toAddress(user.getAddresses()));
    }

    private Set<Address> toAddress(Set<AddressVO> addresses) {
        final Set<Address> convertedAddresses = new HashSet<>();
        addresses.forEach(address -> convertedAddresses.add(new Address(address.getAddress(), address.getCity(), address.getRegion(), address.getPostalCode())));
        return convertedAddresses;
    }
}
