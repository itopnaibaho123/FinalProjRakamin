package com.repository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Model.users;

@Repository
public interface users_repo extends PagingAndSortingRepository<users, Long> {
    @Query("select c from users c WHERE c.id = :id")
    public users getbyID(@Param("id") Long id);

    @Query("select c from users c WHERE c.username = :username")// nama class
    Page<users> getbyNama(String username, Pageable pageable);

    @Query("select c from users c")// nama class
    Page<users> getAllData(Pageable pageable);

}
