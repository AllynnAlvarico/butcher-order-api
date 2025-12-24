CREATE TABLE Orders_Items (
	order_item_id INT AUTO_INCREMENT PRIMARY KEY,
	order_id INT NOT NULL,
    product_id INT NOT NULL,
    weight_kg DECIMAL(6,3),
    total_price DECIMAL(8,2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);