package com.Taller.gestion_productos.Service;
import com.Taller.gestion_productos.dto.ProductoDTO;
import com.Taller.gestion_productos.Exception.ProductoNotFoundException;
import com.Taller.gestion_productos.Model.ProductoModel;
import com.Taller.gestion_productos.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    

    private ProductoModel toEntity(ProductoDTO dto) {
        ProductoModel producto = new ProductoModel();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoriaNombre(dto.getCategoriaNombre());
        return producto;
    }
}