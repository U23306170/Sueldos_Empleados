/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dao.EmpleadoDAO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import modelo.Empleado;
import modelo.EstadisticasAsistencia;

/**
 *
 * @author User
 *
 * /** Reglas de negocio de empleados; depende de la abstracción DAO, no de
 * Swing.
 */
public class EmpleadoService {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoService(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public void registrar(Empleado e) {
        if (buscarPorDni(e.getDni()) != null) {
            throw new IllegalArgumentException("Ya existe un empleado con ese DNI");
        }
        empleadoDAO.guardar(e);
    }

    public void actualizar(Empleado e) {
        empleadoDAO.actualizar(e);
    }

    public void eliminar(String dni) {
        empleadoDAO.eliminar(dni);
    }

    public Empleado buscarPorDni(String dni) {
        return empleadoDAO.buscarPorDni(dni);
    }

    public List<Empleado> listar() {
        return empleadoDAO.listar();
    }

    public List<Empleado> listarAsistenciaPerfecta() {
        return empleadoDAO.listarConAsistenciaPerfecta();
    }

    public List<Empleado> listarAsistenciaPerfectaPorArea(Integer idArea) {
        if (idArea == null) return listarAsistenciaPerfecta();
        return listarAsistenciaPerfecta().stream()
                .filter(empleado -> idArea.equals(empleado.getArea().getIdArea()))
                .collect(Collectors.toList());
    }

    /** Calcula indicadores de toda la planilla, sin depender de Swing. */
    public EstadisticasAsistencia calcularEstadisticasAsistencia() {
        List<Empleado> empleados = listar();
        if (empleados.isEmpty()) return new EstadisticasAsistencia(0, "Sin datos", BigDecimal.ZERO, BigDecimal.ZERO);

        List<Empleado> perfectos = listarAsistenciaPerfecta();
        String areaMasCumplida = perfectos.stream()
                .collect(Collectors.groupingBy(e -> e.getArea().getNombre(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Sin asistencia perfecta");
        BigDecimal cantidad = BigDecimal.valueOf(empleados.size());
        BigDecimal promedioDias = empleados.stream().map(e -> BigDecimal.valueOf(e.getDiasAsistidos())).reduce(BigDecimal.ZERO, BigDecimal::add).divide(cantidad, 2, RoundingMode.HALF_UP);
        BigDecimal promedioSueldo = empleados.stream().map(Empleado::calcularSueldoNeto).reduce(BigDecimal.ZERO, BigDecimal::add).divide(cantidad, 2, RoundingMode.HALF_UP);
        return new EstadisticasAsistencia(perfectos.size(), areaMasCumplida, promedioDias, promedioSueldo);
    }
}

