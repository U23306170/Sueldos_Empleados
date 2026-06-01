/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author User
 */
public class BoletaService implements IBoleta {

    private CalculadoraPago calculadora;

    public BoletaService(CalculadoraPago calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public void mostrarBoleta(Empleado empleado) {

        System.out.println("\n===== BOLETA =====");

        System.out.println("Nombre: " +
                empleado.getNombre());

        System.out.println("DNI: " +
                empleado.getDni());

        System.out.println("Sueldo Bruto: S/ " +
                calculadora.calcularSueldoBruto(empleado));

        System.out.println("Descuento: S/ " +
                calculadora.calcularDescuento(empleado));

        System.out.println("Sueldo Neto: S/ " +
                calculadora.calcularSueldoNeto(empleado));
    }
}
