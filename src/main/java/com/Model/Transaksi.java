package com.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable{
        

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = users.class, cascade= CascadeType.ALL)
    @JoinColumn(name = "id_peminjam", referencedColumnName = "id")
    private users userPeminjam;

    @ManyToOne(targetEntity = users.class, cascade= CascadeType.ALL)
    @JoinColumn(name = "id_meminjam", referencedColumnName = "id")
    private users userMeminjam;

    @Column(name= "tenor", nullable = false)
    private int tenor;

    @Column(name= "total_pinjaman", nullable = false)
    private double total_pinjaman;

    @Column(name= "bunga_persen", nullable = false)
    private double bunga_persen;

    @Column(name= "status", nullable = false, length = 1337)
    private String status;

}
