package Customer_Management.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClientModel {
    
    @Id
    @Column(name = "id_cliente")
    public Integer idClient;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "email")
    public String email;

    @Column(name = "telefono")
    public String telefono;
    
    @Column(name ="direccion")
    public String direccion;

    @Column(name = "fecha_creacion")
    public String fechaCreacion;



}
