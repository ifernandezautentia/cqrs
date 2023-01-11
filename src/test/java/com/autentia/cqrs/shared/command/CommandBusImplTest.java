package com.autentia.cqrs.shared.command;

import com.autentia.cqrs.adapter.primary.delete.DeleteUserCommandHandler;
import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.application.user.create.CreateUserCommand;
import com.autentia.cqrs.application.user.create.CreateUserCommandHandler;
import com.autentia.cqrs.application.user.delete.DeleteUserCommand;
import com.autentia.cqrs.application.user.update.UpdateUserCommand;
import com.autentia.cqrs.application.user.update.UpdateUserCommandHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

class CommandBusImplTest {

    private final CreateUserCommandHandler createUserCommandHandler = mock(CreateUserCommandHandler.class);
    private final DeleteUserCommandHandler deleteUserCommandHandler = mock(DeleteUserCommandHandler.class);
    private final UpdateUserCommandHandler updateUserCommandHandler = mock(UpdateUserCommandHandler.class);

    private List<CommandHandler> handlers;

    private CommandBusImpl sut;


    @BeforeEach
    void setup() {
        doReturn(CreateUserCommand.class).when(createUserCommandHandler).getSupportedCommandClass();
        doReturn(DeleteUserCommand.class).when(deleteUserCommandHandler).getSupportedCommandClass();
        doReturn(UpdateUserCommand.class).when(updateUserCommandHandler).getSupportedCommandClass();
        handlers = asList(createUserCommandHandler, deleteUserCommandHandler, updateUserCommandHandler);
        sut = new CommandBusImpl(handlers);
    }

    @Test
    void shouldHandleCreateUserCommand() {
        final CreateUserCommand command = new CreateUserCommand(mock(UserVO.class));
        sut.execute(command);
        verify(createUserCommandHandler).handle(eq(command));
    }

    @Test
    void shouldHandleDeleteUserCommand() {
        final DeleteUserCommand command = new DeleteUserCommand("nif");
        sut.execute(command);
        verify(deleteUserCommandHandler).handle(eq(command));
    }

    @Test
    void shouldHandleUpdateUserCommand() {
        final UpdateUserCommand command = new UpdateUserCommand(mock(UserVO.class));
        sut.execute(command);
        verify(updateUserCommandHandler).handle(eq(command));
    }

}