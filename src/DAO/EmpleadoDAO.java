/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionSQL;
import Datos.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public class EmpleadoDAO {
    public void agregar(Empleado emp) {

        String sql =
                "INSERT INTO Empleado "
                + "(dni, nombre, horasTrabajadas, "
                + "tarifaHora, bonificacion, diasAsistidos) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn =
                ConexionSQL.conectar();

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, emp.getDni());

            ps.setString(2, emp.getNombre());

            ps.setInt(3,
                    emp.getHorasTrabajadas());

            ps.setDouble(4,
                    emp.getTarifaHora());

            ps.setDouble(5,
                    emp.getBonificacion());

            ps.setInt(6,
                    emp.getDiasAsistidos());

            ps.executeUpdate();

            System.out.println(
                    " Empleado registrado"
            );

        } catch (SQLException e) {

            System.out.println(
                    " Error al registrar: "
                    + e.getMessage()
            );
        }
    }
}
