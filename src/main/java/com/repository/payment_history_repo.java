package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Model.payment_history;

@Repository
public interface payment_history_repo extends PagingAndSortingRepository<payment_history, Long>{
    @Query("select c from payment_history c")
    public List<payment_history> getList();

    @Query("Select c from payment_history c where c.id = :id")
    public payment_history getbyID(@Param("id") Long id);
    
}
