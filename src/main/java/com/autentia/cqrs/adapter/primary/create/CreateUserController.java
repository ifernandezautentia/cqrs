package com.autentia.cqrs.adapter.primary.create;

import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.application.user.create.CreateUserCommand;
import com.autentia.cqrs.shared.command.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

    private final CommandBus commandBus;

    @Autowired
    public CreateUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserVO request) {
        commandBus.execute(new CreateUserCommand(request));
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
