package mx.itson.pregunta2.ui;

import mx.itson.pregunta2.entidades.Respuesta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Interfaz de usuario para respuesta.
 *
 * @author Andrés Uriel López Castillo
 * @author Diego Castro Arce
 */
public class RespuestaListado extends javax.swing.JFrame {
  /** id de pregunta. */
  int idPregunta;

  /** The Estado. */
  String estado;
  /**
   * Instancia para inicializar los componentes.
   *
   * @param idPregunta id de pregunta
   * @param estado the estado
   */
  public RespuestaListado(int idPregunta, String estado) {

    this.idPregunta = idPregunta;
    this.estado = estado;
    initComponents();
  }

  /**
   * Obtiene todos los registros de respuesta y los muestra en una tabla además de poderlos filtrar
   * por respuesta.
   *
   * @param idPregunta the id pregunta
   */
  public void cargar(int idPregunta) {
    Respuesta respuesta = new Respuesta();
    List<Respuesta> respuestas = respuesta.obtener(idPregunta);
    DefaultTableModel modeloTabla = (DefaultTableModel) tblRespuestas.getModel();
    modeloTabla.setRowCount(0);

    for (Respuesta r : respuestas) {
      modeloTabla.addRow(
          new Object[] {
            r.getId(), r.getRespuesta(), r.getFechaCreacion(), r.getPregunta().getId(),
          });
    }
  }
  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tblRespuestas = new javax.swing.JTable();
    lblTitulo = new javax.swing.JLabel();
    btnRegresar = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    btnAgregar = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(
        new java.awt.event.WindowAdapter() {
          public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
          }
        });

    tblRespuestas.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
            },
            new String[] {"ID", "Respuesta", "Fecha de creación", "ID pregunta"}));
    jScrollPane1.setViewportView(tblRespuestas);

    lblTitulo.setText("Lista de respuestas");

    btnRegresar.setText("Regresar");
    btnRegresar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRegresarActionPerformed(evt);
          }
        });

    jMenu1.setText("Opciones");

    btnAgregar.setText("Agregar");
    btnAgregar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAgregarActionPerformed(evt);
          }
        });
    jMenu1.add(btnAgregar);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(
                                        jScrollPane1,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        527,
                                        Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(202, 202, 202)
                                    .addComponent(lblTitulo)
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnRegresar)))
                    .addContainerGap()));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(lblTitulo)
                    .addGap(18, 18, Short.MAX_VALUE)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        250,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnRegresar)
                    .addGap(13, 13, 13)));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnAgregarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnAgregarActionPerformed
    if (estado.equals("Abierta")) {
      RespuestaFormulario formulario = new RespuestaFormulario(this, true, idPregunta, estado);

      formulario.setVisible(true);
    } else {
      JOptionPane.showMessageDialog(this, "La pregunta está cerrada");
    }
    cargar(idPregunta);
  } // GEN-LAST:event_btnAgregarActionPerformed

  private void btnRegresarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnRegresarActionPerformed
    this.dispose();
    PreguntaListado preguntas = new PreguntaListado();
    preguntas.setVisible(true);
  } // GEN-LAST:event_btnRegresarActionPerformed

  private void formWindowOpened(
      java.awt.event.WindowEvent evt) { // GEN-FIRST:event_formWindowOpenedq
    cargar(idPregunta);
    tblRespuestas.removeColumn(tblRespuestas.getColumnModel().getColumn(0));
    tblRespuestas.removeColumn(tblRespuestas.getColumnModel().getColumn(2));
  } // GEN-LAST:event_formWindowOpened

  /**
   * Main de la interfaz de usuario.
   *
   * @param args Los argumentos de la línea de comandos.
   */
  public static void main(String[] args) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(RespuestaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(RespuestaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(RespuestaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RespuestaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            RespuestaListado dialog = new RespuestaListado(0, "");
            dialog.addWindowListener(
                new java.awt.event.WindowAdapter() {
                  @Override
                  public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                  }
                });
            dialog.setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem btnAgregar;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblTitulo;
  private javax.swing.JTable tblRespuestas;
  // End of variables declaration//GEN-END:variables
} // Fin de la clase RespuestaListado
