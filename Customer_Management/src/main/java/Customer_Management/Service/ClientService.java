package Customer_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Customer_Management.Model.ClientModel;
import Customer_Management.repository.IClientRepository;

@Service
public class ClientService implements IClientService{
    

    @Autowired
    IClientRepository repository;

    @Override
    public ClientModel add(ClientModel model) {
        return repository.save(model);
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<ClientModel> findAll() {
        return (List<ClientModel>) repository.findAll();
    }

    @Override
    public ClientModel findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public ClientModel update(ClientModel model) {
        return repository.save(model);
    }

   
}
