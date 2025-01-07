package com.tallerdesarrollo.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sexo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    private String celular;
    private String username;
    private String password;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "id_config", referencedColumnName = "id_config")
    private EmpresaModel empresa;

    @Column(name = "codigo_vendedor")
    private String codigoVendedor;
}
