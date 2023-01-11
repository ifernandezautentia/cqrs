package com.autentia.cqrs.application.user.find;

import com.autentia.cqrs.adapter.primary.vo.UserVO;
import com.autentia.cqrs.shared.query.Query;
import lombok.Data;

@Data
public class GetUserQuery extends Query<UserVO> {
    private final String nif;
}
