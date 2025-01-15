package com.Taller.gestion_productos.Controller;

import com.Taller.gestion_productos.Model.ProductoModel;
import com.Taller.gestion_productos.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping
    public List<ProductoModel> getAllProductos() {
        return productoRepository.findAll();
    }

    // Agregar un nuevo producto
    @PostMapping
    public ProductoModel addProducto(@RequestBody ProductoModel producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto por ID
    @PutMapping("/{id}")
    public ProductoModel updateProducto(@PathVariable String id, @RequestBody ProductoModel producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id) {
        productoRepository.deleteById(id);
    }
}
