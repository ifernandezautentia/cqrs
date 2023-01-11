package com.autentia.cqrs.shared.query;

public interface QueryHandler<T, U extends Query<T>> {
    T handle(U query);

    Class<?> getSupportedQueryClass();
}
