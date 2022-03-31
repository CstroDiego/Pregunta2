package mx.itson.pregunta2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Crea la conexión con la base de datos.
 *
 * @author Diego Castro
 */
public class Conexion {

    /**
     * Crea la conexión con MYSQL.
     *
     * @return Conexion establecida
     */
    public static Connection obtener() {

        Connection connection = null;
        try {
            connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost/pregunta2db?user=diego&password=761834925");

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        return connection;
    }
}
