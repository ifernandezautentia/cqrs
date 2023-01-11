package com.autentia.cqrs.application.user.find;

import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.domain.find.UserFinder;
import com.autentia.cqrs.shared.query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserQueryHandler implements QueryHandler<User, GetUserQuery> {

    private final UserFinder userFinder;

    @Autowired
    public GetUserQueryHandler(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public User handle(GetUserQuery query) {
        return userFinder.findUserByNif(query.getNif());
    }

    @Override
    public Class<?> getSupportedQueryClass() {
        return GetUserQuery.class;
    }
}
