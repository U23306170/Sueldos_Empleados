/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Area;
import modelo.Empleado;
import modelo.ConstantesPlanilla;

/**
 *
 * @author User
 */
public class EmpleadoDAOImpl implements EmpleadoDAO {

    private static final String CAMPOS = "e.dni,e.nombre AS nombreEmpleado,e.horasTrabajadas,e.tarifaHora,e.bonificacion,e.diasAsistidos,e.numeroHijos,a.idArea,a.nombre AS nombreArea,a.sueldoBase ";

    @Override
    public void guardar(Empleado e) {
        String sql = "INSERT INTO Empleado (dni,nombre,horasTrabajadas,tarifaHora,bonificacion,diasAsistidos,numeroHijos,idArea) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection c = ConexionSQL.conectar(); PreparedStatement p = c.prepareStatement(sql)) {
            asignar(p, e);
            p.executeUpdate();
        } catch (SQLException ex) {
            throw new IllegalStateException("No se pudo registrar el empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void actualizar(Empleado e) {
        String sql = "UPDATE Empleado SET nombre=?,horasTrabajadas=?,tarifaHora=?,bonificacion=?,diasAsistidos=?,numeroHijos=?,idArea=? WHERE dni=?";
        try (Connection c = ConexionSQL.conectar(); PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, e.getNombre());
            p.setInt(2, e.getHorasTrabajadas());
            p.setBigDecimal(3, e.getTarifaHora());
            p.setBigDecimal(4, e.getBonificacion());
            p.setInt(5, e.getDiasAsistidos());
            p.setInt(6, e.getNumeroHijos());
            p.setInt(7, e.getArea().getIdArea());
            p.setString(8, e.getDni());
            if (p.executeUpdate() == 0) {
                throw new IllegalArgumentException("No existe el empleado con DNI " + e.getDni());
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("No se pudo actualizar el empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void eliminar(String dni) {
        try (Connection c = ConexionSQL.conectar(); PreparedStatement p = c.prepareStatement("DELETE FROM Empleado WHERE dni=?")) {
            p.setString(1, dni);
            if (p.executeUpdate() == 0) {
                throw new IllegalArgumentException("No existe el empleado con DNI " + dni);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("No se pudo eliminar el empleado: " + ex.getMessage(), ex);
        }
    }

    @Override
    public Empleado buscarPorDni(String dni) {
        return consultar(" WHERE e.dni=?", dni).stream().findFirst().orElse(null);
    }

    @Override
    public List<Empleado> listar() {
        return consultar(" ORDER BY e.nombre", null);
    }

    @Override
    public List<Empleado> listarConAsistenciaPerfecta() {
        return consultar(" WHERE e.diasAsistidos=" + ConstantesPlanilla.DIAS_MES + " ORDER BY e.nombre", null);
    }

    private List<Empleado> consultar(String condicion, String dni) {
        String sql = "SELECT " + CAMPOS + "FROM Empleado e INNER JOIN Area a ON a.idArea=e.idArea" + condicion;
        List<Empleado> r = new ArrayList<>();
        try (Connection c = ConexionSQL.conectar(); PreparedStatement p = c.prepareStatement(sql)) {
            if (dni != null) {
                p.setString(1, dni);
            }
            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {
                    r.add(mapear(rs));
                }
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("No se pudieron obtener empleados: " + ex.getMessage(), ex);
        }
        return r;
    }

    private void asignar(PreparedStatement p, Empleado e) throws SQLException {
        p.setString(1, e.getDni());
        p.setString(2, e.getNombre());
        p.setInt(3, e.getHorasTrabajadas());
        p.setBigDecimal(4, e.getTarifaHora());
        p.setBigDecimal(5, e.getBonificacion());
        p.setInt(6, e.getDiasAsistidos());
        p.setInt(7, e.getNumeroHijos());
        p.setInt(8, e.getArea().getIdArea());
    }

    private Empleado mapear(ResultSet r) throws SQLException {
        Area a = new Area(r.getInt("idArea"), r.getString("nombreArea"), r.getBigDecimal("sueldoBase"));
        return new Empleado.Builder().dni(r.getString("dni")).nombre(r.getString("nombreEmpleado")).horasTrabajadas(r.getInt("horasTrabajadas")).tarifaHora(r.getBigDecimal("tarifaHora")).bonificacion(r.getBigDecimal("bonificacion")).diasAsistidos(r.getInt("diasAsistidos")).numeroHijos(r.getInt("numeroHijos")).area(a).build();
    }
}
