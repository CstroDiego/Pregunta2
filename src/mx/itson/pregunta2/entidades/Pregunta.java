package mx.itson.pregunta2.entidades;

import mx.itson.pregunta2.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pregunta {

  private int id;
  private String pregunta;
  private String estado;

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

  public static boolean guardar(String pregunta, String estado) {
    boolean resultado = false;
    try {
      Connection conexion = Conexion.obtener();
      String query = "INSERT INTO tblPregunta (pregunta, estado) VALUES (?, ?)";
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPregunta() {
    return pregunta;
  }

  public void setPregunta(String pregunta) {
    this.pregunta = pregunta;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
}
