package com.autentia.cqrs.application.user.find;

import com.autentia.cqrs.adapter.primary.vo.AddressVO;
import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.domain.Address;
import com.autentia.cqrs.domain.User;
import com.autentia.cqrs.domain.find.UserFinder;
import com.autentia.cqrs.shared.query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class GetUserQueryHandler implements QueryHandler<UserVO, GetUserQuery> {

    private final UserFinder userFinder;

    @Autowired
    public GetUserQueryHandler(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public UserVO handle(GetUserQuery query) {
        User user = userFinder.findUserByNif(query.getNif());
        return toUserVO(user);
    }

    @Override
    public Class<?> getSupportedQueryClass() {
        return GetUserQuery.class;
    }

    private UserVO toUserVO(User user) {
        return new UserVO(user.getNif(), user.getName(), user.getSurname(), user.getEmail(), toAddressVO(user.getAddresses()));
    }

    private Set<AddressVO> toAddressVO(Set<Address> addresses) {
        Set<AddressVO> addressVOs = new HashSet<>();
        addresses.forEach(address -> addressVOs.add(
                new AddressVO(address.getAddress(), address.getCity(), address.getRegion(), address.getPostalCode())
        ));
        return addressVOs;
    }
}
