package com.autentia.cqrs.adapter.primary.delete;

import com.autentia.cqrs.application.user.delete.DeleteUserCommand;
import com.autentia.cqrs.domain.delete.UserDeleter;
import com.autentia.cqrs.shared.command.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserCommandHandler implements CommandHandler<DeleteUserCommand> {

    private final UserDeleter userDeleter;

    public DeleteUserCommandHandler(UserDeleter userDeleter) {
        this.userDeleter = userDeleter;
    }

    @Override
    public void handle(DeleteUserCommand command) {
        userDeleter.deleteUser(command.getNif());
    }

    @Override
    public Class<?> getSupportedCommandClass() {
        return DeleteUserCommand.class;
    }
}
