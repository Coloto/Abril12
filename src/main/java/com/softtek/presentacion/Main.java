package com.softtek.presentacion;

import com.softtek.modelo.Detalle;
import com.softtek.persistencia.AccesoDetalle;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccesoDetalle accesoDetalle = new AccesoDetalle();
        //System.out.println(accesoDetalle.allDetalles());

        //ejercicio1(accesoDetalle.allDetalles());
        //ejercicio2(accesoDetalle.allDetalles());
        //ejercicio3(accesoDetalle.allDetalles());
        //ejercicio4(accesoDetalle.allDetalles());
        ejercicio5(accesoDetalle.allDetalles());
    }

    public static void ejercicio1(List<Detalle> listaDetalles) {
        Predicate<Detalle> mayorQue30 = x -> x.getUnit_price()>30;
        listaDetalles.stream()
                .filter(mayorQue30)
                .forEach(System.out::println);
    }

    public static void ejercicio2(List<Detalle> listaDetalles) {
        listaDetalles.stream()
                .sorted(Comparator.comparing(Detalle::getUnit_price))
                .forEach(System.out::println);
    }

    public static void ejercicio3(List<Detalle> listaDetalles) {
        double min = listaDetalles.stream()
                .mapToDouble(Detalle::total)
                .min()
                .orElse(0);
        System.out.println(min);
    }

    public static void ejercicio4(List<Detalle> listaDetalles) {
        //Obtener las estadísticas de detalle de ordenes sobre el atributo quantity
        IntSummaryStatistics estadisticas = listaDetalles.stream()
                .mapToInt(Detalle::getQuantity)
                .summaryStatistics();
        System.out.println(estadisticas);
    }

    public static void ejercicio5(List<Detalle> listaDetalles) {
        Map<Integer, Integer> cantidadProductos = listaDetalles.stream()
                .collect(groupingBy(Detalle::getProduct_id, summingInt(Detalle::getQuantity)));
        System.out.println(cantidadProductos);
    }
}
