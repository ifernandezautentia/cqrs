package com.autentia.cqrs.adapter.primary.search;

import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.application.user.find.GetUserQuery;
import com.autentia.cqrs.shared.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserController {

    private final QueryBus queryBus;

    @Autowired
    public GetUserController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/user/{nif}")
    public ResponseEntity<UserVO> findUser(@PathVariable("nif") String nif) {
        final GetUserQuery query = new GetUserQuery(nif);
        final UserVO response = queryBus.execute(query);
        return ResponseEntity.ok().body(response);
    }
}
