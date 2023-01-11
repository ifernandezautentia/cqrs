package com.autentia.cqrs.adapter.secondary;

import com.autentia.cqrs.adapter.secondary.vo.UserJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserJPARepository extends CrudRepository<UserJPA, Long> {
    UserJPA findByNif(String nif);
}
