/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entregable;

import Database.OracleDBConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        // Establecer la conexión a la base de datos
        Connection dbConnection = null; // Usa un nombre diferente para evitar conflictos
        try {
            dbConnection = OracleDBConnection.getConnection(); // Obtiene la conexión

            // Crear un cliente
            String dni = "12345610"; // Asegúrate de que este DNI es único en la base de datos
            String nombre = "Juan Chavez";
            String telefonos = "987654330";
            String direccion = "Av. Siempre Viva 127";
            ClienteCRUD.createCliente(dbConnection, dni, nombre, telefonos, direccion); // Usa la conexión aquí

            // Leer clientes
            ClienteCRUD.readClientes(dbConnection); // Lee todos los clientes

            // Actualizar un cliente
            String nuevoNombre = "Juan Chavez Actualizado";
            String nuevosTelefonos = "987654330";
            String nuevaDireccion = "Av. Nueva 127";
            ClienteCRUD.updateCliente(dbConnection, dni, nuevoNombre, nuevosTelefonos, nuevaDireccion); // Actualiza el cliente

            // Eliminar un cliente
            ClienteCRUD.deleteCliente(dbConnection, dni); // Elimina el cliente
        } catch (SQLException e) {
            e.printStackTrace();  // Muestra el error si ocurre
        } finally {
            // Cerrar la conexión
            OracleDBConnection.closeConnection(dbConnection); // Cierra la conexión aquí
        }
    }
}




