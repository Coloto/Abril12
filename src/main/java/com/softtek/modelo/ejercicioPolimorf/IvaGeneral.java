package com.softtek.modelo.ejercicioPolimorf;

public class IvaGeneral implements Impuesto{
    @Override
    public double calcularImpuesto(Producto p1) {
        return p1.getPrecio()*1.21;
    }
}
