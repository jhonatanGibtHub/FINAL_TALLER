package com.tallerdesarrollo.RECEIPT_MANAGEMENT.Service;

import java.util.List;

import com.tallerdesarrollo.RECEIPT_MANAGEMENT.Model.ComprobantModel;

public interface IComprobantService {
    
    public ComprobantModel add(ComprobantModel model);

    public ComprobantModel update(ComprobantModel model);

    public boolean delete(int id);

    public List<ComprobantModel> findAll();

    public ComprobantModel findById(int id);
}
