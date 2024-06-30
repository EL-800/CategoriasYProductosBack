package com.ipn.practicacrud.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "paterno",nullable = false)
    private String paterno;
    @Column(name = "materno",nullable = false)
    private String materno;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
}
