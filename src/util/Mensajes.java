/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public final class Mensajes {

    private Mensajes() {
    }

    public static void informacion(Component padre, String texto) {
        JOptionPane.showMessageDialog(padre, texto, "Sistema de boletas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(Component padre, String texto) {
        JOptionPane.showMessageDialog(padre, texto, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void advertencia(Component padre,String texto) {
        JOptionPane.showMessageDialog(padre,texto,"Advertencia",JOptionPane.WARNING_MESSAGE
        );
    }

    public static boolean confirmarEliminacion(Component padre) {
        return JOptionPane.showConfirmDialog(padre, "¿Desea eliminar el empleado seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION;
    }
}
