package com.Taller.gestion_productos.Controller;

import com.Taller.gestion_productos.dto.ProductoDTO;

import com.Taller.gestion_productos.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return productoService.getAllProductos();
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
