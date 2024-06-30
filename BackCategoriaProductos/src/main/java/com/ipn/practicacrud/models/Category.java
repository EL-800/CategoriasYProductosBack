package com.ipn.practicacrud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="Categoria")

public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    @Column(name="nombreCategoria",nullable = false)
    private String nombreCategoria;
    @Column(name="descripcionCategoria",nullable = false)
    private String descripcionCategoria;

    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> productos;
}
