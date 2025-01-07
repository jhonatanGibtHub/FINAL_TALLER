package com.tallerdesarrollo.PAYMENT.MANAGEMENT.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "pagos")
public class PaymentModel {

    @Id
    @Column(name = "id_pago")
    public Integer idPay;

    @Id
    @Column(name = "id_comprobante")
    public Integer idVoucher;

    @Column(name = "metodo_pago_nombre")
    public String payment_method_name;

    @Column(name = "tipo_pago_nombre")
    public String payment_type_name;

    @Column(name = "monto")
    public String amount;

    @Column(name = "fecha")
    public String date;

    
    
}




