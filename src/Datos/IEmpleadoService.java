/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos;

/**
 *
 * @author User
 */
public interface IEmpleadoService {
    public void agregarEmpleado(Empleado empleado);

    Empleado buscarPorDni(String dni);

    public void listarEmpleados();

    int contarAsistenciaPerfecta();
}
