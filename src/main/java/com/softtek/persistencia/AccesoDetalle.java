package com.softtek.persistencia;

import com.softtek.modelo.Detalle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoDetalle extends Conexion{
    public Statement sentencia;
    public ResultSet rs;

    public List<Detalle> allDetalles() throws SQLException, ClassNotFoundException {
        conectar();
        String sql = "SELECT * FROM order_details;";
        List<Detalle> detalles = new ArrayList<>();
        sentencia = conn.createStatement();
        rs = sentencia.executeQuery(sql);
        while(rs.next()){
            detalles.add(new Detalle(rs.getInt("order_id"),
                    rs.getInt("product_id"),
                    rs.getInt("unit_price"),
                    rs.getInt("quantity"),
                    rs.getInt("discount")));
        }
        return detalles;
    }
}
