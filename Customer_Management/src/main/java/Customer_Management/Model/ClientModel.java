package Customer_Management.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message ="Rellene este campo")
    public String nombre;

    @Column(name = "email")
    @NotBlank(message ="Este campo es obligatorio")
    public String email;

    @Column(name = "telefono")
    @NotBlank(message ="Este campo es obligatorio")
    public String telefono;
    
    @Column(name ="direccion")
    @NotBlank(message ="Este campo es obligatorio")
    public String direccion;

    @Column(name = "fecha_creacion")
    @NotNull(message ="Este campo es obligatorio")
    public String fechaCreacion;



}
