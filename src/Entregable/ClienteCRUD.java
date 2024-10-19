/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entregable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {

public static void agregarCliente(Connection connection, String dni, String nombre, String telefonos, String direccion) throws SQLException {
    // Verificar si el cliente ya existe
    if (clienteExists(connection, dni)) {
        System.out.println("El cliente con DNI " + dni + " ya existe."); // Mensaje claro en la consola
        return; // Salir del método si el cliente ya existe
    }
    
    String sql = "INSERT INTO Cliente (Dni, Nombre, Telefonos, Direccion) VALUES (?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, dni);
        statement.setString(2, nombre);
        statement.setString(3, telefonos);
        statement.setString(4, direccion);
        statement.executeUpdate();
        System.out.println("Cliente agregado exitosamente.");
    }
}


    private static boolean clienteExists(Connection connection, String dni) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Cliente WHERE Dni = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Retorna true si el cliente existe
            }
        }
        return false; // Retorna false si el cliente no existe
    }

    public static void modificarCliente(Connection connection, String dni, String nombre, String telefonos, String direccion) throws SQLException {
        String sql = "UPDATE Cliente SET Nombre = ?, Telefonos = ?, Direccion = ? WHERE Dni = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, telefonos);
            statement.setString(3, direccion);
            statement.setString(4, dni);
            statement.executeUpdate();
            System.out.println("Cliente modificado exitosamente.");
        }
    }

public static void eliminarCliente(Connection connection, String dni) throws SQLException {
    // Primero elimina los registros en la tabla de compras que están relacionados con este cliente
    eliminarComprasPorCliente(connection, dni);

    String sql = "DELETE FROM Cliente WHERE Dni = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, dni);
        statement.executeUpdate();
        System.out.println("Cliente marcado como inactivo.");
    }
}

private static void eliminarComprasPorCliente(Connection connection, String dni) throws SQLException {
    String sql = "DELETE FROM Compra WHERE Dni = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, dni);
        statement.executeUpdate();
        System.out.println("Registros de compra eliminados para el cliente con DNI " + dni);
    }
}

private static boolean tieneRegistrosAsociados(Connection connection, String dni) throws SQLException {
    // Aquí debes verificar en las tablas relacionadas (por ejemplo, Compra)
    String sql = "SELECT COUNT(*) FROM Compra WHERE Dni = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, dni);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1) > 0; // Retorna true si hay registros asociados
        }
    }
    return false; // Retorna false si no hay registros asociados
}


 public static List<Cliente> listarClientes(Connection connection) throws SQLException {
    List<Cliente> clientes = new ArrayList<>();
    String sql = "SELECT * FROM Cliente";
    try (PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
            String dni = resultSet.getString("Dni");
            String nombre = resultSet.getString("Nombre");
            String telefonos = resultSet.getString("Telefonos");
            String direccion = resultSet.getString("Direccion");
            Cliente cliente = new Cliente(dni, nombre, telefonos, direccion);
            clientes.add(cliente);
        }
    }
    return clientes;
}

}
