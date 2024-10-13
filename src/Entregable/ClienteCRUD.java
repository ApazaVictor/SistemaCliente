/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entregable;

import Database.OracleDBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteCRUD {

    // Método para crear un cliente
    public static void createCliente(Connection connection, String dni, String nombre, String telefonos, String direccion) {
        String sql = "INSERT INTO Cliente (Dni, Nombre, Telefonos, Direccion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.setString(3, telefonos);
            statement.setString(4, direccion);
            statement.executeUpdate();
            System.out.println("Cliente creado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los clientes
    public static void readClientes(Connection connection) {
        String sql = "SELECT * FROM Cliente";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("DNI: " + resultSet.getString("Dni") +
                        ", Nombre: " + resultSet.getString("Nombre") +
                        ", Teléfonos: " + resultSet.getString("Telefonos") +
                        ", Dirección: " + resultSet.getString("Direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer un cliente por DNI (nuevo método)
    public static Cliente readCliente(Connection connection, String dni) {
        String sql = "SELECT * FROM Cliente WHERE Dni = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Crear y retornar un objeto Cliente con los datos obtenidos
                    String nombre = resultSet.getString("Nombre");
                    String telefonos = resultSet.getString("Telefonos");
                    String direccion = resultSet.getString("Direccion");
                    return new Cliente(dni, nombre, telefonos, direccion);
                } else {
                    System.out.println("Cliente no encontrado.");
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para actualizar un cliente
    public static void updateCliente(Connection connection, String dni, String nombre, String telefonos, String direccion) {
        String sql = "UPDATE Cliente SET Nombre = ?, Telefonos = ?, Direccion = ? WHERE Dni = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, telefonos);
            statement.setString(3, direccion);
            statement.setString(4, dni);
            statement.executeUpdate();
            System.out.println("Cliente actualizado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un cliente
    public static void deleteCliente(Connection connection, String dni) {
        String sql = "DELETE FROM Cliente WHERE Dni = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.executeUpdate();
            System.out.println("Cliente eliminado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
