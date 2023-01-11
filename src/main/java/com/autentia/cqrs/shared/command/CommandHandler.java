package com.autentia.cqrs.shared.command;

public interface CommandHandler<T extends Command> {
    void handle(T command);

    Class<?> getSupportedCommandClass();
}
