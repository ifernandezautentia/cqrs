package com.autentia.cqrs.shared.command;

public interface CommandBus {
    void execute(Command command);
}
