/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import dao.EmpleadoDAOImpl;
/**
 *
 * @author User
 */
public final class GestorEmpleados {
    private static GestorEmpleados instancia;
    private final EmpleadoService empleadoService;
    private GestorEmpleados() { empleadoService = new EmpleadoService(new EmpleadoDAOImpl()); }
    public static synchronized GestorEmpleados getInstancia() { if (instancia == null) instancia = new GestorEmpleados(); return instancia; }
    public EmpleadoService getEmpleadoService() { return empleadoService; }
}
