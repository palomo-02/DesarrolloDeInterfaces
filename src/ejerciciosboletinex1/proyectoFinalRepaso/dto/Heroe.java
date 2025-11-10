/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosboletinex1.proyectoFinalRepaso.dto;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Heroe {

    private String nombre;
    private String poder;
    private int nivel;
    private Date fecha;

    public Heroe(String nombre, String poder, int nivel, Date fecha) {
        this.nombre = nombre;
        this.poder = poder;
        this.nivel = nivel;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
