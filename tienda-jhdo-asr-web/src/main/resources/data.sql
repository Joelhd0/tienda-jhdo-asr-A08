-- MARCAS 
INSERT INTO marcas (id, nombre, logo) VALUES (1, 'Nike', '/imagenes/marcas/nike.png');
INSERT INTO marcas (id, nombre, logo) VALUES (2, 'Adidas', '/imagenes/marcas/adidas.png');
INSERT INTO marcas (id, nombre, logo) VALUES (3, 'New Balance', NULL);
INSERT INTO marcas (id, nombre, logo) VALUES (4, 'Puma', NULL);
INSERT INTO marcas (id, nombre, logo) VALUES (5, 'Asics', NULL);
-- Marca sin productos 
INSERT INTO marcas (id, nombre, logo) VALUES (6, 'Reebok', NULL);

-- CATEGORIAS 
INSERT INTO categorias (id, nombre, descripcion, imagen) VALUES (1, 'Zapatillas running', 'Modelos diseñados para correr y entrenar en asfalto, tierra o montaña. Amortiguación y soporte para largas distancias.', 'running.jpg');
INSERT INTO categorias (id, nombre, descripcion, imagen) VALUES (2, 'Zapatillas urbanas', 'Modelos casuales perfectos para el uso diario en la ciudad. Comodidad y estilo combinados en cada paso.', 'urbanas.jpg');
INSERT INTO categorias (id, nombre, descripcion, imagen) VALUES (3, 'Botas deportivas', 'Botas resistentes para exterior y temporadas frías. Impermeables y con suela de agarre reforzada.', 'botas.jpg');
INSERT INTO categorias (id, nombre, descripcion, imagen) VALUES (4, 'Ofertas', 'Productos rebajados y promociones especiales. No te pierdas las mejores oportunidades de la temporada.', 'ofertas.jpg');
-- Categoria sin productos (actividad 7 requisito)
INSERT INTO categorias (id, nombre, descripcion, imagen) VALUES (5, 'Accesorios', 'Calcetines, plantillas y complementos para completar tu equipación deportiva.', NULL);

-- PRODUCTOS 

-- Nike Running
INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (1, '8410511234560', 'Nike Air Zoom Pegasus 41',
'El Nike Air Zoom Pegasus 41 es la zapatilla de running más versátil de Nike. Ideal para rodajes largos y entrenos diarios, incorpora espuma React de nueva generación que proporciona un retorno de energía excepcional. Su parte superior de malla transpirable mantiene el pie fresco incluso en sesiones exigentes, mientras la suela de goma duradera garantiza tracción en todo tipo de superficies. Disponible en múltiples colorways.',
'/imagenes/productos/nike-pegasus-41.jpg', 129.99, 0, 1);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (2, '8410511234577', 'Nike React Infinity Run 4',
'Diseñado para reducir el riesgo de lesiones, el Nike React Infinity Run 4 ofrece mayor superficie de contacto con el suelo y un ajuste en el tobillo que estabiliza el pie en cada zancada. La espuma Nike React proporciona amortiguación duradera y suave. Perfecto para corredores que buscan protección y comodidad en largas distancias.',
'/imagenes/productos/nike-react-infinity.jpg', 149.99, 15, 1);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (3, '8410511234584', 'Nike Air Force 1 07',
'Un icono del calzado urbano desde 1982. El Nike Air Force 1 07 combina cuero premium, amortiguación Air y un diseño clean que combina con todo. Versátil tanto para la calle como para eventos casuales. La suela de goma sellada con el logo Swoosh completa este clásico imperecedero que no pasa de moda.',
'/imagenes/productos/nike-af1.jpg', 109.99, 0, 1);

-- Adidas Running
INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (4, '8410522345671', 'Adidas Ultraboost 24',
'El Adidas Ultraboost 24 redefine el running de alto rendimiento. Su mediasuela Boost ofrece un retorno de energía incomparable, mientras el upper de Primeknit envuelve el pie como un calcetín. Ideal para maratones y rodajes exigentes donde cada gramo de energía cuenta. La suela Continental garantiza agarre incluso en pavimento mojado.',
'/imagenes/productos/adidas-ultraboost.jpg', 179.99, 10, 2);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (5, '8410522345688', 'Adidas Samba OG',
'El Adidas Samba OG es un mito del calzado urbano con décadas de historia. Nació como zapatilla de fútbol sala y hoy es el referente del estilo street. Parte superior de cuero genuino, lengüeta acolchada y suela de goma característica. Un clásico que nunca envejece y que combina con cualquier look casual o deportivo.',
'/imagenes/productos/adidas-samba.jpg', 99.99, 0, 2);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (6, '8410522345695', 'Adidas Terrex Swift R3',
'Las Adidas Terrex Swift R3 están diseñadas para el trail running y el senderismo técnico. Con upper de malla resistente, sistema de ajuste rápido y suela Traxion de alta tracción, afrontan senderos exigentes con total seguridad. La membrana GORE-TEX mantiene el pie seco en condiciones húmedas sin sacrificar la transpirabilidad.',
'/imagenes/productos/adidas-terrex.jpg', 139.99, 20, 2);

-- New Balance
INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (7, '8410533456782', 'New Balance 990v6',
'La New Balance 990v6 es el resultado de décadas de ingeniería en running. Fabricada en EE.UU., incorpora espuma ENCAP para amortiguación y estabilidad óptimas. Su upper de ante y malla ofrece un ajuste preciso y una estética premium que la convierte en objeto de culto entre los amantes del streetwear de calidad.',
'/imagenes/productos/nb-990v6.jpg', 199.99, 0, 3);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (8, '8410533456799', 'New Balance Fresh Foam X 1080v13',
'La New Balance Fresh Foam X 1080v13 es la opción más lujosa para rodajes largos. Su espuma Fresh Foam X de última generación ofrece una amortiguación increíblemente suave y reactiva. El upper de malla Hypoknit se adapta al movimiento del pie, proporcionando un ajuste dinámico. Ideal para corredores que buscan lo mejor en comodidad.',
NULL, 169.99, 5, 3);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (9, '8410533456805', 'New Balance 574',
'La New Balance 574 es una de las zapatillas más vendidas de la historia. Su diseño atemporal, combinación de colores clásicos y comodidad excepcional la convierten en la compañera perfecta para el día a día. La suela ENCAP proporciona soporte y cushioning durante todo el día, sea cual sea la actividad.',
'/imagenes/productos/nb-574.jpg', 89.99, 0, 3);

-- Puma
INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (10, '8410544567893', 'Puma Velocity Nitro 3',
'La Puma Velocity Nitro 3 está diseñada para runners que buscan velocidad sin sacrificar la comodidad. Su espuma NITRO ofrece una amortiguación ligera y reactiva que impulsa cada zancada. El upper de malla ligera maximiza la ventilación, mientras la suela de goma ofrece la tracción necesaria en asfalto y pista.',
NULL, 119.99, 0, 4);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (11, '8410544567909', 'Puma Suede Classic XXI',
'La Puma Suede Classic XXI mantiene viva la herencia de uno de los modelos más icónicos de la historia del deporte. El upper de ante genuino, la suela vulcanizada y el logo Puma en relieve la convierten en un imprescindible del armario urbano. Perfecta para combinar con vaqueros, chándal o cualquier look casual.',
'/imagenes/productos/puma-suede.jpg', 79.99, 25, 4);

-- Asics
INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (12, '8410555678904', 'Asics Gel-Kayano 31',
'La Asics Gel-Kayano 31 es la referencia en zapatillas de running con soporte para la sobrepronación. Su tecnología GEL en talón y antepié absorbe los impactos con eficacia, mientras el sistema DUOMAX proporciona estabilidad en cada zancada. Ideal para corredores con pie plano o que buscan mayor control del movimiento.',
'/imagenes/productos/asics-kayano.jpg', 159.99, 0, 5);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (13, '8410555678911', 'Asics Gel-Nimbus 26',
'La Asics Gel-Nimbus 26 es la zapatilla de máxima amortiguación de Asics. Su espuma FF BLAST+ ECO ofrece una experiencia de carrera notablemente más suave y ligera. El upper de malla transpirable garantiza frescor en sesiones largas. Para corredores neutros que recorren muchos kilómetros a la semana.',
NULL, 149.99, 10, 5);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (14, '8410555678928', 'Asics GT-2000 13',
'La Asics GT-2000 13 combina soporte ligero y amortiguación equilibrada para el corredor que busca una zapatilla fiable para el entrenamiento diario. La tecnología Guidance Line mejora la eficiencia de la zancada, mientras el sistema GEL protege las articulaciones en cada impacto. Una elección sólida para la media distancia.',
'/imagenes/productos/asics-gt2000.jpg', 119.99, 0, 5);

-- Más productos mixtos
INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (15, '8410511234591', 'Nike Free Run 5.0',
'La Nike Free Run 5.0 imita el movimiento natural del pie gracias a su suela flexible y su estructura ligera. Perfecta para runners que buscan una mayor conciencia propioceptiva y un movimiento más natural. El upper de malla ofrece ventilación excepcional para entrenamientos en condiciones cálidas.',
NULL, 99.99, 0, 1);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (16, '8410522345702', 'Adidas Stan Smith',
'El Adidas Stan Smith nació como zapatilla de tenis en los años 70 y se convirtió en uno de los modelos más vendidos de todos los tiempos. Su diseño minimalista, upper de cuero blanco y tres bandas perforadas lo hacen inconfundible. Un básico del armario que combina con absolutamente todo.',
'/imagenes/productos/adidas-stansmith.jpg', 89.99, 0, 2);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (17, '8410533456812', 'New Balance 327',
'La New Balance 327 recupera la estética retro de los años 70 con materiales y amortiguación actualizados. Su upper de ante y malla, suela gruesa y líneas curvadas la convierten en una de las zapatillas más fotografiadas de los últimos años. Perfecta para el streetwear moderno.',
'/imagenes/productos/nb-327.jpg', 99.99, 15, 3);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (18, '8410544567916', 'Puma RS-X Efekt',
'La Puma RS-X Efekt lleva el diseño Chunky al siguiente nivel con su silueta exagerada y colores atrevidos. Su sistema Running System en la suela ofrece amortiguación real mientras la estética lo hace imprescindible en cualquier look bold y moderno. Para quienes no quieren pasar desapercibidos.',
NULL, 109.99, 30, 4);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (19, '8410555678935', 'Asics Gel-Trabuco 12',
'La Asics Gel-Trabuco 12 está diseñada para el trail running más exigente. Con suela de tachuelas pronunciadas, upper resistente a la abrasión y protección en puntera y talón, esta bota supera cualquier terreno. La tecnología GEL absorbe los impactos en bajadas técnicas, protegiendo las rodillas del corredor.',
'/imagenes/productos/asics-trabuco.jpg', 129.99, 0, 5);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (20, '8410511234607', 'Nike Air Max 90',
'El Nike Air Max 90 es uno de los modelos más reconocibles de la historia del calzado. Su icónica unidad Air visible en el talón, el diseño en capas y la estética retro lo convierten en un objeto de culto para coleccionistas y amantes del streetwear. Disponible en decenas de colorways exclusivos.',
'/imagenes/productos/nike-airmax90.jpg', 134.99, 0, 1);

INSERT INTO productos (id, ean, nombre, descripcion, imagen, precio, descuento, marca_id)
VALUES (21, '8410522345719', 'Adidas Forum Low',
'El Adidas Forum Low recupera la estética del baloncesto de los años 80 con un enfoque puramente street. Su upper de cuero, la tira del tobillo y la suela gruesa lo convierten en un ícono de la cultura urbana contemporánea. Colaboraciones con artistas y marcas de lujo lo mantienen siempre en el punto de mira.',
'/imagenes/productos/adidas-forum.jpg', 99.99, 0, 2);

-- RELACIONES PRODUCTO-CATEGORIA 
-- Running: 1,4,7,10,12,13,14,15,19
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (1, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (2, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (4, 1);
-- Producto 7 (New Balance 990v6) sin categoría intencionalmente
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (8, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (10, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (12, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (13, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (14, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (15, 1);

-- Urbanas: 3,5,9,11,16,17,18,20,21
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (3, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (5, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (9, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (11, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (16, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (17, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (20, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (21, 2);

-- Botas: 6,19
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (6, 3);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (19, 3);

-- Ofertas: productos con descuento > 0
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (2, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (4, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (6, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (8, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (11, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (13, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (17, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (18, 4);

-- Productos en varias categorías (running + ofertas ya cubierto arriba)
-- Puma RS-X también en urbanas
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (18, 2);

-- Producto sin categoría: id=7 (NB 990v6) — sin INSERT en producto_categoria
