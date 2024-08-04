INSERT INTO Category (category_id, category_name) VALUES (1, 'Videogame');
INSERT INTO Category (category_id, category_name) VALUES (2, 'Console');

INSERT INTO State (state_id, state_name) VALUES (1, 'New');
INSERT INTO State (state_id, state_name) VALUES (2, 'Used');

INSERT INTO Products (product_name, product_description, product_price, product_stock, product_image, category_id, state_id) VALUES ('PlayStation 5', 'Consola de videojuegos de última generación', 499.99, 10, 'https://i5.walmartimages.com/seo/Sony-PlayStation-5-Video-Game-Console-Ps5-Disc-Console-Japanese-Edition-New_1536c1c9-0c26-4ce6-a5e1-1825ca064d05.1434e86832a815bb366d12b0a854390d.jpeg', 2, 1);
INSERT INTO Products (product_name, product_description, product_price, product_stock, product_image, category_id, state_id) VALUES ('Xbox Series X', 'Consola de videojuegos de alta potencia', 499.99, 8, 'https://i5.walmartimages.com/asr/9f8c06f5-7953-426d-9b68-ab914839cef4.5f15be430800ce4d7c3bb5694d4ab798.jpeg', 2, 1);
INSERT INTO Products (product_name, product_description, product_price, product_stock, product_image, category_id, state_id) VALUES ('Nintendo Switch', 'Consola de videojuegos híbrida', 299.99, 15, 'https://mobilestore.ec/wp-content/uploads/2021/11/Nintendo-Switch-Oled-Azul-y-Rojo-Mobile-Store-Ecuador.jpg', 2, 1);
INSERT INTO Products (product_name, product_description, product_price, product_stock, product_image, category_id, state_id) VALUES ('The Last of Us Part II', 'Videojuego de acción y aventura', 59.99, 20, 'https://image.api.playstation.com/vulcan/ap/rnd/202312/0117/315718bce7eed62e3cf3fb02d61b81ff1782d6b6cf850fa4.png', 1, 1);
INSERT INTO Products (product_name, product_description, product_price, product_stock, product_image, category_id, state_id) VALUES ('Cyberpunk 2077', 'Videojuego de rol y acción', 49.99, 25, 'https://image.api.playstation.com/vulcan/ap/rnd/202311/2812/ae84720b553c4ce943e9c342621b60f198beda0dbf533e21.jpg', 1, 2);
