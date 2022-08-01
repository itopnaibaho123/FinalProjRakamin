package com.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Model.Transaksi;


@Repository
public interface transaksi_repo extends PagingAndSortingRepository<Transaksi, Long>{
    @Query("select c from transaksi c")
    public List<Transaksi> getList();

    @Query("UPDATE transaksi SET status = 'Lunas' WHERE id = :id ")
    public Transaksi setStatus(Long id); 

    @Query("select c from users c WHERE c.id = :id")
    public Transaksi getbyID(@Param("id") Long id);

}
