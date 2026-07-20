/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.math.BigDecimal;
/**
 *
 * @author User
 */
public final class Boleta {
    private final Empleado empleado;
    private final BigDecimal sueldoBase, pagoHoras, asignacionFamiliar, bonificacion, descuento, sueldoNeto;
    public Boleta(Empleado e) {
        empleado = e; sueldoBase = e.getArea().getSueldoBase(); pagoHoras = e.calcularPagoHoras();
        asignacionFamiliar = e.calcularAsignacionFamiliar(); bonificacion = e.getBonificacion();
        descuento = e.calcularDescuento(); sueldoNeto = e.calcularSueldoNeto();
    }
    public Empleado getEmpleado() { return empleado; }
    public BigDecimal getSueldoBase() { return sueldoBase; }
    public BigDecimal getPagoHoras() { return pagoHoras; }
    public BigDecimal getAsignacionFamiliar() { return asignacionFamiliar; }
    public BigDecimal getBonificacion() { return bonificacion; }
    public BigDecimal getDescuento() { return descuento; }
    public BigDecimal getSueldoNeto() { return sueldoNeto; }
}

