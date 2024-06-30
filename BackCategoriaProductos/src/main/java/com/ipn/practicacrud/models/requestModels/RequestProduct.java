package com.ipn.practicacrud.models.requestModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ipn.practicacrud.models.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RequestProduct {
    public int idProducto;
    public String nombreProducto;
    public String descripcionProducto;
    public int existencia;
    public double precio;
    public int idCategoria;

}
