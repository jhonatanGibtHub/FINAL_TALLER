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
    public ProductoDTO addProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.addProducto(productoDTO);
    }

    // Actualizar un producto por ID
    @PutMapping("/{id}")
    public ProductoDTO updateProducto(@PathVariable String id, @RequestBody ProductoDTO productoDTO) {
        return productoService.updateProducto(id, productoDTO);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id) {
        productoService.deleteProducto(id);
    }
}
