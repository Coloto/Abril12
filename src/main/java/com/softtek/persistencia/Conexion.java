package com.softtek.persistencia;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
@Data
public class Conexion {
    protected Connection conn;

    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/northwind",
                "postgres", "root");
        System.out.println("Exito al conectar con la BBDD");
    }


}
