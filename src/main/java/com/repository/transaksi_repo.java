package com.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.Model.Transaksi;


@Repository
public interface transaksi_repo extends PagingAndSortingRepository<Transaksi, Long>{
    @Query("select c from transaksi c")
    public Page<Transaksi> getList(Pageable pageable);


    @Query("select c from transaksi c WHERE c.id = :id")
    public Transaksi getbyID(@Param("id") Long id);

    @Query("select c from transaksi c where c.status = :status")
    Page<Transaksi> findByStatus(String status, Pageable show_data);

}
