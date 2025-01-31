package Customer_Management.Service;

import java.util.List;

import Customer_Management.Error.LocalNotFoundException;
import Customer_Management.Model.ClientModel;

public interface IClientService {
    
    public ClientModel add(ClientModel model);

    public ClientModel update(ClientModel model);

    public boolean delete(int id) throws LocalNotFoundException;

    public List<ClientModel> findAll();

    public ClientModel findById(int id) throws LocalNotFoundException;
}
