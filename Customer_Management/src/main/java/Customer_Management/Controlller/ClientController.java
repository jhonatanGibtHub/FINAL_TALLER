package Customer_Management.Controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import Customer_Management.Model.ClientModel;
import Customer_Management.Service.ClientService;
import Customer_Management.routes.routes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(routes.Client)
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(routes.GetAll)
    public List<ClientModel> getAll() {
        return clientService.findAll();
    }

    @PostMapping(routes.Create)
    public ClientModel Create(@RequestBody ClientModel model) {
        return clientService.add(model);
    }

    @GetMapping(routes.GetById)
    public ClientModel getById(@PathVariable int id) {
        return clientService.findById(id);
    }

    @PutMapping(routes.Update)
    public ClientModel update(@RequestBody ClientModel model) {
        return clientService.update(model);
    }
    
    @DeleteMapping(routes.Delete)
    public boolean delete(@PathVariable int id) {
        return clientService.delete(id);
    }
    
}
