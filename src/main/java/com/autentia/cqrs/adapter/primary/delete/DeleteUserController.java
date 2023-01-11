package com.autentia.cqrs.adapter.primary.delete;

import com.autentia.cqrs.application.user.delete.DeleteUserCommand;
import com.autentia.cqrs.shared.command.CommandBus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserController {

    private final CommandBus commandBus;

    public DeleteUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @DeleteMapping("/user/{nif}")
    public void deleteUser(@PathVariable("nif") String nif) {
        DeleteUserCommand command = new DeleteUserCommand(nif);
        commandBus.execute(command);
    }
}