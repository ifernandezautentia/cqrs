package com.autentia.cqrs.shared.query;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QueryBusImpl implements QueryBus {

    private Map<Class, QueryHandler> handlersMap;

    public QueryBusImpl(List<QueryHandler> handlers) {
        buildHandlersMap(handlers);
    }

    @Override
    public <T> T execute(Query<T> query) {
        return (T) findHandler(query).handle(query);
    }

    private void buildHandlersMap(List<QueryHandler> handlers) {
        handlersMap = new HashMap<>();
        handlers.forEach(handler -> handlersMap.put(handler.getSupportedQueryClass(), handler));
    }

    private QueryHandler findHandler(Query query) {
        return handlersMap.get(query.getClass());
    }


}
