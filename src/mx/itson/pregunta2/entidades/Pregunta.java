package mx.itson.pregunta2.entidades;

import mx.itson.pregunta2.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene los atributos y métodos correspondientes a Pregunta.
 *
 * @author Diego Castro Arce
 * @author Andrés Uriel López Castillo
 */
public class Pregunta {

  private int id;
  private String pregunta;
  private String estado;

  /**
   * Obtiene los registros de la tabla tblPregunta.
   *
   * @param filtro Define el criterio a buscar con base en pregunta
   * @return La lista de preguntas que coinciden con el filtro
   */
  public List<Pregunta> obtener(String filtro) {

    List<Pregunta> preguntas = new ArrayList<>();
    try {
      Connection conexion = Conexion.obtener();
      PreparedStatement statement =
          conexion.prepareStatement(
              "SELECT id, pregunta, estado FROM tblPregunta WHERE pregunta like ?");
      statement.setString(1, "%" + filtro + "%");
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Pregunta pregunta = new Pregunta();
        pregunta.setId(resultSet.getInt(1));
        pregunta.setPregunta(resultSet.getString(2));
        pregunta.setEstado(resultSet.getString(3));

        preguntas.add(pregunta);
      }
      conexion.close();
    } catch (SQLException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return preguntas;
  }

  /**
   * Obtiene el registro de la base de datos según el criterio id.
   *
   * @param id id de la pregunta
   * @return Lista de preguntas que coinciden con el criterio de búsqueda
   */
  public static Pregunta obtenerPorId(int id) {
    Pregunta pregunta = new Pregunta();
    try {
      Connection conexion = Conexion.obtener();
      String query = "SELECT id, pregunta, estado  FROM tblPregunta where id = ?";
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, id);

      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        pregunta.setId(resultSet.getInt(1));
        pregunta.setPregunta(resultSet.getString(2));
        pregunta.setEstado(resultSet.getString(3));
      }
      conexion.close();
    } catch (SQLException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return pregunta;
  }

  /**
   * Guarda un nuevo registro de pregunta en la base de datos.
   *
   * @param pregunta La pregunta a guardar
   * @param estado Estado de la pregunta
   * @return Resultado que indica si la operación se realizó con éxito
   */
  public static boolean guardar(String pregunta, String estado) {
    boolean resultado = false;
    try {
      Connection conexion = Conexion.obtener();
      String query = "INSERT INTO tblPregunta (pregunta, estado) VALUES (?,?)";
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, pregunta);
      statement.setString(2, estado);

      statement.execute();

      resultado = statement.getUpdateCount() == 1;

      conexion.close();
    } catch (SQLException ex) {
      System.err.print("Error: " + ex.getMessage());
    }
    return resultado;
  }

  /**
   * Guarda los cambios hechos a una pregunta existente.
   *
   * @param id id de la pregunta
   * @param pregunta La pregunta a guardar
   * @param estado Estado de la pregunta
   * @return Resultado que indica si la operación se realizó con éxito
   */
  public static boolean editar(int id, String pregunta, String estado) {
    boolean resultado = false;
    try {
      Connection conexion = Conexion.obtener();
      String query = "UPDATE tblPregunta SET pregunta = ?, estado= ? WHERE id = ?";
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, pregunta);
      statement.setString(2, estado);
      statement.setInt(3, id);
      statement.execute();

      resultado = statement.getUpdateCount() == 1;

      conexion.close();
    } catch (SQLException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return resultado;
  }

  /**
   * Elimina un registro de pregunta con base en el criterio id.
   *
   * @param id id de la pregunta
   */
  public static void eliminar(int id) {

    try {
      Connection conexion = Conexion.obtener();
      String query = "DELETE FROM tblPregunta WHERE id = ?";
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, id);
      statement.execute();

      conexion.close();
    } catch (SQLException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
  }

  /**
   * Obtiene el valor del atributo id.
   *
   * @return El atributo id
   */
  public int getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo id.
   *
   * @param id El valor del atributo id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Obtiene el valor del atributo pregunta.
   *
   * @return El atributo pregunta
   */
  public String getPregunta() {
    return pregunta;
  }

  /**
   * Asigna el valor del atributo pregunta.
   *
   * @param pregunta El valor del atributo pregunta
   */
  public void setPregunta(String pregunta) {
    this.pregunta = pregunta;
  }

  /**
   * Obtiene el valor del atributo estado.
   *
   * @return El atributo estado
   */
  public String getEstado() {
    return estado;
  }

  /**
   * Asigna el valor del atributo estado.
   *
   * @param estado El valor del atributo estado
   */
  public void setEstado(String estado) {
    this.estado = estado;
  }
} // Fin de la clase Pregunta
