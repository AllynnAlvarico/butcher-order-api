package com.zpulse.orderapi.dto;

import com.zpulse.orderapi.model.Order;
import com.zpulse.orderapi.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing an Order.
 * @Description:
 * @- Maps to the "Orders" table in the database.
 * @- Contains fields for order details such as customer ID, order status, total price, creation date, and update date.
 * @Purpose:
 * @- To define the Order entity and its mapping to the database table.
 * @Variables:
 * @-orderItem: Is an object variable that accept OrderItem object
 * @-order: It is an object variable that accept Order object
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdateOn
 * @Date: 29/12/2025
 * @By: Anson Ling Guang Cheng
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDTO {
    private Order order;
    private OrderItemDTO orderItemDTO;
}
