package com.autentia.cqrs.adapter.primary.search;

import com.autentia.cqrs.adapter.primary.vo.AddressVO;
import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.application.user.find.GetUserQuery;
import com.autentia.cqrs.domain.Address;
import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.shared.query.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

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
        final UserVO response = transformResponseToUserVO(queryBus.execute(query));
        return ResponseEntity.ok().body(response);
    }

    private UserVO transformResponseToUserVO(User user) {
        return new UserVO(user.getNif(), user.getName(), user.getSurname(), user.getEmail(), transformAddresses(user.getAddresses()));
    }

    private Set<AddressVO> transformAddresses(Set<Address> addresses) {
        final Set<AddressVO> transformedAddresses = new HashSet<>();
        addresses.forEach(address -> transformedAddresses.add(
                new AddressVO(address.getAddress(), address.getCity(), address.getRegion(), address.getPostalCode())
        ));
        return transformedAddresses;
    }


}
