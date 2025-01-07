package Customer_Management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Customer_Management.Model.ClientModel;

@Repository
public interface IClientRepository extends CrudRepository<ClientModel, Integer> {

    
}
