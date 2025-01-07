

package com.tallerdesarrollo.PAYMENT.MANAGEMENT.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tallerdesarrollo.PAYMENT.MANAGEMENT.Model.PaymentModel;
import com.tallerdesarrollo.PAYMENT.MANAGEMENT.Service.PaymentService;
import com.tallerdesarrollo.PAYMENT.MANAGEMENT.Routes.Routes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(Routes.pagos)
public class PaymentController {
    @Autowired
    PaymentService paymentService;  

    @GetMapping( Routes.GetAll)
    public List<PaymentModel> getAll() {
        return paymentService.findAll();
    }

    @PostMapping(Routes.Create)
    public PaymentModel Create(@RequestBody PaymentModel model) {
        return paymentService.add(model);
    }

    @GetMapping(Routes.GetById)
    public PaymentModel getById(@PathVariable int id) {
        return paymentService.findById(id);
    }

    @PutMapping(Routes.Update)
    public PaymentModel update(@RequestBody PaymentModel model) {
        return paymentService.update(model);
    }

    @DeleteMapping(Routes.Delete)
    public boolean delete(@PathVariable int id) {
        return paymentService.delete(id);
    }


}
