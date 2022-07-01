package com.example.pruebatecnica.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * MODEL for User
 * @author Adriana Villamizar Vera
 * @since 1.0
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "USUARIO", schema = "pruebatecnica")
public class User implements Serializable {

    private static final long serialVersionUID = 6799955020412675540L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IDENTIFICACION")
    private String identification;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "TELEFONO")
    private String telephone;
}
