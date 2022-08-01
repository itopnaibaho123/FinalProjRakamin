package com.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="payment_history")
public class payment_history implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "payment_history", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id")
    private List<Transaksi> transaksi;

    @Column(name= "pembayaran_ke", nullable = false)
    private int pembayaran_ke;

    @Column(name= "jumlah", nullable = false)
    private double jumlah;
    
    @Column(name = "bukti_pembayaran", nullable = false, length = 45)
    private String bukti_pembayaran;

}
