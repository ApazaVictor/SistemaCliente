/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entregable;

/**
 *
 * @author i5
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String telefonos;
    private String direccion;

    // Constructor
    public Cliente(String dni, String nombre, String telefonos, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefonos = telefonos;
        this.direccion = direccion;
    }

    // Getters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public String getDireccion() {
        return direccion;
    }

    // Setters
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + 
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefonos='" + telefonos + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

