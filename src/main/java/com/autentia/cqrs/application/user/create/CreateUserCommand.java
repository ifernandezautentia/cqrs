package com.autentia.cqrs.application.user.create;

import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.shared.command.Command;
import lombok.Data;

@Data
public class CreateUserCommand extends Command {
    private final UserVO user;
}
