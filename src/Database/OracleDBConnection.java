package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDBConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Cambia según tu configuración
    private static final String USER = "PRUEBA"; 
    private static final String PASSWORD = "1234560"; 

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Cargar el driver de Oracle
            connection = DriverManager.getConnection(URL, USER, PASSWORD); // Establecer la conexión
            System.out.println("Conexión exitosa a la base de datos Oracle.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver de Oracle no encontrado.");
            throw new SQLException("Driver de Oracle no encontrado", e); // Lanzar SQLException
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            throw e; // Lanzar excepción
        }
        return connection; // Devuelve la conexión
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}






