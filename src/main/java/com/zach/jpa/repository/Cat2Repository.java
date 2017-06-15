package com.zach.jpa.repository;

import com.zach.jpa.domain.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Cat2Repository extends CrudRepository<Cat, Integer>{

    @Query("from Cat where catName=:catName")
    public Cat findByCatName(@Param("catName")String catName);
}
