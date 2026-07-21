package modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Empleado {

    private String dni;
    private String nombre;
    private int horasTrabajadas;
    private BigDecimal tarifaHora;
    private BigDecimal bonificacion;
    private int diasAsistidos;
    private int numeroHijos;
    private Area area;

    private Empleado(Builder b) {
        this.dni = b.dni;
        this.nombre = b.nombre;
        this.horasTrabajadas = b.horasTrabajadas;
        this.tarifaHora = b.tarifaHora;
        this.bonificacion = b.bonificacion;
        this.diasAsistidos = b.diasAsistidos;
        this.numeroHijos = b.numeroHijos;
        this.area = b.area;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }

    public BigDecimal getBonificacion() {
        return bonificacion;
    }

    public int getDiasAsistidos() {
        return diasAsistidos;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public Area getArea() {
        return area;
    }

    public void setNombre(String nombre) {
        this.nombre = validarNombre(nombre);
    }

    public void setHorasTrabajadas(int horas) {
        this.horasTrabajadas = validarNoNegativo(horas, "Las horas");
    }

    public void setTarifaHora(BigDecimal tarifa) {
        this.tarifaHora = validarMonto(tarifa, "La tarifa");
    }

    public void setBonificacion(BigDecimal bono) {
        this.bonificacion = validarMonto(bono, "La bonificación");
    }

    public void setDiasAsistidos(int dias) {
        if (dias < 0 || dias > ConstantesPlanilla.DIAS_MES) {
            throw new IllegalArgumentException("Los días asistidos deben estar entre 0 y 30");
        }
        this.diasAsistidos = dias;
    }

    public void setNumeroHijos(int hijos) {
        this.numeroHijos = validarNoNegativo(hijos, "El número de hijos");
    }

    public void setArea(Area area) {
        this.area = Objects.requireNonNull(area, "El área es obligatoria");
    }

    public BigDecimal calcularPagoHoras() {
        return tarifaHora.multiply(BigDecimal.valueOf(horasTrabajadas));
    }

    public BigDecimal calcularAsignacionFamiliar() {
        return ConstantesPlanilla.ASIGNACION_POR_HIJO.multiply(BigDecimal.valueOf(Math.min(numeroHijos, ConstantesPlanilla.MAX_HIJOS_BENEFICIO)));
    }

    public BigDecimal calcularDescuento() {
        return ConstantesPlanilla.DESCUENTO_POR_FALTA.multiply(BigDecimal.valueOf(ConstantesPlanilla.DIAS_MES - diasAsistidos));
    }

    public BigDecimal calcularSueldoNeto() {
        return area.getSueldoBase().add(calcularPagoHoras()).add(calcularAsignacionFamiliar()).add(bonificacion).subtract(calcularDescuento()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return dni + " - " + nombre;
    }

    private static String validarNombre(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        return valor.trim();
    }

    private static int validarNoNegativo(int valor, String campo) {
        if (valor < 0) {
            throw new IllegalArgumentException(campo + " no puede ser negativo");
        }
        return valor;
    }

    private static BigDecimal validarMonto(BigDecimal valor, String campo) {
        if (valor == null || valor.signum() < 0) {
            throw new IllegalArgumentException(campo + " no puede ser negativo");
        }
        return valor.setScale(2, RoundingMode.HALF_UP);
    }

    public static class Builder {

        private String dni, nombre;
        private int horasTrabajadas, diasAsistidos = ConstantesPlanilla.DIAS_MES, numeroHijos;
        private BigDecimal tarifaHora = BigDecimal.ZERO, bonificacion = BigDecimal.ZERO;
        private Area area;

        public Builder dni(String v) {
            if (v == null || !v.matches("\\d{8}")) {
                throw new IllegalArgumentException("El DNI debe tener 8 dígitos");
            }
            dni = v;
            return this;
        }

        public Builder nombre(String v) {
            nombre = validarNombre(v);
            return this;
        }

        public Builder horasTrabajadas(int v) {
            horasTrabajadas = validarNoNegativo(v, "Las horas");
            return this;
        }

        public Builder tarifaHora(BigDecimal v) {
            tarifaHora = validarMonto(v, "La tarifa");
            return this;
        }

        public Builder bonificacion(BigDecimal v) {
            bonificacion = validarMonto(v, "La bonificación");
            return this;
        }

        public Builder diasAsistidos(int v) {
            if (v < 0 || v > ConstantesPlanilla.DIAS_MES) {
                throw new IllegalArgumentException("Los días asistidos deben estar entre 0 y 30");
            }
            diasAsistidos = v;
            return this;
        }

        public Builder numeroHijos(int v) {
            numeroHijos = validarNoNegativo(v, "El número de hijos");
            return this;
        }

        public Builder area(Area v) {
            area = Objects.requireNonNull(v, "El área es obligatoria");
            return this;
        }

        public Empleado build() {
            if (dni == null || nombre == null || area == null) {
                throw new IllegalStateException("DNI, nombre y área son obligatorios");
            }
            return new Empleado(this);
        }
    }
}
