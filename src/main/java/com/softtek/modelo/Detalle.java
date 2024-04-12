package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detalle {
    private int order_id;
    private int product_id;
    private double unit_price;
    private int quantity;
    private double discount;

    public double total() {
        return unit_price*quantity;
    }

    @Override
    public String toString() {
        return "\nDetalle{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", unit_price=" + unit_price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
