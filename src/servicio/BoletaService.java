/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import modelo.Boleta;
import modelo.Empleado;
/**
 *
 * @author User
 */
public class BoletaService {

    public Boleta generar(Empleado empleado) {
        return new Boleta(empleado);
    }
}
