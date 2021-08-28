package com.opti.shope.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opti.shope.io.entity.PassbookEntity;

@Repository
public interface PassbookRepository extends CrudRepository<PassbookEntity, Long> {

}
