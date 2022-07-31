package com.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name= "user_detail")
public class user_detail implements Serializable{
    

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private users user;

    @Column(name= "nama", nullable = false, length = 45)
    private String nama;

    @Column(name= "alamat", nullable = false, length = 1337)
    private String alamat;

}
