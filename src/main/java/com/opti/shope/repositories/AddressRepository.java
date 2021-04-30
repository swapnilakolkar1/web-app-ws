package com.opti.shope.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opti.shope.io.entity.AddressEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long>{

}
