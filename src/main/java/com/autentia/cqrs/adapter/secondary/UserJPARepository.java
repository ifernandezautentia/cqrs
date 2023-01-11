package com.autentia.cqrs.adapter.secondary;

import com.autentia.cqrs.adapter.secondary.vo.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserJPARepository extends JpaRepository<UserJPA, Long> {
    UserJPA findByNif(String nif);
}
