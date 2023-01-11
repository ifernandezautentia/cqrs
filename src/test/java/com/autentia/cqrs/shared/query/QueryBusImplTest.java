package com.autentia.cqrs.shared.query;

import com.autentia.cqrs.application.user.find.GetUserQuery;
import com.autentia.cqrs.application.user.find.GetUserQueryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class QueryBusImplTest {

    private final GetUserQueryHandler getUserQueryHandler = mock(GetUserQueryHandler.class);

    private List<QueryHandler> handlers;

    private QueryBusImpl sut;

    @BeforeEach
    void setup() {
        doReturn(GetUserQuery.class).when(getUserQueryHandler).getSupportedQueryClass();
        handlers = Arrays.asList(getUserQueryHandler);
        sut = new QueryBusImpl(handlers);
    }

    @Test
    void shouldHandleGetUserQuery() {
        final GetUserQuery query = new GetUserQuery("nif");
        sut.execute(query);
        verify(getUserQueryHandler).handle(eq(query));
    }

}