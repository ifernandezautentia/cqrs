package com.autentia.cqrs.application.user.delete;

import com.autentia.cqrs.shared.command.Command;
import lombok.Data;

@Data
public class DeleteUserCommand extends Command {
    private final String nif;
}
