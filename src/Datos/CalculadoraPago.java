/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

/**
 *
 * @author User
 */
public interface CalculadoraPago {

    double calcularSueldoBruto(Empleado empleado);

    double calcularDescuento(Empleado empleado);

    double calcularSueldoNeto(Empleado empleado);
}
