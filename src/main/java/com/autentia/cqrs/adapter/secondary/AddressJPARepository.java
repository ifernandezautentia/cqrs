package com.autentia.cqrs.adapter.secondary;

import com.autentia.cqrs.adapter.secondary.vo.AddressJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AddressJPARepository extends JpaRepository<AddressJPA, Long> {
}
