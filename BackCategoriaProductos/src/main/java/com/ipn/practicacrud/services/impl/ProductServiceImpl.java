package com.ipn.practicacrud.services.impl;

import com.ipn.practicacrud.DTO.ProductosCategoriasDTO;
import com.ipn.practicacrud.models.Category;
import com.ipn.practicacrud.models.Product;
import com.ipn.practicacrud.models.requestModels.RequestProduct;
import com.ipn.practicacrud.repository.Categoria.CategoryRepository;
import com.ipn.practicacrud.repository.Producto.ProductRepository;
import com.ipn.practicacrud.services.CategoryService;
import com.ipn.practicacrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductosCategoriasDTO> getAllProctCategory() {
        var data = repository.ObtenerCategoriasProductos();
        var listaCategoria = new ArrayList<ProductosCategoriasDTO>();
        for(var dato : data){
            var productoCategotia = new ProductosCategoriasDTO(dato[0].toString(),Integer.parseInt(dato[1].toString()));
            listaCategoria.add(productoCategotia);
        }
        return listaCategoria;
    }
    @Override
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category getCateogoriaByProductId(int id) {
        Product product = repository.findById(id).orElse(null);
        return product != null ? product.getIdCategoria() : null;
    }

    @Override
    public Product saveProduct(RequestProduct product) {
        Category category = categoryRepository.findById(product.idCategoria).orElse(null);
        if(category == null)
            return null;
        Product newProduct = new Product();
        newProduct.setNombreProducto(product.nombreProducto);
        newProduct.setDescripcionProducto(product.descripcionProducto);
        newProduct.setExistencia(product.existencia);
        newProduct.setPrecio(product.precio);
        newProduct.setIdCategoria(category);
        return repository.save(newProduct);
    }

    @Override
    public Product updateProduct(int id, RequestProduct product) {
        Product existingProduct = repository.findById(id).orElse(null);
        if(existingProduct == null)
            return null;


        existingProduct.setNombreProducto(product.nombreProducto);
        existingProduct.setPrecio(product.precio);
        existingProduct.setExistencia(product.existencia);
        existingProduct.setDescripcionProducto(product.descripcionProducto);

        Category category = categoryRepository.findById(product.idCategoria).orElse(null);
        if(category == null)
            return null;
        existingProduct.setIdCategoria(category);
        repository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public Boolean deleteProductById(int id) {
        Product product = repository.findById(id).orElse(null);
        if(product == null)
            return false;
        repository.delete(product);
        return true;
    }
}
