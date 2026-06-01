/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author User
 */
public class CalculadoraPagoImpl implements CalculadoraPago {

    @Override
    public double calcularSueldoBruto(Empleado empleado) {
        return empleado.getHorasTrabajadas() *
               empleado.getTarifaHora();
    }

    @Override
    public double calcularDescuento(Empleado empleado) {
        int faltas = 7 - empleado.getDiasAsistidos();
        return faltas * 10;
    }

    @Override
    public double calcularSueldoNeto(Empleado empleado) {

        return calcularSueldoBruto(empleado)
                + empleado.getBonificacion()
                - calcularDescuento(empleado);
    }
}
