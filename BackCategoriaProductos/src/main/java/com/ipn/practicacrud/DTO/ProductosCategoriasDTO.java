package com.ipn.practicacrud.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductosCategoriasDTO implements Serializable {
    private String Categoria;
    private int Cantidad;

    public ProductosCategoriasDTO(String Categoria, int Cantidad){
        setCategoria(Categoria);
        setCantidad(Cantidad);
    }
}
