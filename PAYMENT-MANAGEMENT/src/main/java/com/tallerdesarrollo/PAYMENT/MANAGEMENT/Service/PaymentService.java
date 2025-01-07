
package com.tallerdesarrollo.PAYMENT.MANAGEMENT.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tallerdesarrollo.PAYMENT.MANAGEMENT.Model.PaymentModel;
import com.tallerdesarrollo.PAYMENT.MANAGEMENT.Repository.PaymentRepository;

@Service
public class PaymentService implements LpaymentService {

    @Autowired
    PaymentRepository repository;

    @Override
    public PaymentModel add(PaymentModel model) {
        return repository.save(model);
    }

    @Override
    public boolean delete(int id) {
        Optional<PaymentModel> Payment = repository.findById(id);
        if (Payment.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<PaymentModel> findAll() {
        return (List<PaymentModel>) repository.findAll();
    }

    @Override
    public PaymentModel findById(int id) {
        return repository.findById(id).orElse(null);
    }

  

    @Override
    public PaymentModel update(PaymentModel model) {
        return repository.save(model);
    }
}
