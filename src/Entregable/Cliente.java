/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entregable;

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

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getDireccion() {
        return direccion;
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
