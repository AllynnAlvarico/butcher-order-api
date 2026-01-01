package com.zpulse.orderapi.dto;

import com.zpulse.orderapi.model.Order;
import com.zpulse.orderapi.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO {

    private int order_id;
    private int product_id;
    private Double weight_kg;
    private Double total_price;
}
