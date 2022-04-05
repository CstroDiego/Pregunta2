package mx.itson.pregunta2.ui;

import mx.itson.pregunta2.entidades.Pregunta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Interfaz de usuario para pregunta.
 *
 * @author Diego Castro Arce
 * @author Andrés Uriel López Castillo
 */
public class PreguntaListado extends javax.swing.JFrame {

  /** Instancia de PreguntaListado para inicializar los componentes. */
  public PreguntaListado() {
    initComponents();
  }

  /**
   * Obtiene todos los registros de pregunta y los muestra en una tabla además de poderlos filtrar
   * por pregunta.
   *
   * @param filtro El filtro que se aplicará a la tabla.
   */
  public void cargar(String filtro) {
    Pregunta pregunta = new Pregunta();
    List<Pregunta> preguntas = pregunta.obtener(filtro);
    DefaultTableModel modeloTabla = (DefaultTableModel) tblPreguntas.getModel();
    modeloTabla.setRowCount(0);

    for (Pregunta p : preguntas) {
      modeloTabla.addRow(new Object[] {p.getId(), p.getPregunta(), p.getEstado()});
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
    tblPreguntas = new javax.swing.JTable();
    txtFiltro = new javax.swing.JTextField();
    lblPregunta = new javax.swing.JLabel();
    lblTitulo = new javax.swing.JLabel();
    btnBuscar = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    btnMenu = new javax.swing.JMenu();
    btnAgregar = new javax.swing.JMenuItem();
    btnActualizar = new javax.swing.JMenuItem();
    btnEliminar = new javax.swing.JMenuItem();
    btnRespuestas = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(
        new java.awt.event.WindowAdapter() {
          public void windowOpened(java.awt.event.WindowEvent evt) {
            formWindowOpened(evt);
          }
        });

    tblPreguntas.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null},
              {null, null, null},
              {null, null, null},
              {null, null, null}
            },
            new String[] {"ID Pregunta", "Pregunta", "Estado"}));
    jScrollPane1.setViewportView(tblPreguntas);

    txtFiltro.addKeyListener(
        new java.awt.event.KeyAdapter() {
          public void keyPressed(java.awt.event.KeyEvent evt) {
            txtFiltroKeyPressed(evt);
          }
        });

    lblPregunta.setText("Pregunta");

    lblTitulo.setText("Listado de preguntas");

    btnBuscar.setText("Buscar");
    btnBuscar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBuscarActionPerformed(evt);
          }
        });

    btnMenu.setText("Opciones");

    btnAgregar.setText("Agregar");
    btnAgregar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAgregarActionPerformed(evt);
          }
        });
    btnMenu.add(btnAgregar);

    btnActualizar.setText("Actualizar");
    btnActualizar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnActualizarActionPerformed(evt);
          }
        });
    btnMenu.add(btnActualizar);

    btnEliminar.setText("Eliminar");
    btnEliminar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEliminarActionPerformed(evt);
          }
        });
    btnMenu.add(btnEliminar);

    btnRespuestas.setText("Ver respuestas");
    btnRespuestas.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRespuestasActionPerformed(evt);
          }
        });
    btnMenu.add(btnRespuestas);

    jMenuBar1.add(btnMenu);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(jScrollPane1)
                                    .addContainerGap())
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(lblPregunta)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFiltro)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscar)
                                    .addGap(15, 15, 15))))
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap(343, Short.MAX_VALUE)
                    .addComponent(lblTitulo)
                    .addGap(342, 342, 342)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitulo)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txtFiltro,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPregunta)
                            .addComponent(btnBuscar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        275,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnBuscarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnBuscarActionPerformed
    cargar(txtFiltro.getText());
  } // GEN-LAST:event_btnBuscarActionPerformed

  private void txtFiltroKeyPressed(
      java.awt.event.KeyEvent evt) { // GEN-FIRST:event_txtFiltroKeyPressed
    cargar(txtFiltro.getText());
  } // GEN-LAST:event_txtFiltroKeyPressed

  private void btnAgregarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnAgregarActionPerformed
    PreguntaFormulario formulario = new PreguntaFormulario(this, true, 0, "");
    formulario.setVisible(true);
    cargar("");
  } // GEN-LAST:event_btnAgregarActionPerformed

  private void btnActualizarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnActualizarActionPerformed
    int renglon = tblPreguntas.getSelectedRow();
    String id = tblPreguntas.getModel().getValueAt(renglon, 0).toString();
    String estado = tblPreguntas.getModel().getValueAt(renglon, 2).toString();

    PreguntaFormulario formulario =
        new PreguntaFormulario(this, true, Integer.parseInt(id), estado);
    formulario.setVisible(true);
    cargar("");
  } // GEN-LAST:event_btnActualizarActionPerformed

  private void btnEliminarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnEliminarActionPerformed
    int renglon = tblPreguntas.getSelectedRow();
    String id = tblPreguntas.getModel().getValueAt(renglon, 0).toString();

    int resp =
        JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
    if (resp == JOptionPane.YES_OPTION) {
      Pregunta.eliminar(Integer.parseInt(id));
      JOptionPane.showMessageDialog(
          null,
          "Pregunta eliminada de la base de datos",
          "¡Éxito!",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(
          null,
          "No se ha borrado ningún registro de la base de datos",
          "Error",
          JOptionPane.WARNING_MESSAGE);
    }

    cargar("");
  } // GEN-LAST:event_btnEliminarActionPerformed

  private void btnRespuestasActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnRespuestasActionPerformed
    int renglon = tblPreguntas.getSelectedRow();
    String idPregunta = tblPreguntas.getModel().getValueAt(renglon, 0).toString();
    String estado = tblPreguntas.getModel().getValueAt(renglon, 2).toString();

    if (estado.equals("Abierta")) {
      RespuestaListado respuestas = new RespuestaListado(Integer.parseInt(idPregunta));
      respuestas.setVisible(true);

      this.dispose();
    } else {
      JOptionPane.showMessageDialog(
          this, "La pregunta ya no está disponible", "Error", JOptionPane.ERROR_MESSAGE);
    }
  } // GEN-LAST:event_btnRespuestasActionPerformed

  private void formWindowOpened(
      java.awt.event.WindowEvent evt) { // GEN-FIRST:event_formWindowOpened
    cargar("");
    tblPreguntas.removeColumn(tblPreguntas.getColumnModel().getColumn(0));
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
      java.util.logging.Logger.getLogger(PreguntaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PreguntaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PreguntaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PreguntaListado.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new PreguntaListado().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuItem btnActualizar;
  private javax.swing.JMenuItem btnAgregar;
  private javax.swing.JButton btnBuscar;
  private javax.swing.JMenuItem btnEliminar;
  private javax.swing.JMenu btnMenu;
  private javax.swing.JMenuItem btnRespuestas;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lblPregunta;
  private javax.swing.JLabel lblTitulo;
  private javax.swing.JTable tblPreguntas;
  private javax.swing.JTextField txtFiltro;
  // End of variables declaration//GEN-END:variables
} // Fin de la clase PreguntaListado
