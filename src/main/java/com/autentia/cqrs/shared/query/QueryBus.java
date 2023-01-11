package com.autentia.cqrs.shared.query;

public interface QueryBus {
    <T> T execute(Query<T> query);
}
