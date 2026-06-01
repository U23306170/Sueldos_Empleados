/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConexionSQL {
    private static final String URL = "jdbc:mysql://localhost:3306/consultorio";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "76529543Alexi$";

    // Método para obtener la conexión
    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("✅ Conexión establecida.");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}
