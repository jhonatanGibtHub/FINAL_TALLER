package Customer_Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Customer_Management.Error.LocalNotFoundException;
import Customer_Management.Model.ClientModel;
import Customer_Management.repository.IClientRepository;

@Service
public class ClientService implements IClientService{
    

    @Autowired
    IClientRepository repository;

    @Override
    public ClientModel add(ClientModel model){

        return repository.save(model);
        
    }

    @Override
    public boolean delete(int id) throws LocalNotFoundException {
       //Busca en base de datos
        Optional<ClientModel> Cliente = repository.findById(id);
        //Validación
        if (!Cliente.isPresent()) {
            throw new LocalNotFoundException("Esta id no existe");
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<ClientModel> findAll() {
        return (List<ClientModel>) repository.findAll();
    }

    @Override
    public ClientModel findById(int id) throws LocalNotFoundException {
        return repository.findById(id).get();
    }

    @Override
    public ClientModel update(ClientModel model) {
        return repository.save(model);
    }

   
}
