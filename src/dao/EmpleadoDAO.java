/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Empleado;

/**
 *
 * @author User
 */
public interface EmpleadoDAO {

    void guardar(Empleado empleado);

    void actualizar(Empleado empleado);

    void eliminar(String dni);

    Empleado buscarPorDni(String dni);

    List<Empleado> listar();

    List<Empleado> listarConAsistenciaPerfecta();
}
