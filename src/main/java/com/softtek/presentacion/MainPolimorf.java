package com.softtek.presentacion;

import com.softtek.modelo.ejercicioPolimorf.Factura;
import com.softtek.modelo.ejercicioPolimorf.IvaGeneral;
import com.softtek.modelo.ejercicioPolimorf.IvaSuperReducido;
import com.softtek.modelo.ejercicioPolimorf.Producto;

import java.util.ArrayList;

public class MainPolimorf {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto 1", 10.5));
        productos.add(new Producto("Producto 2", 20.0));
        productos.add(new Producto("Producto 3", 15.75));

        Factura factura1 = new Factura(new IvaGeneral(), productos);
        System.out.println(factura1.calcularTotalFactura());

        Factura factura2 = new Factura(new IvaSuperReducido(), productos);
        System.out.println(factura2.calcularTotalFactura());
    }
}
