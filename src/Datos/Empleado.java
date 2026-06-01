package Datos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Empleado {

    private String nombre;
    private String dni;
    private int horasTrabajadas;
    private double tarifaHora;
    private double bonificacion;
    private int diasAsistidos;

    public Empleado(String nombre, String dni, int horasTrabajadas,double tarifaHora, double bonificacion,int diasAsistidos) {

        this.nombre = nombre;
        this.dni = dni;
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
        this.bonificacion = bonificacion;
        this.diasAsistidos = diasAsistidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public int getDiasAsistidos() {
        return diasAsistidos;
    }
}