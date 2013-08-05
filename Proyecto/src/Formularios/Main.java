/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * principal.java
 *
 * Created on 13-oct-2011, 1:05:08
 */
package Formularios;

import BaseDatos.DatabaseConnection;
import javax.swing.JFrame; 
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Carlos Dreves N
 */
public class Main extends javax.swing.JFrame {

    static Logger logger = Logger.getLogger(Main.class);
    FormularioPaciente formularioPaciente = new FormularioPaciente(); // se debe instanciar ac� para validar que no este abierto y no instanciarlo siempre
    FormularioCliente formularioCliente = new FormularioCliente();   // se debe instanciar ac� para validar que no este abierto y no instanciarlo siempre

    /**
     * Creates new form principal
     */
    public Main() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuIPacientes = new javax.swing.JMenuItem();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setAutoscrolls(true);

        jMenu1.setText("Menu");

        jMenuIPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuIPacientes.setText("Pacientes");
        jMenuIPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuIPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuIPacientes);

        jMenuItemClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemClientes);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuIPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuIPacientesActionPerformed
        PropertyConfigurator.configure("log4j.properties");

        if (formularioPaciente.isVisible() == true) {
            logger.info("Se intento abrir formulario de pacientes, pero ya esta abierto");
        } else {
            jDesktopPane1.add(formularioPaciente);
            formularioPaciente.setVisible(true);
            logger.info("inicializando formulario paciente ");
        }

    }//GEN-LAST:event_jMenuIPacientesActionPerformed

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed

        PropertyConfigurator.configure("log4j.properties");

        if (formularioCliente.isVisible() == true) {
            logger.info("Se intento abrir formulario de clientes, pero ya esta abierto");
        } else {
            jDesktopPane1.add(formularioCliente);

            formularioCliente.setVisible(true);
  
            logger.info("Se ha abierto formulario de clientes");
        }

    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    public void abrirFormularioPaciente(){
                PropertyConfigurator.configure("log4j.properties");

            jDesktopPane1.add(formularioPaciente);

            formularioPaciente.show();
  
            logger.info("Se ha abierto formulario de clientes");
        
    }
    
    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Main main = new Main();
                main.setVisible(true);
                main.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximizar el frame principal

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuIPacientes;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemSalir;
    // End of variables declaration//GEN-END:variables
}
