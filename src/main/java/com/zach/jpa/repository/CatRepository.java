package com.zach.jpa.repository;

import com.zach.jpa.domain.Cat;
import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Integer>{

}
