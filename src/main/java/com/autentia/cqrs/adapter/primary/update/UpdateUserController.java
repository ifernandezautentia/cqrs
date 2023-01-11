package com.autentia.cqrs.adapter.primary.update;

import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.application.user.update.UpdateUserCommand;
import com.autentia.cqrs.shared.command.CommandBus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateUserController {

    private final CommandBus commandBus;

    public UpdateUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PutMapping("/user/{nif}")
    public void updateUser(
            @PathVariable("nif") String nif,
            @RequestBody UserVO request) {
        UpdateUserCommand command = new UpdateUserCommand(request);
        commandBus.execute(command);
    }
}
