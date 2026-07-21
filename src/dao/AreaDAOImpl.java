/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Area;
import java.sql.*;
import java.util.*;

/**
 *
 * @author User
 */
public class AreaDAOImpl implements AreaDAO {

    @Override
    public List<Area> listar() {
        List<Area> areas = new ArrayList<>();
        try (Connection c = ConexionSQL.conectar(); PreparedStatement p = c.prepareStatement("SELECT idArea,nombre,sueldoBase FROM Area ORDER BY nombre"); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                areas.add(mapear(r));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudieron obtener las áreas: " + e.getMessage(), e);
        }
        return areas;
    }

    @Override
    public Area buscarPorId(int id) {
        try (Connection c = ConexionSQL.conectar(); PreparedStatement p = c.prepareStatement("SELECT idArea,nombre,sueldoBase FROM Area WHERE idArea=?")) {
            p.setInt(1, id);
            try (ResultSet r = p.executeQuery()) {
                return r.next() ? mapear(r) : null;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("No se pudo obtener el área: " + e.getMessage(), e);
        }
    }

    private Area mapear(ResultSet r) throws SQLException {
        return new Area(r.getInt("idArea"), r.getString("nombre"), r.getBigDecimal("sueldoBase"));
    }
}
