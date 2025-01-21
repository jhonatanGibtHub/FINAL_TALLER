-- TABLA DE CONFIGURACIÓN DE LA EMPRESA
CREATE TABLE configuracion_empresa (
    id_config INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa VARCHAR(100) NOT NULL,
    ruc VARCHAR(11) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(100),
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- TABLA DE USUARIOS
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    sexo ENUM('M', 'F') NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    celular VARCHAR(15),
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    estado ENUM('ACTIVO', 'INACTIVO') NOT NULL DEFAULT 'ACTIVO',
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_config INT NOT NULL,
    codigo_vendedor VARCHAR(50) UNIQUE,
    FOREIGN KEY (id_config) REFERENCES configuracion_empresa(id_config) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- TABLA CATÁLOGO
CREATE TABLE catalogo (
    id_catalogo INT AUTO_INCREMENT PRIMARY KEY,
    tipo_catalogo ENUM('ROL', 'PRIVILEGIO', 'METODO_PAGO', 'TIPO_PAGO', 'CATEGORIA_PRODUCTO', 'TIPO_COMPROBANTE') NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    UNIQUE (tipo_catalogo, nombre)
);

-- TABLA INTERMEDIA USUARIO_ROL
CREATE TABLE usuario_rol (
    id_usuario INT NOT NULL,
    rol_nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_usuario, rol_nombre),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

-- TABLA INTERMEDIA ROL_PRIVILEGIO
CREATE TABLE rol_privilegio (
    rol_nombre VARCHAR(100) NOT NULL,
    privilegio_nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (rol_nombre, privilegio_nombre)
);

-- TABLA DE CLIENTES
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(15),
    direccion VARCHAR(255),
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- TABLA DE PRODUCTOS
CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    categoria_nombre VARCHAR(100) NOT NULL
);

-- TABLA DE MOVIMIENTOS DE INVENTARIO
CREATE TABLE movimientos_inventario (
    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    id_producto INT NOT NULL,
    tipo_movimiento ENUM('ENTRADA', 'SALIDA') NOT NULL,
    cantidad INT NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_usuario INT,
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE SET NULL ON UPDATE CASCADE
);

-- TABLA DE COMPROBANTES
CREATE TABLE comprobantes (
    id_comprobante INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_usuario INT NOT NULL,
    id_config INT NOT NULL,
    tipo_comprobante_nombre VARCHAR(100) NOT NULL,
    serie_comprobante VARCHAR(10) NOT NULL,
    numero_comprobante INT NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (id_config) REFERENCES configuracion_empresa(id_config) ON DELETE RESTRICT ON UPDATE CASCADE,
    UNIQUE (tipo_comprobante_nombre, serie_comprobante, numero_comprobante)
);

-- TABLA DE DETALLE DE COMPROBANTES
CREATE TABLE detalle_comprobante (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_comprobante INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_comprobante) REFERENCES comprobantes(id_comprobante) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- TABLA DE PAGOS
CREATE TABLE pagos (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    id_comprobante INT NOT NULL,
    metodo_pago_nombre VARCHAR(100) NOT NULL,
    tipo_pago_nombre VARCHAR(100) NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_comprobante) REFERENCES comprobantes(id_comprobante) ON DELETE CASCADE ON UPDATE CASCADE
);

-- TABLA DE VENTAS POR USUARIO
CREATE TABLE ventas_por_usuario (
    id_usuario INT PRIMARY KEY,
    total_ventas DECIMAL(10, 2) NOT NULL DEFAULT 0,
    ultima_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    codigo_vendedor VARCHAR(50),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

-- INSERTAR DATOS EN CONFIGURACIÓN DE LA EMPRESA
INSERT INTO configuracion_empresa (nombre_empresa, ruc, direccion, telefono, email) 
VALUES 
('Empresa Ejemplo S.A.', '12345678901', 'Av. Principal 123, Ciudad', '0123456789', 'contacto@empresa.com');

-- INSERTAR DATOS EN USUARIOS
INSERT INTO usuarios (nombre, apellido_paterno, apellido_materno, sexo, fecha_nacimiento, celular, username, password, estado, id_config, codigo_vendedor) 
VALUES 
('Juan', 'Perez', 'Lopez', 'M', '1990-01-15', '987654321', 'jperez', 'password123', 'ACTIVO', 1, 'VEN123'),
('Maria', 'Garcia', 'Fernandez', 'F', '1985-06-20', '987654322', 'mgarcia', 'password456', 'ACTIVO', 1, 'VEN124');

-- INSERTAR DATOS EN CLIENTES
INSERT INTO clientes (nombre, email, telefono, direccion) 
VALUES 
('Carlos Ramirez', 'carlos.ramirez@example.com', '987654323', 'Calle Secundaria 456, Ciudad'),
('Ana Torres', 'ana.torres@example.com', '987654324', 'Av. Tercera 789, Ciudad');

-- INSERTAR DATOS EN PRODUCTOS
INSERT INTO productos (nombre_producto, descripcion, precio, stock, categoria_nombre) 
VALUES 
('Laptop Dell', 'Laptop de alta gama', 3500.00, 10, 'Electrónica'),
('Camiseta', 'Camiseta de algodón', 50.00, 100, 'Ropa');

-- INSERTAR DATOS EN MOVIMIENTOS DE INVENTARIO
INSERT INTO movimientos_inventario (id_producto, tipo_movimiento, cantidad, id_usuario) 
VALUES 
(1, 'ENTRADA', 10, 1), 
(2, 'ENTRADA', 100, 1);

-- INSERTAR DATOS EN COMPROBANTES
INSERT INTO comprobantes (id_cliente, id_usuario, id_config, tipo_comprobante_nombre, serie_comprobante, numero_comprobante, total) 
VALUES 
(1, 1, 1, 'Factura', 'F001', 1, 5000.00),
(2, 2, 1, 'Boleta', 'B001', 1, 100.00);

-- INSERTAR DETALLES EN DETALLE DE COMPROBANTES
INSERT INTO detalle_comprobante (id_comprobante, id_producto, cantidad, precio_unitario, subtotal) 
VALUES 
(1, 1, 1, 3500.00, 3500.00), 
(2, 2, 2, 50.00, 100.00);

-- INSERTAR DATOS EN PAGOS
INSERT INTO pagos (id_comprobante, metodo_pago_nombre, tipo_pago_nombre, monto) 
VALUES 
(1, 'Efectivo', 'Contado', 5000.00), 
(2, 'Tarjeta', 'Crédito', 100.00);

-- INSERTAR DATOS EN VENTAS POR USUARIO
INSERT INTO ventas_por_usuario (id_usuario, total_ventas, codigo_vendedor) 
VALUES 
(1, 5000.00, 'VEN123'), 
(2, 100.00, 'VEN124');

-- INSERTAR DATOS EN USUARIO_ROL
INSERT INTO usuario_rol (id_usuario, rol_nombre) 
VALUES 
(1, 'Administrador'), 
(2, 'Vendedor');

-- INSERTAR DATOS EN ROL_PRIVILEGIO
INSERT INTO rol_privilegio (rol_nombre, privilegio_nombre) 
VALUES 
('Administrador', 'Acceso a Ventas'), 
('Administrador', 'Acceso a Inventario'), 
('Vendedor', 'Acceso a Ventas');


