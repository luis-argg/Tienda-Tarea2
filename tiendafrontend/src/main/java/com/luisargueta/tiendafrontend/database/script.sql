drop database if exists tienda_act2_in5bv;
CREATE DATABASE tienda_act2_in5bv;
use tienda_act2_in5bv;

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(60) NOT NULL,
    apellido_usuario VARCHAR(60) NOT NULL,
    edad_usuario INT NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Insertando registros
INSERT INTO usuario (nombre_usuario, apellido_usuario, edad_usuario, user_name, password) VALUES
('Juan', 'Perez', 25, 'juanperez', 'contraseña123'),
('Maria', 'Gomez', 30, 'mariagomez', 'contraseña456'),
('Carlos', 'Lopez', 22, 'carloslopez', 'contraseña789'),
('Ana', 'Martinez', 28, 'anamartinez', 'contraseña101'),
('Luis', 'Rodriguez', 35, 'luisrodriguez', 'contraseña202'),
('Sofia', 'Hernandez', 27, 'sofiahernandez', 'contraseña303'),
('Miguel', 'Garcia', 40, 'miguelgarcia', 'contraseña404'),
('Laura', 'Fernandez', 24, 'laurafernandez', 'contraseña505'),
('Jorge', 'Sanchez', 31, 'jorgesanchez', 'contraseña606'),
('Elena', 'Ramirez', 29, 'elenaramirez', 'contraseña707'),
('Pedro', 'Torres', 33, 'pedrotorres', 'contraseña808'),
('Valeria', 'Flores', 26, 'valeriaflores', 'contraseña909'),
('Diego', 'Vargas', 21, 'diegovargas', 'contraseña010'),
('Lucia', 'Castro', 23, 'luciacastro', 'contraseña111'),
('Andres', 'Ortega', 38, 'andresortega', 'contraseña212'),
('Camila', 'Rojas', 20, 'camilarojas', 'contraseña313'),
('Fernando', 'Mendoza', 45, 'fernandomendoza', 'contraseña414'),
('Daniela', 'Silva', 32, 'danielasilva', 'contraseña515'),
('Ricardo', 'Morales', 36, 'ricardomorales', 'contraseña616'),
('Paula', 'Navarro', 27, 'paulanavarro', 'contraseña717'),
('Hector', 'Delgado', 34, 'hectordelgado', 'contraseña818'),
('Gabriela', 'Cruz', 28, 'gabrielacruz', 'contraseña919'),
('Alberto', 'Reyes', 41, 'albertreyes', 'contraseña020'),
('Natalia', 'Guerrero', 22, 'nataliguerrero', 'contraseña121'),
('Esteban', 'Paredes', 37, 'estebanparedes', 'contraseña222');

CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(255) NOT NULL,
    descripcion_categoria VARCHAR(255) DEFAULT NULL
);

-- Insertando registros
INSERT INTO categoria (nombre_categoria, descripcion_categoria) VALUES
('Electrónica', 'Dispositivos electrónicos y tecnología'),
('Ropa', 'Prendas de vestir para todas las edades'),
('Calzado', 'Zapatos, tenis y sandalias'),
('Hogar', 'Artículos para el hogar y decoración'),
('Cocina', 'Utensilios y accesorios de cocina'),
('Belleza', 'Productos de cuidado personal y estética'),
('Salud', 'Productos relacionados con el bienestar y la salud'),
('Deportes', 'Artículos deportivos y fitness'),
('Juguetes', 'Juguetes para niños y entretenimiento'),
('Libros', 'Libros de diferentes géneros'),
('Papelería', 'Material escolar y de oficina'),
('Mascotas', 'Productos para el cuidado de mascotas'),
('Automotriz', 'Accesorios y productos para vehículos'),
('Jardinería', 'Herramientas y productos para jardín'),
('Tecnología', 'Accesorios tecnológicos y gadgets'),
('Accesorios', 'Complementos como relojes, gafas, etc.'),
('Alimentos', 'Productos alimenticios'),
('Bebidas', 'Bebidas alcohólicas y no alcohólicas'),
('Limpieza', 'Productos de limpieza y desinfección'),
('Ferretería', 'Herramientas y materiales de construcción');

CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(255) NOT NULL,
    precio_producto DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

-- Insertando registros
INSERT INTO producto (nombre_producto, precio_producto, stock, id_categoria) VALUES
('Smartphone Samsung Galaxy', 599.99, 15, 1),
('Audífonos Bluetooth', 49.99, 30, 1),
('Camiseta básica', 14.99, 50, 2),
('Jeans azul', 39.99, 40, 2),
('Zapatillas deportivas', 69.99, 25, 3),
('Sandalias casuales', 24.99, 35, 3),
('Lámpara de mesa', 29.99, 20, 4),
('Cojín decorativo', 19.99, 30, 4),
('Juego de cuchillos', 49.99, 15, 5),
('Sartén antiadherente', 34.99, 20, 5),
('Crema facial', 22.50, 40, 6),
('Perfume mujer', 55.00, 25, 6),
('Vitaminas C', 12.99, 60, 7),
('Termómetro digital', 18.99, 30, 7),
('Balón de fútbol', 25.00, 35, 8),
('Mancuernas 5kg', 45.00, 20, 8),
('Muñeca clásica', 19.99, 30, 9),
('Carro a control remoto', 29.99, 25, 9),
('Novela de ficción', 15.99, 40, 10),
('Libro de cocina', 20.00, 20, 10),
('Cuaderno universitario', 3.50, 100, 11),
('Bolígrafos pack', 5.99, 80, 11),
('Alimento para perro', 25.99, 30, 12),
('Juguete para gato', 9.99, 50, 12),
('Aceite de motor', 29.99, 25, 13),
('Cargador de auto', 14.99, 40, 13),
('Maceta grande', 18.00, 20, 14),
('Pala de jardín', 12.50, 30, 14),
('Teclado mecánico', 79.99, 15, 15),
('Mouse inalámbrico', 25.99, 35, 15),
('Reloj de pulsera', 49.99, 20, 16),
('Gafas de sol', 19.99, 30, 16),
('Arroz 1kg', 2.50, 100, 17),
('Pasta 500g', 1.99, 120, 17),
('Refresco cola', 1.50, 200, 18),
('Jugo natural', 2.20, 150, 18),
('Detergente líquido', 8.99, 60, 19),
('Desinfectante', 5.50, 70, 19),
('Martillo', 12.99, 25, 20),
('Destornillador', 7.99, 40, 20);

CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    fecha_pedido VARCHAR(255) NOT NULL,
    total_pedido DOUBLE NOT NULL,
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

-- Insertando registros
INSERT INTO pedido (fecha_pedido, total_pedido, id_usuario) VALUES
('2025-01-01', 120.50, 1),
('2025-01-02', 89.99, 2),
('2025-01-03', 45.00, 3),
('2025-01-04', 230.75, 4),
('2025-01-05', 150.20, 5),
('2025-01-06', 99.99, 6),
('2025-01-07', 60.00, 7),
('2025-01-08', 310.40, 8),
('2025-01-09', 27.99, 9),
('2025-01-10', 180.00, 10),
('2025-01-11', 75.35, 11),
('2025-01-12', 49.90, 12),
('2025-01-13', 220.10, 13),
('2025-01-14', 15.99, 14),
('2025-01-15', 500.00, 15),
('2025-01-16', 35.50, 16),
('2025-01-17', 420.80, 17),
('2025-01-18', 199.99, 18),
('2025-01-19', 85.75, 19),
('2025-01-20', 66.60, 20),
('2025-01-21', 140.00, 21),
('2025-01-22', 275.30, 22),
('2025-01-23', 33.33, 23),
('2025-01-24', 58.80, 24),
('2025-01-25', 90.10, 25);

CREATE TABLE detalle_pedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    precio_unitario DOUBLE NOT NULL,
    id_pedido INT,
    id_producto INT,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Insertando registros
INSERT INTO detalle_pedido (cantidad, precio_unitario, id_pedido, id_producto) VALUES
(1, 599.99, 1, 1),
(2, 49.99, 1, 2),
(1, 14.99, 2, 3),
(1, 39.99, 2, 4),
(2, 69.99, 3, 5),
(1, 24.99, 3, 6),
(1, 29.99, 4, 7),
(3, 19.99, 4, 8),
(1, 49.99, 5, 9),
(1, 34.99, 5, 10),
(2, 22.50, 6, 11),
(1, 55.00, 6, 12),
(3, 12.99, 7, 13),
(1, 18.99, 7, 14),
(1, 25.00, 8, 15),
(2, 45.00, 8, 16),
(2, 19.99, 9, 17),
(1, 29.99, 9, 18),
(1, 15.99, 10, 19),
(1, 20.00, 10, 20),
(4, 3.50, 11, 21),
(2, 5.99, 11, 22),
(1, 25.99, 12, 23),
(3, 9.99, 12, 24),
(1, 29.99, 13, 25),
(2, 14.99, 13, 26),
(2, 18.00, 14, 27),
(1, 12.50, 14, 28),
(1, 79.99, 15, 29),
(2, 25.99, 15, 30),
(1, 49.99, 16, 31),
(2, 19.99, 16, 32),
(5, 2.50, 17, 33),
(3, 1.99, 17, 34),
(6, 1.50, 18, 35),
(4, 2.20, 18, 36),
(2, 8.99, 19, 37),
(3, 5.50, 19, 38),
(1, 12.99, 20, 39),
(2, 7.99, 20, 40);


