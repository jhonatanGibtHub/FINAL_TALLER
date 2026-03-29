package com.Taller.gestion_productos.Repository;
import com.Taller.gestion_productos.Model.ProductoModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<ProductoModel, String> {
}

