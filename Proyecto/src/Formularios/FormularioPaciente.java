/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * prueba.java
 *
 * Created on 13-oct-2011, 15:30:52
 */
package Formularios;

import BaseDatos.DatabaseConnection;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Carlos Dreves N
 */
public class FormularioPaciente extends javax.swing.JInternalFrame {

    int z;
    DefaultTableModel modelo;
    String id_actualizar = "";
    String accion = "Insertar";
    DatabaseConnection mysql = new DatabaseConnection();
    Connection cn = mysql.getConnection();

    static Logger logger = Logger.getLogger(FormularioPaciente.class);
    
    /**
     * Creates new form prueba
     */
    public FormularioPaciente(){
        initComponents();
        z = 1;
        //cargar_datos("");
        inhabilitar();
        limpiar();
        cbo_sexo.addItem("Macho");
        cbo_sexo.addItem("Hembra");
    }
    public void abrirPaciente(){
        initComponents();
        z = 1;
        //cargar_datos("");
        inhabilitar();
        limpiar();
        cbo_sexo.addItem("Macho");
        cbo_sexo.addItem("Hembra");
    }
    void habilitar() {
        txt_nombre.setEnabled(true);
        txt_rut.setEnabled(true);
        txt_color.setEnabled(true);
        txt_fechanac.setEnabled(true);
        txt_especie.setEnabled(true);
        txt_raza.setEnabled(true);
        cbo_sexo.setEnabled(true);
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
        txt_nombre.setText("");
        txt_rut.setText("");
        txt_color.setText("");
        txt_fechanac.setDate(null);
        txt_especie.setText("");
        txt_raza.setText("");
        txt_nombre.requestFocus();


    }

    void inhabilitar() {
        txt_nombre.setEnabled(false);
        txt_rut.setEnabled(false);
        txt_color.setEnabled(false);
        txt_fechanac.setEnabled(false);
        txt_especie.setEnabled(false);
        txt_raza.setEnabled(false);
        cbo_sexo.setEnabled(false);
        btn_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);

    }

    public void limpiar() {
        txt_nombre.setText("");
        txt_rut.setText("");
        txt_color.setText("");
        txt_fechanac.setDate(null);
        txt_especie.setText("");
        txt_raza.setText("");


    }

    public void cargar_datos(String valor) {
        int k = 0;
        String[] titulos = {"Número Ficha", "Nombre Paciente", "Color", "Fecha Nacimiento", "Epecie", "Raza", "Sexo", "Rut Cliente"};
        String[] registro = new String[8];
        String sSQL = "";
        modelo = new DefaultTableModel(null, titulos);

        if (z == 0) {
            sSQL = "SELECT id,nombre, color, fecha_nacimiento, especie, raza, sexo, rut_cliente FROM paciente WHERE nombre='" + valor + "'";
        } else {
            sSQL = "SELECT * from paciente";
        }


        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                if (rs != null) {
                    k++;
                }
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("color");
                registro[3] = rs.getString("fecha_nacimiento");
                registro[4] = rs.getString("especie");
                registro[5] = rs.getString("raza");
                registro[6] = rs.getString("sexo");
                registro[7] = rs.getString("rut_cliente");
                modelo.addRow(registro);
            }
            if (k > 0) {
                tablaconsulta.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "No Existe paciente ingresado para búsqueda", "Búsqueda Inválida", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException ex) {
        }
    }

    public void ModificarPaciente(String id) {
        habilitar();
        int k = 0;
        String sSQL = "";
        String numero_paciente = "", nombre = "", color = "", fecha_nacimiento = "", especie = "", raza = "", sexo = "", rut_cliente = "";

        sSQL = "SELECT numero_paciente,nombre, color, fecha_nacimiento, especie, raza, sexo, rut_cliente FROM paciente WHERE numero_paciente='" + id + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                numero_paciente = rs.getString("numero_paciente");
                nombre = rs.getString("nombre");
                color = rs.getString("color");
                fecha_nacimiento = rs.getString("fecha_nacimiento");
                especie = rs.getString("especie");
                raza = rs.getString("raza");
                sexo = rs.getString("sexo");
                rut_cliente = rs.getString("rut_cliente");

            }
            txt_nombre.setText(nombre);
            txt_rut.setText(rut_cliente);
            txt_color.setText(color);
            txt_especie.setText(especie);
            txt_raza.setText(raza);

        } catch (SQLException ex) {
        }
        id_actualizar = id;
    }

    public void EliminarPaciente(String id) {

        String sSQL = "";
        String numero_paciente = "", nombre = "", color = "", fecha_nacimiento = "", especie = "", raza = "", sexo = "", rut_cliente = "";

        sSQL = "DELETE FROM paciente WHERE numero_paciente=" + id;

        try {
            Statement st = cn.createStatement();
            st.executeUpdate(sSQL);
            JOptionPane.showMessageDialog(null, "Se ha eliminado el paciente", "Proceso Éxitoso", JOptionPane.PLAIN_MESSAGE);
            z = 1;
            cargar_datos("");

        } catch (SQLException ex) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mn_editar = new javax.swing.JMenuItem();
        mn_editar2 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconsulta = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_mostrartodos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_rut = new javax.swing.JTextField();
        lbl_rutduenio = new javax.swing.JLabel();
        lbl_fechanac = new javax.swing.JLabel();
        lbl_especie = new javax.swing.JLabel();
        txt_especie = new javax.swing.JTextField();
        lbl_raza = new javax.swing.JLabel();
        txt_raza = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        txt_color = new javax.swing.JTextField();
        lbl_color = new javax.swing.JLabel();
        lbl_sexo = new javax.swing.JLabel();
        cbo_sexo = new javax.swing.JComboBox();
        txt_nombre = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        txt_fechanac = new com.toedter.calendar.JDateChooser();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Paciente"));

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

        lbl_buscar.setText("Ingrese Nombre Paciente");

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
                        .addGap(13, 13, 13)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mostrartodos)))
                .addContainerGap(31, Short.MAX_VALUE))
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Paciente"));

        txt_rut.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_rut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rutActionPerformed(evt);
            }
        });

        lbl_rutduenio.setText("Rut Dueño");
        lbl_rutduenio.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_rutduenio.setRequestFocusEnabled(false);

        lbl_fechanac.setText("Fecha Nacimiento");
        lbl_fechanac.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_fechanac.setRequestFocusEnabled(false);

        lbl_especie.setText("Especie");
        lbl_especie.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_especie.setRequestFocusEnabled(false);

        txt_especie.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_especie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_especieActionPerformed(evt);
            }
        });

        lbl_raza.setText("Raza");
        lbl_raza.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_raza.setRequestFocusEnabled(false);

        txt_raza.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_raza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_razaActionPerformed(evt);
            }
        });

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

        txt_color.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_colorActionPerformed(evt);
            }
        });

        lbl_color.setText("Color");
        lbl_color.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_color.setRequestFocusEnabled(false);

        lbl_sexo.setText("Sexo");
        lbl_sexo.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_sexo.setRequestFocusEnabled(false);

        cbo_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_sexoActionPerformed(evt);
            }
        });

        txt_nombre.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        lbl_nombre.setText("Nombre");
        lbl_nombre.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_nombre.setRequestFocusEnabled(false);

        txt_fechanac.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_nuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guardar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_rutduenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fechanac, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_fechanac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_color, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_rut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_especie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_raza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                .addGap(244, 244, 244))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rutduenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_color, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_salir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(206, 206, 206)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        z = 0;
        String busqueda_vacia = "Debes ingresar un paciente para realizar la bsqueda";
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

    private void txt_rutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rutActionPerformed
        txt_rut.transferFocus();
}//GEN-LAST:event_txt_rutActionPerformed

    private void txt_especieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_especieActionPerformed
        txt_especie.transferFocus();
}//GEN-LAST:event_txt_especieActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        habilitar();
        accion = "Insertar";
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        String nombre, color, fecha_nacimiento, especie, raza, sexo, rut_cliente;
        String sSQL = "";
        nombre = txt_nombre.getText();
        color = txt_color.getText();
        String mensaje = "";
        SimpleDateFormat formato_fecha;
        formato_fecha = new SimpleDateFormat("yyyy-MM-dd"); // formatear fecha
        //En date colocas tu getDate();
        fecha_nacimiento = formato_fecha.format(txt_fechanac.getDate()).toString();

        especie = txt_especie.getText();
        rut_cliente = txt_rut.getText();
        raza = txt_raza.getText();
        sexo = cbo_sexo.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null, fecha_nacimiento, "prueba", JOptionPane.PLAIN_MESSAGE);
        if (accion.equals("Insertar")) {

            sSQL = "INSERT INTO paciente (nombre, color, fecha_nacimiento, especie, raza, sexo, rut_cliente) VALUES(?, ? , ? , ?, ? , ?, ?)";

            mensaje = "Los datos se han insertado de manera satisfactoria";
            z = 1;
            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setString(1, nombre);
                pst.setString(2, color);
                pst.setString(3, fecha_nacimiento);
                pst.setString(4, especie);
                pst.setString(5, raza);
                pst.setString(6, sexo);
                pst.setString(7, rut_cliente);
                int n = pst.executeUpdate();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "Proceso Éxitoso", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            cargar_datos("");
        } else if (accion.equals("Modificar")) {
            sSQL = "UPDATE paciente SET nombre=?, color=?, fecha_nacimiento=?, especie=?, raza=?, sexo=?, rut_cliente=? WHERE numero_paciente=" + id_actualizar;
            mensaje = "Los datos se han modificado de manera satisfactoria";

            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setString(1, nombre);
                pst.setString(2, color);
                pst.setString(3, fecha_nacimiento);
                pst.setString(4, especie);
                pst.setString(5, raza);
                pst.setString(6, sexo);
                pst.setString(7, rut_cliente);
                int n = pst.executeUpdate();

                if (n > 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "Proceso Éxitoso", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            z = 0;
            cargar_datos(nombre);

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

    private void txt_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_colorActionPerformed
        txt_color.transferFocus();
}//GEN-LAST:event_txt_colorActionPerformed

    private void cbo_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_sexoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cbo_sexoActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        txt_nombre.transferFocus();
}//GEN-LAST:event_txt_nombreActionPerformed

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
                ModificarPaciente(id);


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
                accion = "Modificar";
                modelo = (DefaultTableModel) tablaconsulta.getModel();
                id = (String) modelo.getValueAt(filasel, 0);

                EliminarPaciente(id);


            }

        } catch (Exception e) {
        }
}//GEN-LAST:event_mn_editar2ActionPerformed

    private void txt_razaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_razaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_razaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_mostrartodos;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox cbo_sexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_color;
    private javax.swing.JLabel lbl_especie;
    private javax.swing.JLabel lbl_fechanac;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_raza;
    private javax.swing.JLabel lbl_rutduenio;
    private javax.swing.JLabel lbl_sexo;
    private javax.swing.JMenuItem mn_editar;
    private javax.swing.JMenuItem mn_editar2;
    private javax.swing.JTable tablaconsulta;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_especie;
    private com.toedter.calendar.JDateChooser txt_fechanac;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_raza;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
