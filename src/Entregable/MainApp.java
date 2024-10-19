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
        Connection dbConnection = null;
        try {
            dbConnection = OracleDBConnection.getConnection();

            // Operaciones CRUD
            crearClientesPrueba(dbConnection);
            consultarClientes(dbConnection);
            actualizarCliente(dbConnection);
            eliminarCliente(dbConnection);

        } catch (SQLException e) {
            System.err.println("Error durante la operación con la base de datos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            OracleDBConnection.closeConnection(dbConnection);
        }
    }

private static void crearClientesPrueba(Connection connection) {
    // Crear clientes de prueba
    String[][] clientesPrueba = {
        {"12345678", "Juan Pérez", "987654321", "Calle Falsa 123"},
        {"23456789", "María López", "555555555", "Avenida Siempre Viva 742"},
        {"34567890", "Carlos Rodríguez", "111111111", "Calle Real 456"},
        {"45678901", "Ana Martínez", "222222222", "Avenida Principal 789"},
        {"56789012", "Luis Gómez", "333333333", "Calle Secundaria 101"}
    };

    for (String[] cliente : clientesPrueba) {
        try {
            ClienteCRUD.agregarCliente(connection, cliente[0], cliente[1], cliente[2], cliente[3]);
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Muestra el mensaje si el cliente ya existe
        }
    }
}



    private static void consultarClientes(Connection connection) throws SQLException {
        // Consultar todos los clientes
        ClienteCRUD.listarClientes(connection);
    }

    private static void actualizarCliente(Connection connection) throws SQLException {
        // Actualizar un cliente de prueba
        ClienteCRUD.modificarCliente(connection, "12345679", "Juanito Pérez", "999999999", "Avenida Nueva 456");
    }

    private static void eliminarCliente(Connection connection) throws SQLException {
        // Eliminar un cliente de prueba
        ClienteCRUD.eliminarCliente(connection, "56789012");
    }
}


