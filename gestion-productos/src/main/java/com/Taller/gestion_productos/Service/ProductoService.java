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
    public List<ProductoDTO> getAllProductos() {
        return productoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    } 
    
    public ProductoDTO addProducto(ProductoDTO productoDTO) {
        ProductoModel producto = toEntity(productoDTO);
        return toDTO(productoRepository.save(producto));
    } 

    private ProductoDTO toDTO(ProductoModel producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setCategoriaNombre(producto.getCategoriaNombre());
        return dto;
    }

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