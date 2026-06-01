/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author User
 */
public class EmpleadoService implements IEmpleadoService {

    private static EmpleadoService instancia;
    
    private Empleado[] empleados;
    private int contador;

    public EmpleadoService(int capacidad) {
        empleados = new Empleado[capacidad];
        contador = 0;
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {

        if (contador < empleados.length) {
            empleados[contador] = empleado;
            contador++;
        }
    }

    @Override
    public Empleado buscarPorDni(String dni) {

        for (int i = 0; i < contador; i++) {

            if (empleados[i].getDni().equals(dni)) {
                return empleados[i];
            }
        }

        return null;
    }

    @Override
    public void listarEmpleados() {

        for (int i = 0; i < contador; i++) {

            System.out.println(
                    empleados[i].getNombre()
                    + " - "
                    + empleados[i].getDni());
        }
    }

    @Override
    public int contarAsistenciaPerfecta() {
        int cantidad = 0;
        for (int i = 0; i < contador; i++) {
            if (empleados[i].getDiasAsistidos() == 7) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public String obtenerAsistenciaPerfecta() {

        String resultado = "";

        for (int i = 0; i < contador; i++) {

            if (empleados[i].getDiasAsistidos() == 7) {
                resultado+= empleados[i].getNombre()+ " - DNI: "+ empleados[i].getDni()+ "\n";
            }
        }

        return resultado;
    }

    public String listarTrabajadores() {

        String lista = "";

        for (int i = 0; i < contador; i++) {

            lista+= (i + 1) + ". "+ empleados[i].getNombre() + " - DNI: "+ empleados[i].getDni()+ "\n";
        }

        return lista;
    }

    public int getContador() {
        return contador;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }
}
