package com.zach.jpa.repository;

import com.zach.jpa.domain.Cat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface Cat3Repository extends PagingAndSortingRepository<Cat, Integer>{
}
