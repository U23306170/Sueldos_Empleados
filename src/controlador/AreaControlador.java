/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.AreaDAO;
import dao.AreaDAOImpl;
import java.util.List;
import modelo.Area;

/**
 *
 * @author User
 */
public class AreaControlador {

    private final AreaDAO areaDAO;

    public AreaControlador() {
        this(new AreaDAOImpl());
    }

    public AreaControlador(AreaDAO areaDAO) {
        this.areaDAO = areaDAO;
    }

    public List<Area> listar() {
        return areaDAO.listar();
    }
}
