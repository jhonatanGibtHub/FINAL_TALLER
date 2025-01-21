package com.tallerdesarrollo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserRoleId.class) // Indica que se usará una clave compuesta
public class UserRoleModel {

    @Id
    private Integer idUsuario;

    @Id
    private String rolNombre;

    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false) // Relación con la tabla `usuarios`
    private UserModel userModel;
}

