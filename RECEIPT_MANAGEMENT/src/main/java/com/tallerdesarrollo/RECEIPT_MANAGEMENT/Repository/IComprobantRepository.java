package com.tallerdesarrollo.RECEIPT_MANAGEMENT.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tallerdesarrollo.RECEIPT_MANAGEMENT.Model.ComprobantModel;

@Repository
public interface IComprobantRepository extends CrudRepository<ComprobantModel, Integer> {

}
