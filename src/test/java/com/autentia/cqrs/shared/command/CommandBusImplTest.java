package com.autentia.cqrs.shared.command;

import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.application.user.create.CreateUserCommand;
import com.autentia.cqrs.application.user.create.CreateUserCommandHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

class CommandBusImplTest {

    private final CreateUserCommandHandler createUserCommandHandler = mock(CreateUserCommandHandler.class);

    @BeforeEach
    void setup() {
        doReturn(CreateUserCommand.class).when(createUserCommandHandler).getSupportedCommandClass();
    }


    @Test
    void shouldHandleCommand() {
        final List<CommandHandler> handlers = asList(createUserCommandHandler);
        final CommandBusImpl sut = new CommandBusImpl(handlers);
        final CreateUserCommand command = new CreateUserCommand(mock(UserVO.class));

        sut.execute(command);

        verify(createUserCommandHandler).handle(eq(command));
    }

}