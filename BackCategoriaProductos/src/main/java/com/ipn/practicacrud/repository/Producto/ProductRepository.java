package com.ipn.practicacrud.repository.Producto;


import com.ipn.practicacrud.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "call CategoriasProductos()",nativeQuery = true)
    List<Object[]> ObtenerCategoriasProductos();
}
