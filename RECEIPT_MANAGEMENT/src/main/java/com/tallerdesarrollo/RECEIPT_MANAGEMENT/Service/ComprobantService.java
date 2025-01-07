package com.tallerdesarrollo.RECEIPT_MANAGEMENT.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tallerdesarrollo.RECEIPT_MANAGEMENT.Model.ComprobantModel;
import com.tallerdesarrollo.RECEIPT_MANAGEMENT.Repository.IComprobantRepository;

@Service
public class ComprobantService implements IComprobantService {

    @Autowired
    IComprobantRepository repository;

    @Override
    public ComprobantModel add(ComprobantModel model) {
        return repository.save(model);
    }

    @Override
    public boolean delete(int id) {
        Optional<ComprobantModel> comprobant = repository.findById(id);
        if (comprobant.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ComprobantModel> findAll() {
        return (List<ComprobantModel>) repository.findAll();
    }

    @Override
    public ComprobantModel findById(int id) {
        return repository.findById(id).orElse(null);
    }

  

    @Override
    public ComprobantModel update(ComprobantModel model) {
        return repository.save(model);
    }
}
