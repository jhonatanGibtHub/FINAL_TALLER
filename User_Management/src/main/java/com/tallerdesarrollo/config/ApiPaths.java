package com.tallerdesarrollo.config;

public class ApiPaths {

    private ApiPaths() {
        // Constructor privado para evitar instanciación
    }

    public static final String BASE_PATH = "/api/v1";

    // Rutas para usuarios
    public static final String USERS = BASE_PATH + "/usuarios";
    public static final String USER_BY_ID = USERS + "/{id}";

    // Rutas para roles
    public static final String ROLES = BASE_PATH + "/roles";
    public static final String ROLE_BY_ID = ROLES + "/{id}";

    // Rutas para privilegios
    public static final String PRIVILEGES = BASE_PATH + "/privilegios";
    public static final String PRIVILEGE_BY_ID = PRIVILEGES + "/{id}";

    // Ruta para autenticación
    public static final String AUTH = BASE_PATH + "/auth";
}
