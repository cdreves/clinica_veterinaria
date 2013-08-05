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
public class FormularioCliente extends javax.swing.JInternalFrame {

    int z;
    DefaultTableModel modelo;
    String id_actualizar = "";
    String accion = "";

    DatabaseConnection mysql = new DatabaseConnection();
    Connection cn = mysql.getConnection();
    
    static Logger logger = Logger.getLogger(FormularioCliente.class);
    
    /** Creates new form prueba */
    /** Creates new form formulariocliente */
    public FormularioCliente() {
        initComponents();
        z = 1;
        //cargar_datos("");
        inhabilitar();
        limpiar();
        inhabilitarPaciente();
        limpiarPaciente();
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
    void habilitarPaciente() {
        txt_nombre2.setEnabled(true);
        txt_rut2.setEnabled(true);
        txt_color.setEnabled(true);
        txt_fechanac.setEnabled(true);
        txt_especie.setEnabled(true);
        txt_raza.setEnabled(true);
        cbo_sexo.setEnabled(true);
        btn_guardar2.setEnabled(true);
        btn_cancelar.setEnabled(true);


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

        void inhabilitarPaciente() {
        txt_nombre2.setEnabled(false);
        txt_rut2.setEnabled(false);
        txt_color.setEnabled(false);
        txt_fechanac.setEnabled(false);
        txt_especie.setEnabled(false);
        txt_raza.setEnabled(false);
        cbo_sexo.setEnabled(false);
        btn_guardar2.setEnabled(false);
        btn_cancelar.setEnabled(false);

    }

    public void limpiarPaciente() {
        txt_nombre2.setText("");
        txt_rut2.setText("");
        txt_color.setText("");
        txt_fechanac.setDate(null);
        txt_especie.setText("");
        txt_raza.setText("");

    }
    public void cargar_datos(String valor) {
        int k = 0;
        String[] titulos = {"Rut", "Nombre", "Dirección", "Teléfono", "E-Mail"};
        String[] registro = new String[5];
        String sSQL = "";
        modelo = new DefaultTableModel(null, titulos);

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
        PropertyConfigurator.configure("log4j.properties");
        
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
        mn_eliminar_registro = new javax.swing.JMenuItem();
        mn_agregar_paciente = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txt_rut = new javax.swing.JTextField();
        lbl_rutduenio = new javax.swing.JLabel();
        lbl_especie = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_raza = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
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
        btn_salir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txt_rut2 = new javax.swing.JTextField();
        lbl_rutduenio2 = new javax.swing.JLabel();
        lbl_fechanac = new javax.swing.JLabel();
        lbl_especie2 = new javax.swing.JLabel();
        txt_especie = new javax.swing.JTextField();
        lbl_raza2 = new javax.swing.JLabel();
        txt_raza = new javax.swing.JTextField();
        btn_guardar2 = new javax.swing.JButton();
        btn_cancelar2 = new javax.swing.JButton();
        txt_color = new javax.swing.JTextField();
        lbl_color = new javax.swing.JLabel();
        lbl_sexo2 = new javax.swing.JLabel();
        cbo_sexo = new javax.swing.JComboBox();
        txt_nombre2 = new javax.swing.JTextField();
        lbl_nombre2 = new javax.swing.JLabel();
        txt_fechanac = new com.toedter.calendar.JDateChooser();

        mn_editar.setText("Modificar");
        mn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_editarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mn_editar);

        mn_eliminar_registro.setText("Eliminar");
        mn_eliminar_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_eliminar_registroActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mn_eliminar_registro);

        mn_agregar_paciente.setText("Agregar Paciente");
        mn_agregar_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_agregar_pacienteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mn_agregar_paciente);

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

        lbl_rutduenio.setText("Rut Dueño");
        lbl_rutduenio.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_rutduenio.setRequestFocusEnabled(false);

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
                            .addComponent(lbl_sexo, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_rutduenio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_especie, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_raza, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txt_rut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btn_nuevo)
                        .addGap(38, 38, 38)
                        .addComponent(btn_guardar)
                        .addGap(43, 43, 43)
                        .addComponent(btn_cancelar)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rutduenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbl_raza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nuevo)
                    .addComponent(btn_guardar)
                    .addComponent(btn_cancelar))
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

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btn_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_mostrartodos)
                        .addGap(18, 18, 18)
                        .addComponent(btn_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mostrartodos)
                    .addComponent(btn_buscar)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salir))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Paciente"));

        txt_rut2.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_rut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rut2ActionPerformed(evt);
            }
        });

        lbl_rutduenio2.setText("Rut Dueño");
        lbl_rutduenio2.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_rutduenio2.setRequestFocusEnabled(false);

        lbl_fechanac.setText("Fecha Nacimiento");
        lbl_fechanac.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_fechanac.setRequestFocusEnabled(false);

        lbl_especie2.setText("Especie");
        lbl_especie2.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_especie2.setRequestFocusEnabled(false);

        txt_especie.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_especie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_especieActionPerformed(evt);
            }
        });

        lbl_raza2.setText("Raza");
        lbl_raza2.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_raza2.setRequestFocusEnabled(false);

        txt_raza.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_raza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_razaActionPerformed(evt);
            }
        });

        btn_guardar2.setText("Guardar");
        btn_guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar2ActionPerformed(evt);
            }
        });

        btn_cancelar2.setText("Cancelar");
        btn_cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar2ActionPerformed(evt);
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

        lbl_sexo2.setText("Sexo");
        lbl_sexo2.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_sexo2.setRequestFocusEnabled(false);

        cbo_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_sexoActionPerformed(evt);
            }
        });

        txt_nombre2.setPreferredSize(new java.awt.Dimension(120, 20));
        txt_nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre2ActionPerformed(evt);
            }
        });

        lbl_nombre2.setText("Nombre");
        lbl_nombre2.setPreferredSize(new java.awt.Dimension(60, 14));
        lbl_nombre2.setRequestFocusEnabled(false);

        txt_fechanac.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btn_guardar2)
                .addGap(18, 18, 18)
                .addComponent(btn_cancelar2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fechanac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_especie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_raza2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_sexo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_rutduenio2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_raza, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(cbo_sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_nombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_color, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_fechanac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_especie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_rut2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(199, 199, 199))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rutduenio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_especie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_raza2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sexo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar2)
                    .addComponent(btn_cancelar2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        String nombre, rut_cliente, direccion, telefono, mail;
        String sSQL = "";
        nombre = txt_nombre.getText();
        mail = txt_mail.getText();
        String mensaje = "";
        direccion = txt_direccion.getText();
        rut_cliente = txt_rut.getText();
        telefono = txt_telefono.getText();
        PropertyConfigurator.configure("log4j.properties");
        
        if (accion.equals("Insertar")) {

            sSQL = "INSERT INTO cliente(rut_cliente, nombre, direccion, telefono, mail) VALUES(?, ? , ? , ? ,?)";

            mensaje = "Los datos del cliente han insertado de manera satisfactoria";
            z = 1;
            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setString(1, rut_cliente);
                pst.setString(2, nombre);
                pst.setString(3, direccion);
                pst.setString(4, telefono);
                pst.setString(5, mail);
                int n = pst.executeUpdate();
                //JOptionPane.showMessageDialog(null, n, "Advertencia", JOptionPane.PLAIN_MESSAGE);
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "Proceso Éxitoso", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            cargar_datos("");
        } else if (accion.equals("Modificar")) {
            sSQL = "UPDATE cliente SET rut_cliente=?, nombre=?, direccion=?, telefono=?, mail=? WHERE rut_cliente='" + id_actualizar +"'";
            
            mensaje = "Los datos se han modificado de manera satisfactoria";

            try {
                PreparedStatement pst = cn.prepareStatement(sSQL);
                pst.setString(1, rut_cliente);
                pst.setString(2, nombre);
                pst.setString(3, direccion);
                pst.setString(4, telefono);
                pst.setString(5, mail);
                int n = pst.executeUpdate();
                logger.info("Se esta ejecutando sentencia SQL: "+pst);
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "Proceso Exitoso de Actualización cliente de rut: "+id_actualizar, JOptionPane.PLAIN_MESSAGE);
                    logger.info("Se ha actualizado correctamente el registro");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
                logger.info("Ha ocurrido un error al tratar de actualizar cliente");
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
        String busqueda_vacia = "Debes ingresar el rut de un cliente, para realizar la búsqueda";
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

    private void mn_eliminar_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_eliminar_registroActionPerformed
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
}//GEN-LAST:event_mn_eliminar_registroActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void mn_agregar_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_agregar_pacienteActionPerformed
        habilitarPaciente();
        accion = "Insertar";
        FormularioPaciente formularioPaciente = new FormularioPaciente();
        int filasel;
        String id;

        try {
            filasel = tablaconsulta.getSelectedRow();
            if (filasel == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione Algun paciente a Eliminar", "Advertencia", JOptionPane.PLAIN_MESSAGE);
            } else {
                modelo = (DefaultTableModel) tablaconsulta.getModel();
                id = (String) modelo.getValueAt(filasel, 0);
                AgregarPaciente(id);
                //EliminarCliente(id);


            }

        } catch (Exception e) {
        }      
    }//GEN-LAST:event_mn_agregar_pacienteActionPerformed

    private void txt_nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre2ActionPerformed
        txt_nombre.transferFocus();
    }//GEN-LAST:event_txt_nombre2ActionPerformed

    private void cbo_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_sexoActionPerformed

    private void txt_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_colorActionPerformed
        txt_color.transferFocus();
    }//GEN-LAST:event_txt_colorActionPerformed

    private void btn_cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar2ActionPerformed
        inhabilitarPaciente();
        limpiarPaciente();
    }//GEN-LAST:event_btn_cancelar2ActionPerformed

    private void btn_guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar2ActionPerformed

        String nombre, color, fecha_nacimiento, especie, raza, sexo, rut_cliente;
        String sSQL = "";
        nombre = txt_nombre2.getText();
        rut_cliente= txt_rut2.getText();
        color = txt_color.getText();
        String mensaje = "";
        SimpleDateFormat formato_fecha;
        formato_fecha = new SimpleDateFormat("yyyy-MM-dd"); // formatear fecha
        //En date colocas tu getDate();
        fecha_nacimiento = formato_fecha.format(txt_fechanac.getDate()).toString();

        especie = txt_especie.getText();
        raza = txt_raza.getText();
        sexo = cbo_sexo.getSelectedItem().toString();
        //JOptionPane.showMessageDialog(null, fecha_nacimiento, "prueba", JOptionPane.PLAIN_MESSAGE);
        if (accion.equals("Insertar")) {

            sSQL = "INSERT INTO paciente (nombre, color, fecha_nacimiento, especie, raza, sexo, rut_cliente) VALUES(?, ? , ? , ?, ? , ?, ?)";

            mensaje = "Los datos se han insertado de manera satisfactoria";

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
                    JOptionPane.showMessageDialog(null, mensaje, "Proceso Éxitoso de inserción Paciente", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }

        inhabilitarPaciente();
        limpiarPaciente();
    }//GEN-LAST:event_btn_guardar2ActionPerformed

    private void txt_razaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_razaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_razaActionPerformed

    private void txt_especieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_especieActionPerformed
        txt_especie.transferFocus();
    }//GEN-LAST:event_txt_especieActionPerformed

    private void txt_rut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rut2ActionPerformed
        txt_rut.transferFocus();
    }//GEN-LAST:event_txt_rut2ActionPerformed
public void AgregarPaciente(String id){
       txt_rut2.setText(id);
       txt_rut2.setEnabled(false);
       cbo_sexo.addItem("Macho");
       cbo_sexo.addItem("Hembra");
       accion= "Insertar";
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_cancelar2;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_guardar2;
    private javax.swing.JButton btn_mostrartodos;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox cbo_sexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_color;
    private javax.swing.JLabel lbl_especie;
    private javax.swing.JLabel lbl_especie2;
    private javax.swing.JLabel lbl_fechanac;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_raza;
    private javax.swing.JLabel lbl_raza2;
    private javax.swing.JLabel lbl_rutduenio;
    private javax.swing.JLabel lbl_rutduenio2;
    private javax.swing.JLabel lbl_sexo;
    private javax.swing.JLabel lbl_sexo2;
    private javax.swing.JMenuItem mn_agregar_paciente;
    private javax.swing.JMenuItem mn_editar;
    private javax.swing.JMenuItem mn_eliminar_registro;
    private javax.swing.JTable tablaconsulta;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_especie;
    private com.toedter.calendar.JDateChooser txt_fechanac;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre2;
    private javax.swing.JTextField txt_raza;
    private javax.swing.JTextField txt_rut;
    private javax.swing.JTextField txt_rut2;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
