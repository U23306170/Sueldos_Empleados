/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.EmpleadoDAO;
import java.util.List;
import modelo.Empleado;
/**
 *
 * @author User
 *
/** Reglas de negocio de empleados; depende de la abstracción DAO, no de Swing. */
public class EmpleadoService {
    private final EmpleadoDAO empleadoDAO;
    public EmpleadoService(EmpleadoDAO empleadoDAO) { this.empleadoDAO = empleadoDAO; }
    public void registrar(Empleado e) { if(buscarPorDni(e.getDni()) != null) throw new IllegalArgumentException("Ya existe un empleado con ese DNI"); empleadoDAO.guardar(e); }
    public void actualizar(Empleado e) { empleadoDAO.actualizar(e); }
    public void eliminar(String dni) { empleadoDAO.eliminar(dni); }
    public Empleado buscarPorDni(String dni) { return empleadoDAO.buscarPorDni(dni); }
    public List<Empleado> listar() { return empleadoDAO.listar(); }
    public List<Empleado> listarAsistenciaPerfecta() { return empleadoDAO.listarConAsistenciaPerfecta(); }
}
