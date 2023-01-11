package com.autentia.cqrs.shared.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandBusImpl implements CommandBus {

    private Map<Class, CommandHandler> handlersMap;

    @Autowired
    public CommandBusImpl(List<CommandHandler> handlers) {
        buildHandlersMap(handlers);
    }

    @Override
    public void execute(Command command) {
        findHandler(command).handle(command);
    }

    private void buildHandlersMap(List<CommandHandler> handlers) {
        handlersMap = new HashMap<>();
        handlers.forEach(handler -> handlersMap.put(handler.getSupportedCommandClass(), handler));
    }

    private CommandHandler findHandler(Command command) {
        return handlersMap.get(command.getClass());
    }


}
