package com.tallerdesarrollo.PAYMENT.MANAGEMENT.Service;


import java.util.List;

import com.tallerdesarrollo.PAYMENT.MANAGEMENT.Model.PaymentModel;

public interface LpaymentService {
    
    public  PaymentModel add(PaymentModel model);

    public PaymentModel update(PaymentModel model);

    public boolean delete(int id);

    public List<PaymentModel> findAll();

    public PaymentModel findById(int id);
}
