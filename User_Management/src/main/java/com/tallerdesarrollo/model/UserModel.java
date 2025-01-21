package com.tallerdesarrollo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido paterno debe tener entre 2 y 50 caracteres")
    private String apellidoPaterno;

    @NotBlank(message = "El apellido materno es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido materno debe tener entre 2 y 50 caracteres")
    private String apellidoMaterno;

    @NotBlank(message = "El sexo es obligatorio")
    @Pattern(regexp = "^(Masculino|Femenino|Otro)$", message = "El sexo debe ser 'Masculino', 'Femenino' o 'Otro'")
    private String sexo;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El celular es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El celular debe tener exactamente 9 dígitos")
    private String celular;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 5, max = 15, message = "El nombre de usuario debe tener entre 5 y 15 caracteres")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 20, message = "La contraseña debe tener entre 6 y 20 caracteres")
    private String password;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_config", nullable = false)
    private ConfiguracionEmpresa configuracionEmpresa;

    @Size(max = 20, message = "El código de vendedor no debe exceder los 20 caracteres")
    private String codigoVendedor;
}
