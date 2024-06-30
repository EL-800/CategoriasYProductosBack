package com.ipn.practicacrud.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name = "Producto")
public class Product  implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name="nombreProducto",nullable = false)
    private String nombreProducto;
    @Column(name="descripcionProducto",nullable = false)
    private String descripcionProducto;
    @Column(name="existencia",nullable = false)
    private int existencia;
    @Column(name="precio",nullable = false)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    @JsonBackReference
    private Category idCategoria;
}
