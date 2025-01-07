package com.tallerdesarrollo.PAYMENT.MANAGEMENT.Routes;

public class Routes {
    //ruta base para el cliente
    public static final String pagos = "/payment";

    //rutas especificas
    public static final String GetAll = "/getAll";
    public static final String Create = "/crear";
    public static final String GetById = "/buscar/{id}";
    public static final String Update = "/actualizar";
    public static final String Delete = "/eliminar/{id}";
}