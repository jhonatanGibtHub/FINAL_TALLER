package com.tallerdesarrollo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RolePrivilegeId.class) // Indica que esta entidad tiene una clave compuesta
public class RolePrivilegeModel {

    @Id
    private String rolNombre;

    @Id
    private String privilegioNombre;
}
