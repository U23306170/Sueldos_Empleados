/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author User
 */
public final class ReporteBoletaFactory {

    private ReporteBoletaFactory() {
    }

    public static ReporteBoleta crear(String tipo) {
        return "Resumen".equalsIgnoreCase(tipo) ? new ReporteBoletaResumen() : new ReporteBoletaDetallado();
    }
}
