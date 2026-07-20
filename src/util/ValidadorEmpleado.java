/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.math.BigDecimal;
/**
 *
 * @author User
 */
public final class ValidadorEmpleado {

    private ValidadorEmpleado() {
    }

    public static String dni(String valor) {
        if (valor == null || !valor.trim().matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe contener exactamente 8 dígitos.");
        }
        return valor.trim();
    }

    public static String textoObligatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingrese " + campo + ".");
        }
        return valor.trim();
    }

    public static int enteroNoNegativo(String valor, String campo) {
        try {
            int numero = Integer.parseInt(valor.trim());
            if (numero < 0) {
                throw new NumberFormatException();
            }
            return numero;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(campo + " debe ser un número entero no negativo.");
        }
    }

    public static BigDecimal montoNoNegativo(String valor, String campo) {
        try {
            BigDecimal monto = new BigDecimal(valor.trim());
            if (monto.signum() < 0) {
                throw new NumberFormatException();
            }
            return monto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(campo + " debe ser un monto no negativo.");
        }
    }
}
