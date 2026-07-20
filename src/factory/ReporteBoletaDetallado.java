/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;
import java.text.NumberFormat;
import java.util.Locale;
import modelo.Boleta;
/**
 *
 * @author User
 */
public class ReporteBoletaDetallado implements ReporteBoleta {

    private final NumberFormat moneda = NumberFormat.getCurrencyInstance(new Locale("es", "PE"));

    @Override
    public String generar(Boleta b) {
        return "BOLETA DE PAGO\n\nEmpleado: " + b.getEmpleado().getNombre() + "\nDNI: " + b.getEmpleado().getDni() + "\nÁrea: " + b.getEmpleado().getArea().getNombre() + "\n\nSueldo Base: " + moneda.format(b.getSueldoBase()) + "\nHoras Extra: " + moneda.format(b.getPagoHoras()) + "\nAsignación Familiar: " + moneda.format(b.getAsignacionFamiliar()) + "\nBonificación: " + moneda.format(b.getBonificacion()) + "\nDescuento: -" + moneda.format(b.getDescuento()) + "\n\nSUELDO NETO: " + moneda.format(b.getSueldoNeto());
    }
}
