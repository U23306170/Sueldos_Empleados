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
public class ReporteBoletaResumen implements ReporteBoleta {

    @Override
    public String generar(Boleta b) {
        return "RESUMEN DE BOLETA\nEmpleado: " + b.getEmpleado().getNombre() + "\nÁrea: " + b.getEmpleado().getArea().getNombre() + "\nNeto: " + NumberFormat.getCurrencyInstance(new Locale("es", "PE")).format(b.getSueldoNeto());
    }
}
