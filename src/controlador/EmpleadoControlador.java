/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Empleado;
import modelo.EstadisticasAsistencia;
import servicio.EmpleadoService;
import servicio.GestorEmpleados;

/**
 *
 * @author User
 */
public class EmpleadoControlador {

    private final EmpleadoService servicio;

    public EmpleadoControlador() {
        this(GestorEmpleados.getInstancia().getEmpleadoService());
    }

    public EmpleadoControlador(EmpleadoService servicio) {
        this.servicio = servicio;
    }

    public void registrar(Empleado empleado) {
        servicio.registrar(empleado);
    }

    public void actualizar(Empleado empleado) {
        servicio.actualizar(empleado);
    }

    public void eliminar(String dni) {
        servicio.eliminar(dni);
    }

    public Empleado buscarPorDni(String dni) {
        return servicio.buscarPorDni(dni);
    }

    public List<Empleado> listar() {
        return servicio.listar();
    }

    public List<Empleado> listarAsistenciaPerfecta() {
        return servicio.listarAsistenciaPerfecta();
    }

    public int contarAsistenciaPerfecta() {
        return listarAsistenciaPerfecta().size();
    }

    public List<Empleado> listarAsistenciaPerfectaPorArea(Integer idArea) {
        return servicio.listarAsistenciaPerfectaPorArea(idArea);
    }

    public EstadisticasAsistencia obtenerEstadisticasAsistencia() {
        return servicio.calcularEstadisticasAsistencia();
    }
}
