package com.tallerdesarrollo.RECEIPT_MANAGEMENT.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Comprobante")

public class ComprobantModel {

    @Id
    @Column(name = "id_comprobante")
    public Integer idComprobant;

    @Id
    @Column(name = "id_cliente")
    public Integer idClient;

    @Id
    @Column(name = "id_usuario")
    public Integer idUsuario;

    @Id
    @Column(name = "id_config")
    public Integer idConfig;

    @Column(name = "tipo_comprobante_nombre")
    public String tipo_Comprobant_nom;

    @Column(name = "serie_Comprobante")
    public String serie_Comprobant;

    @Column(name = "numero_Comprobante")
    public Integer numero_Comprobant;

    @Column(name = "fecha")
    public String fecha_Comprobant;

    @Column(name = "total")
    public double total_Comprobant;



}
