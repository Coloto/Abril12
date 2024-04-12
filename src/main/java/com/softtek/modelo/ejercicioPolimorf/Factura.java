package com.softtek.modelo.ejercicioPolimorf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Factura {
    private Impuesto impuesto;
    private List<Producto> productos;

    public Factura(List<Producto> productos) {
        this.productos = productos;
    }

    public double calcularTotalFactura(){
        double total = productos.stream()
                .mapToDouble(producto -> producto.getPrecio() + impuesto.calcularImpuesto(producto)).sum();
        return total;
    }
}
