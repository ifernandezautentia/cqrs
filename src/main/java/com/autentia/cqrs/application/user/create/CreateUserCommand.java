package com.autentia.cqrs.application.user.create;

import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.shared.command.Command;

public class CreateUserCommand extends Command {

    private final UserVO user;

    public CreateUserCommand(UserVO user) {
        this.user = user;
    }

    public UserVO getUser() {
        return user;
    }
}
