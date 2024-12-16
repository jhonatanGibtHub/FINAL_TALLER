package Customer_Management.routes;

public class routes {
    
    //ruta base para el cliente
    public static final String Client = "/clients";

    //rutas especificas
    public static final String GetAll = "/getAll";
    public static final String Create = "/crear";
    public static final String GetById = "/buscar/{id}";
    public static final String Update = "/actualizar";
    public static final String Delete = "/eliminar/{id}";
}
