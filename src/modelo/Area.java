/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.math.BigDecimal;
import java.util.Objects;
/**
 *
 * @author User
 */
public class Area {
    private Integer idArea;
    private String nombre;
    private BigDecimal sueldoBase;

    public Area(Integer idArea, String nombre, BigDecimal sueldoBase) {
        this.idArea = idArea;
        this.nombre = Objects.requireNonNull(nombre, "El nombre del área es obligatorio");
        this.sueldoBase = Objects.requireNonNull(sueldoBase, "El sueldo base es obligatorio");
    }

    public Area(String nombre, BigDecimal sueldoBase) {
        this(null, nombre, sueldoBase);
    }

    public Integer getIdArea() { return idArea; }
    public String getNombre() { return nombre; }
    public BigDecimal getSueldoBase() { return sueldoBase; }
    public void setIdArea(Integer idArea) { this.idArea = idArea; }
    public void setNombre(String nombre) { this.nombre = Objects.requireNonNull(nombre); }
    public void setSueldoBase(BigDecimal sueldoBase) { this.sueldoBase = Objects.requireNonNull(sueldoBase); }

    @Override
    public String toString() { return nombre; }
}

