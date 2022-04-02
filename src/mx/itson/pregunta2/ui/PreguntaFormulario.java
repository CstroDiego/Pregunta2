/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.pregunta2.ui;

import mx.itson.pregunta2.entidades.Pregunta;

import javax.swing.*;

/**
 * @author diego
 */
public class PreguntaFormulario extends javax.swing.JDialog {
  int id = 0;
  String estado = "";
  /** Creates new form PreguntaFormulario */
  public PreguntaFormulario() {
    initComponents();
  }

  public PreguntaFormulario(java.awt.Frame parent, boolean modal, int id, String estado) {
    super(parent, modal);
    initComponents();

    this.id = id;
    this.estado = estado;
    cargarFormulario();
  }

  public void cargarFormulario() {
    if (this.id != 0) {
      Pregunta p = Pregunta.obtenerPorId(this.id);
      txtPregunta.setText(p.getPregunta());
      txtEstado.setText(p.getEstado());
    }
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    txtPregunta = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    btnAgregar = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    txtEstado = new javax.swing.JTextField();

    jLabel1.setText("Pregunta");

    jLabel2.setText("Pregunta: ");

    btnAgregar.setText("Guardar");
    btnAgregar.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAgregarActionPerformed(evt);
          }
        });

    jLabel3.setText("Estado");

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
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEstado)
                                            .addComponent(
                                                txtPregunta,
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(0, 307, Short.MAX_VALUE)
                                                    .addComponent(btnAgregar))))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(jLabel2))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(jLabel3)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(170, 170, 170)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(30, 30, 30)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtPregunta,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        txtEstado,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnAgregar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void btnAgregarActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnAgregarActionPerformed

    String pregunta = txtPregunta.getText();
    String estado = txtEstado.getText();

    boolean resultado =
        this.id == 0
            ? Pregunta.guardar(pregunta, estado)
            : Pregunta.editar(this.id, pregunta, estado);

    if (resultado) {
      JOptionPane.showMessageDialog(
          this,
          "El registro fue guardado correctamente",
          "REGISTRO GUARDADO",
          JOptionPane.INFORMATION_MESSAGE);
      dispose();
    } else {
      JOptionPane.showMessageDialog(
          this, "Ocurrió un error al guardar el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
      dispose();
    } // GEN-LAST:event_btnAgregarActionPerformed
  }
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
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
      java.util.logging.Logger.getLogger(PreguntaFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PreguntaFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PreguntaFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PreguntaFormulario.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            PreguntaFormulario dialog =
                new PreguntaFormulario(new javax.swing.JFrame(), true, 0, "");
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
  private javax.swing.JButton btnAgregar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField txtEstado;
  private javax.swing.JTextField txtPregunta;
  // End of variables declaration//GEN-END:variables
}