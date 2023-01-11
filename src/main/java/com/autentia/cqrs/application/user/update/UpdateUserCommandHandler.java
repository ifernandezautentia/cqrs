package com.autentia.cqrs.application.user.update;

import com.autentia.cqrs.adapter.primary.vo.AddressVO;
import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.domain.Address;
import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.domain.update.UserUpdater;
import com.autentia.cqrs.shared.command.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UpdateUserCommandHandler implements CommandHandler<UpdateUserCommand> {

    private final UserUpdater userUpdater;

    public UpdateUserCommandHandler(UserUpdater userUpdater) {
        this.userUpdater = userUpdater;
    }

    @Override
    public void handle(UpdateUserCommand command) {
        userUpdater.updateUser(toUser(command.getUser()));
    }

    @Override
    public Class<?> getSupportedCommandClass() {
        return UpdateUserCommand.class;
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
