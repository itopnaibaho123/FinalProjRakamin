package com.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.Model.user_detail;

@Repository
public interface user_detail_repo extends PagingAndSortingRepository<user_detail, Long> {
    
}
