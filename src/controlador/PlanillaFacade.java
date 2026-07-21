package controlador;

import java.util.List;
import modelo.Area;
import modelo.Empleado;
import modelo.EstadisticasAsistencia;
import servicio.BoletaService;

/**
 * Facade pattern implementation for the Sueldos Empleados subsystem controllers.
 * This class provides a simplified, unified interface for the Swing views,
 * hiding the complexity of EmpleadoControlador, AreaControlador, and BoletaControlador.
 */
public class PlanillaFacade {

    private final EmpleadoControlador empleadoControlador;
    private final AreaControlador areaControlador;
    private final BoletaControlador boletaControlador;

    /**
     * Default constructor initializing all sub-controllers with default implementations.
     */
    public PlanillaFacade() {
        this.empleadoControlador = new EmpleadoControlador();
        this.areaControlador = new AreaControlador();
        this.boletaControlador = new BoletaControlador(this.empleadoControlador, new BoletaService());
    }

    /*Parameterized constructor for custom dependency injection (e.g., testing).
     * @param empleadoControlador custom EmpleadoControlador
     * @param areaControlador     custom AreaControlador
     * @param boletaControlador   custom BoletaControlador
     */
    public PlanillaFacade(EmpleadoControlador empleadoControlador, AreaControlador areaControlador, BoletaControlador boletaControlador) {
        this.empleadoControlador = empleadoControlador;
        this.areaControlador = areaControlador;
        this.boletaControlador = boletaControlador;
    }
    // --- Empleado Operaciones ---
    public void registrarEmpleado(Empleado empleado) {empleadoControlador.registrar(empleado);}
    
    public void actualizarEmpleado(Empleado empleado) {  empleadoControlador.actualizar(empleado); }

    public void eliminarEmpleado(String dni) {empleadoControlador.eliminar(dni); }

    public Empleado buscarEmpleadoPorDni(String dni) {return empleadoControlador.buscarPorDni(dni);}

    public List<Empleado> listarEmpleados() {return empleadoControlador.listar();}

    public List<Empleado> listarAsistenciaPerfecta() {return empleadoControlador.listarAsistenciaPerfecta();}

    public int contarAsistenciaPerfecta() { return empleadoControlador.contarAsistenciaPerfecta();}

    public List<Empleado> listarAsistenciaPerfectaPorArea(Integer idArea) {return empleadoControlador.listarAsistenciaPerfectaPorArea(idArea);}

    public EstadisticasAsistencia obtenerEstadisticasAsistencia() {return empleadoControlador.obtenerEstadisticasAsistencia();}

    // --- Area Operations ---
    public List<Area> listarAreas() { return areaControlador.listar();}
    
    // --- Boleta Operations ---
    public String generarBoletaTexto(String dni, String tipoReporte) { return boletaControlador.generarTexto(dni, tipoReporte);}
    
    public String generarBoletaTexto(Empleado empleado, String tipoReporte) {return boletaControlador.generarTexto(empleado, tipoReporte);}
}
