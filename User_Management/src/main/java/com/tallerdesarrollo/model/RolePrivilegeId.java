package com.tallerdesarrollo.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class RolePrivilegeId implements Serializable {
    private String rolNombre;
    private String privilegioNombre;
}
