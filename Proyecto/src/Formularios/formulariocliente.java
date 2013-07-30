/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * formulariocliente.java
 *
 * Created on 13-oct-2011, 23:30:02
 */
package Formularios;

import BaseDatos.ConexionMySQL;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Dreves N
 */
public class formulariocliente extends javax.swing.JInternalFrame {

    int z;
    DefaultTableModel modelo;
    String id_actualizar = "";
    String accion = "";

    /** Creates new form prueba */
    /** Creates new form formulariocliente */
    public formulariocliente() {
        initComponents();
        z = 1;
        cargar_datos("");
        inhabilitar();
        limpiar();

    }

    void habilitar() {
        txt_nombre.setEnabled(true);
        txt_rut.setEnabled(true);
        btn_guardar.setEnabled(true);
        txt_mail.setEnabled(true);
        txt_telefono.setEnabled(true);
        btn_cancelar.setEnabled(true);
        txt_direccion.setEnabled(true);
        txt_nombre.setText("");
        txt_rut.setText("");
        txt_mail.setText("");
        txt_direccion.setText("");
        txt_nombre.requestFocus();


    }

    void inhabilitar() {
        txt_nombre.setEnabled(false);
        txt_rut.setEnabled(false);
        txt_mail.setEnabled(false);
        txt_direccion.setEnabled(false);
        txt_telefono.setEnabled(false);
        btn_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);

    }

    public void limpiar() {
        txt_nombre.setText("");
        txt_direccion.setText("");
        txt_rut.setText("");
        txt_telefono.setText("");
        txt_mail.setText("");


    }

    public void cargar_datos(String valor) {
        int k = 0;
        String[] titulos = {"Rut", "Nombre", "Dirección", "Teléfono", "E-Mail"};
        String[] registro = new String[5];
        String sSQL = "";
        modelo = new DefaultTableModel(null, titulos);

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();

        if (z == 0) {
            sSQL = "SELECT rut_cliente,nombre, direccion, telefono, mail FROM cliente WHERE rut_cliente='" + valor + "'";
        } else {
            sSQL = "SELECT * from cliente";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                if (rs != null) {
                    k++;
                }
                registro[0] = rs.getString("rut_cliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("direccion");
                registro[3] = rs.getString("telefono");
                registro[4] = rs.getString("mail");
                modelo.addRow(registro);
            }
            if (k > 0) {
                tablaconsulta.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "No Existen clienten", "Búsqueda Inválida", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException ex) {
        }
    }

    public void ModificarCliente(String id) {
        habilitar();
        int k = 0;
        String sSQL = "";
        String rut_cliente = "", nombre = "", direccion = "", telefono = "", mail = "";

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();

        sSQL = "SELECT rut_cliente,nombre, direccion, telefono, mail FROM cliente WHERE rut_cliente='" + id + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                rut_cliente = rs.getString("rut_cliente");
                nombre = rs.getString("nombre");
                direccion = rs.getString("direccion");
                telefono = rs.getString("telefono");
                mail = rs.getString("mail");

            }
            txt_nombre.setText(nombre);
            txt_rut.setText(rut_cliente);
            txt_telefono.setText(telefono);
            txt_mail.setText(mail);
            txt_direccion.setText(direccion);

        } catch (SQLException ex) {
        }
        id_actualizar = id;
    }

    public void EliminarCliente(String id) {

        String sSQL = "";
        String rut_cliente = "", nombre = "", direccion = "", telefono = "", mail = "";

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();

        sSQL = "DELETE FROM cliente WHERE rut_cliente='" + id + "'";

        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sSQL);
            JOptionPane.showMessageDialog(null, "Se ha eliminado el cliente", "Proceso Éxitoso", JOptionPane.PLAIN_MESSAGE);
            z = 1;
            cargar_datos("");

        } catch (SQLException ex) {
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mn_editar = new javax.swing.JMenuItem();
        mn_editar2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txt_rut = new javax.swing.JTextField();
        lbl_rutdueño = new javax.swing.JLabel();
        lbl_especie = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_raza = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        lbl_sexo = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsulta = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_mostrartodos = new javax.swing.JButton();

        mn_editar.setText("Modificar");
        mn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_editarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mn_editar);

        mn_editar2.setText("Eliminar");
        mn_editar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_editar2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mn_editar2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Cliente"));
        jPanel1.setName("Ingresar Cliente"); // NOI18N

        txt_rut.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_rut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rutActionPerformed(evt);
            }
        });

        lbl_rutdueño.setText("Rut Dueño");
        lbl_rutdueño.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_rutdueño.setRequestFocusEnabled(false);

        lbl_especie.setText("Dirección");
        lbl_especie.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_especie.setRequestFocusEnabled(false);

        txt_direccion.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });

        lbl_raza.setText("Teléfono");
        lbl_raza.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_raza.setRequestFocusEnabled(false);

        txt_telefono.setPreferredSize(new java.awt.Dimension(120, 20));

        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        lbl_sexo.setText("Correo Electrónico");
        lbl_sexo.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_sexo.setRequestFocusEnabled(false);

        lbl_nombre.setText("Nombre");
        lbl_nombre.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_nombre.setRequestFocusEnabled(false);

        txt_mail.setPreferredSize(new java.awt.Dimension(120, 20));

        txt_nombre.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(lbl_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_rutdueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_mail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_nuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guardar)
                        .addGap(15, 15, 15)
                        .addComponent(btn_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salir)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rutdueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_salir))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Cliente"));

        tablaconsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaconsulta.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tablaconsulta);

        lbl_buscar.setText("Ingrese Rut Cliente");

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_mostrartodos.setText("Mostrar Todos");
        btn_mostrartodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrartodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mostrartodos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mostrartodos)
                    .addComponent(btn_buscar)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rutActionPerformed
        txt_rut.transferFocus();
}//GEN-LAST:event_txt_rutActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        txt_direccion.transferFocus();
}//GEN-LAST:event_txt_direccionActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        habilitar();
        accion = "Insertar";
}//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.Conectar();
        String nombre, rut_cliente, direccion, telefono, mail;
        String sSQL = "";
        nombre = txt_nombre.getText();
        mail = txt_mail.getText();
        String mensaje = "";
        direccion = txt_direccion.getText();
        rut_cliente = txt_rut.getText();
        telefono = txt_telefono.getText();

        if (accion.equals("Insertar")) {

            sSQL = "INSERT INTO cliente(rut_cliente, nombre, direccion, telefono, mail) VALUES(?, ? , ? , ? ,?)";

            mensaje = "Los datos se han insertado de manera satisfactoria";
            z = 1;
            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setString(1, rut_cliente);
                pst.setString(2, nombre);
                pst.setString(3, direccion);
                pst.setString(4, telefono);
                pst.setString(5, mail);
                int n = pst.executeUpdate();
                JOptionPane.showMessageDialog(null, n, "Advertencia", JOptionPane.PLAIN_MESSAGE);
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "Proceso Éxitoso", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            cargar_datos("");
        } else if (accion.equals("Modificar")) {
            sSQL = "UPDATE cliente SET rut_cliente=?, nombre=?, direccion=?, telefono=?, mail=? WHERE rut_cliente=" + id_actualizar;

            mensaje = "Los datos se han modificado de manera satisfactoria";

            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setString(1, rut_cliente);
                pst.setString(2, nombre);
                pst.setString(3, direccion);
                pst.setString(4, telefono);
                pst.setString(5, mail);
                int n = pst.executeUpdate();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "Proceso Éxitoso", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            z = 0;
            cargar_datos(rut_cliente);

        }
        inhabilitar();
}//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        inhabilitar();
        limpiar();
}//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
}//GEN-LAST:event_btn_salirActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        z = 0;
        String busqueda_vacia = "Debes ingresar el rut de un cliente, para realizar la bsqueda";
        int h = 0;
        String valor = txt_buscar.getText();

        if (valor.equals("")) {
            h = 1;
            JOptionPane.showMessageDialog(null, busqueda_vacia, "Búsqueda Inválida", JOptionPane.PLAIN_MESSAGE);

        }

        if (h == 0) {
            cargar_datos(valor);
        }
}//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_mostrartodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrartodosActionPerformed
        z = 1;
        cargar_datos("");
}//GEN-LAST:event_btn_mostrartodosActionPerformed

    private void mn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_editarActionPerformed
        int filasel;
        String id;

        try {
            filasel = tablaconsulta.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione Algun paciente a modificar", "Advertencia", JOptionPane.PLAIN_MESSAGE);
            } else {
                accion = "Modificar";
                modelo = (DefaultTableModel) tablaconsulta.getModel();
                id = (String) modelo.getValueAt(filasel, 0);
                ModificarCliente(id);


            }

        } catch (Exception e) {
        }
}//GEN-LAST:event_mn_editarActionPerformed

    private void mn_editar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_editar2ActionPerformed
        int filasel;
        String id;

        try {
            filasel = tablaconsulta.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione Algun paciente a Eliminar", "Advertencia", JOptionPane.PLAIN_MESSAGE);
            } else {
                modelo = (DefaultTableModel) tablaconsulta.getModel();
                id = (String) modelo.getValueAt(filasel, 0);
                EliminarCliente(id);


            }

        } catch (Exception e) {
        }
}//GEN-LAST:event_mn_editar2ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_mostrartodos;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_especie;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_raza;
    private javax.swing.JLabel lbl_rutdueño;
    private javax.swing.JLabel lbl_sexo;
    private javax.swing.JMenuItem mn_editar;
    private javax.swing.JMenuItem mn_editar2;
    private javax.swing.JTable tablaconsulta;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_rut;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
