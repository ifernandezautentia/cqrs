package com.autentia.cqrs.adapter.secondary;

import com.autentia.cqrs.adapter.secondary.vo.AddressJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AddressJPARepository extends CrudRepository<AddressJPA, Long> {
}
