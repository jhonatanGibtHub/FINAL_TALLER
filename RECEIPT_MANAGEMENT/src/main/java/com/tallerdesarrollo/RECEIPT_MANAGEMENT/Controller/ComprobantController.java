package com.tallerdesarrollo.RECEIPT_MANAGEMENT.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tallerdesarrollo.RECEIPT_MANAGEMENT.Model.ComprobantModel;
import com.tallerdesarrollo.RECEIPT_MANAGEMENT.Service.ComprobantService;
import com.tallerdesarrollo.RECEIPT_MANAGEMENT.Routes.routes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(routes.Comprobant)
public class ComprobantController {
    @Autowired
    ComprobantService comprobantService;  

    @GetMapping(routes.GetAll)
    public List<ComprobantModel> getAll() {
        return comprobantService.findAll();
    }

    @PostMapping(routes.Create)
    public ComprobantModel Create(@RequestBody ComprobantModel model) {
        return comprobantService.add(model);
    }

    @GetMapping(routes.GetById)
    public ComprobantModel getById(@PathVariable int id) {
        return comprobantService.findById(id);
    }

    @PutMapping(routes.Update)
    public ComprobantModel update(@RequestBody ComprobantModel model) {
        return comprobantService.update(model);
    }

    @DeleteMapping(routes.Delete)
    public boolean delete(@PathVariable int id) {
        return comprobantService.delete(id);
    }


}
