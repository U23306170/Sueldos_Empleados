package controlador;
import factory.ReporteBoleta;
import factory.ReporteBoletaFactory;
import modelo.Boleta;
import modelo.Empleado;
import servicio.BoletaService;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class BoletaControlador {

    private final EmpleadoControlador empleadoControlador;
    private final BoletaService boletaService;

    public BoletaControlador() {
        this(new EmpleadoControlador(), new BoletaService());
    }

    public BoletaControlador(EmpleadoControlador c, BoletaService s) {
        empleadoControlador = c;
        boletaService = s;
    }

    public String generarTexto(String dni, String tipoReporte) {
        Empleado empleado = empleadoControlador.buscarPorDni(dni);
        if (empleado == null) {
            throw new IllegalArgumentException("No se encontró un empleado con DNI " + dni);
        }
        return generarTexto(empleado, tipoReporte);
    }

    public String generarTexto(Empleado empleado, String tipoReporte) {
        Boleta boleta = boletaService.generar(empleado);
        ReporteBoleta reporte = ReporteBoletaFactory.crear(tipoReporte);
        return reporte.generar(boleta);
    }
}
