package com.autentia.cqrs.application.user.find;

import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.shared.query.Query;

public class GetUserQuery extends Query<User> {

    private final String nif;

    public GetUserQuery(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }
}
