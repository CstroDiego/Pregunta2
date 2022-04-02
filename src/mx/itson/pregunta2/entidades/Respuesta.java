package mx.itson.pregunta2.entidades;

import mx.itson.pregunta2.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Respuesta {
  private int id;
  private String respuesta;
  private Date fechaCreacion;
  private Pregunta pregunta;

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

  public Date getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRespuesta() {
    return respuesta;
  }

  public void setRespuesta(String respuesta) {
    this.respuesta = respuesta;
  }

  public Pregunta getPregunta() {
    return pregunta;
  }

  public void setPregunta(Pregunta pregunta) {
    this.pregunta = pregunta;
  }
} // end class Respuesta
