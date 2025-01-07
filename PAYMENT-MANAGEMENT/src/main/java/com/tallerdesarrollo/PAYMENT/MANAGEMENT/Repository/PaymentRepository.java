package com.tallerdesarrollo.PAYMENT.MANAGEMENT.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tallerdesarrollo.PAYMENT.MANAGEMENT.Model.PaymentModel;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentModel, Integer> {

}
