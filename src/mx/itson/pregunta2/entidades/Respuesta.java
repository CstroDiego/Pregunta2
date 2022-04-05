package mx.itson.pregunta2.entidades;

import mx.itson.pregunta2.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Contiene los atributos y métodos correspondientes a respuesta.
 *
 * @author Andrés Uriel López Castillo
 * @author Diego Castro Arce
 */
public class Respuesta {
  private int id;
  private String respuesta;
  private Date fechaCreacion;
  private Pregunta pregunta;

  /**
   * Obtiene los registros de la tabla tblRespuesta.
   *
   * @param idPregunta El id de la pregunta.
   * @return Lista de respuestas.
   */
  public List<Respuesta> obtener(int idPregunta) {
    List<Respuesta> respuestas = new ArrayList<>();

    try {
      Connection conexion = Conexion.obtener();
      PreparedStatement statement =
          conexion.prepareStatement(
              "SELECT r.id, r.respuesta, r.fechaCreacion, p.id, p.pregunta FROM tblRespuesta r INNER JOIN tblPregunta p ON r.idPregunta = p.id WHERE r.idPregunta = ?");
      statement.setInt(1, idPregunta);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Respuesta r = new Respuesta();
        r.setId(resultSet.getInt(1));
        r.setRespuesta(resultSet.getString(2));
        r.setFechaCreacion(resultSet.getDate(3));

        Pregunta p = new Pregunta();
        p.setId(resultSet.getInt(4));
        p.setPregunta(resultSet.getString(5));

        r.setPregunta(p);

        respuestas.add(r);
      }
      conexion.close();
    } catch (SQLException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return respuestas;
  }

  /**
   * Obtiene los registros de respuesta basándonos en el criterio id.
   *
   * @param idPregunta El id de la pregunta.
   * @return Lista de respuestas.
   */
  public static Respuesta obtenerPorId(int idPregunta) {
    Respuesta respuesta = new Respuesta();
    try {
      Connection conexion = Conexion.obtener();
      String query = "SELECT id, respuesta  FROM tblRespuesta where id = ?";
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setInt(1, idPregunta);

      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        respuesta.setId(resultSet.getInt(1));
        respuesta.setRespuesta(resultSet.getString(2));
      }
      conexion.close();
    } catch (SQLException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return respuesta;
  }

  /**
   * Guarda un nuevo registro de respuesta en la base de datos.
   *
   * @param respuesta La respuesta.
   * @param fechaCreacion La fecha de creación.
   * @param idPregunta El id de la pregunta.
   * @return Resultado que indica si la operación se realizó con éxito.
   */
  public static boolean guardar(String respuesta, Date fechaCreacion, int idPregunta) {
    boolean resultado = false;

    try {
      Connection conexion = Conexion.obtener();
      String query =
          "INSERT INTO tblRespuesta (respuesta, fechaCreacion, idPregunta) VALUES (?, ?, ?)";
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, respuesta);
      statement.setString(2, fechaCreacion.toString());
      statement.setInt(3, idPregunta);

      statement.execute();

      resultado = statement.getUpdateCount() == 1;

      conexion.close();
    } catch (SQLException ex) {
      System.err.print("Error: " + ex.getMessage());
    }
    return resultado;
  }

  /**
   * Guarda los cambios hechos a una respuesta existente.
   *
   * @param idPregunta El id de la pregunta.
   * @param fechaCreacion La fecha de creación.
   * @param respuesta La respuesta.
   * @return Resultado que indica si la operación se realizó con éxito.
   */
  public static boolean editar(int idPregunta, Date fechaCreacion, String respuesta) {
    boolean resultado = false;
    try {
      Connection conexion = Conexion.obtener();
      String query =
          "UPDATE tblRespuesta SET respuesta = ?, fechaCreacion= ?, idPregunta =?  WHERE id = ?";
      PreparedStatement statement = conexion.prepareStatement(query);
      statement.setString(1, respuesta);
      statement.setString(2, fechaCreacion.toString());
      statement.setInt(3, idPregunta);
      statement.execute();

      resultado = statement.getUpdateCount() == 1;

      conexion.close();
    } catch (SQLException ex) {
      System.err.println("Error: " + ex.getMessage());
    }
    return resultado;
  }

  /**
   * Obtiene el valor del atributo fechaCreacion.
   *
   * @return El atributo fechaCreacion.
   */
  public Date getFechaCreacion() {
    return fechaCreacion;
  }

  /**
   * Asigna el valor del atributo fechaCreacion.
   *
   * @param fechaCreacion El valor del atributo fechaCreacion.
   */
  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  /**
   * Obtiene el valor del atributo id.
   *
   * @return El atributo id.
   */
  public int getId() {
    return id;
  }

  /**
   * Asigna el valor del atributo id.
   *
   * @param id El valor del atributo id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Obtiene el valor del atributo respuesta.
   *
   * @return El atributo respuesta.
   */
  public String getRespuesta() {
    return respuesta;
  }

  /**
   * Asigna el valor del atributo respuesta.
   *
   * @param respuesta El valor del atributo respuesta.
   */
  public void setRespuesta(String respuesta) {
    this.respuesta = respuesta;
  }

  /**
   * Obtiene el valor del atributo pregunta.
   *
   * @return El atributo pregunta.
   */
  public Pregunta getPregunta() {
    return pregunta;
  }

  /**
   * Asigna el valor del atributo pregunta.
   *
   * @param pregunta El valor del atributo pregunta.
   */
  public void setPregunta(Pregunta pregunta) {
    this.pregunta = pregunta;
  }
} // Fin de la clase Respuesta.
