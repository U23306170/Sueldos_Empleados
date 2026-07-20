/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.math.BigDecimal;
/**
 *
 * @author User
 */
public final class EstadisticasAsistencia {
    private final int totalPerfectos;
    private final String areaMasCumplida;
    private final BigDecimal promedioDias;
    private final BigDecimal promedioSueldo;

    public EstadisticasAsistencia(int totalPerfectos, String areaMasCumplida, BigDecimal promedioDias, BigDecimal promedioSueldo) {
        this.totalPerfectos = totalPerfectos;
        this.areaMasCumplida = areaMasCumplida;
        this.promedioDias = promedioDias;
        this.promedioSueldo = promedioSueldo;
    }
    public int getTotalPerfectos() { return totalPerfectos; }
    public String getAreaMasCumplida() { return areaMasCumplida; }
    public BigDecimal getPromedioDias() { return promedioDias; }
    public BigDecimal getPromedioSueldo() { return promedioSueldo; }
}