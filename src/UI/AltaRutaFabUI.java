package UI;

import Models.CentroTrabajo;
import Models.DetalleRuta;
import Models.Estructura;
import Models.Materiales;
import Models.Producto;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yair
 */
public class AltaRutaFabUI extends javax.swing.JFrame {

    //Instancia del Helper
    AltaRutaFabHelper helper = new AltaRutaFabHelper();
    //Instancia de producto
    Producto prod;
    //Model de la tabla
    DefaultTableModel tmodelDet;
    //Versiones Estructuras
    ArrayList<String> verEstr;
    //Instancias de Estructura correspondiente al producto y la versión elegida.
    public HashMap<Integer, Estructura> estructuras = new HashMap<Integer, Estructura>();
    //Respaldo completo de estructuras
    public HashMap<Integer, Estructura> estructurasRespaldo = new HashMap<Integer, Estructura>();
    //
    String versionElegida = "";
    //
    int orden;
    //Instancias de CentroTrabajo disponibles
    public ArrayList<CentroTrabajo> centrosDisponibles;
    //HashMap para mantener un ArrayList de Materiales a partir del orden
    public HashMap<Integer, ArrayList<Materiales>> detallesMateriales = new HashMap<Integer, ArrayList<Materiales>>();
    //HashMap para mapear los DetalleRuta a partir del orden
    public HashMap<Integer, DetalleRuta> detallesRuta = new HashMap<Integer, DetalleRuta>();

    public AltaRutaFabUI() {
        initComponents();
        centrosDisponibles = helper.obtenerCentrosTrabajo();
        orden = 1;
        lbl_descproducto.setText("");
        for (int i = 1; i < 32; i++) {
            cb_dia.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cb_mes.addItem(String.valueOf(i));
        }
        for (int i = 0; i < 3; i++) {
            cb_año.addItem(String.valueOf(i + 2017));
        }
        chb_activa.setSelected(true);

        tmodelDet = (DefaultTableModel) tb_detalles.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonAlta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_codProducto = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        lbl_descproducto = new javax.swing.JLabel();
        chb_activa = new javax.swing.JCheckBox();
        txt_version = new javax.swing.JTextField();
        cb_mes = new javax.swing.JComboBox<>();
        cb_dia = new javax.swing.JComboBox<>();
        cb_año = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_detalles = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cb_versiones = new javax.swing.JComboBox<>();
        btn_agregar = new javax.swing.JButton();
        btn_sacar = new javax.swing.JButton();
        btn_subir = new javax.swing.JButton();
        btn_bajar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Alta de Ruta de Fabricación");

        jLabel4.setText("Versión");

        jLabel5.setText("Vigente desde");

        botonAlta.setText("Dar alta");
        botonAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAltaMouseClicked(evt);
            }
        });

        jLabel6.setText("Código de producto");

        btn_buscar.setText("Buscar");
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarMouseClicked(evt);
            }
        });

        lbl_descproducto.setText("placeholder");

        chb_activa.setText("Activa");

        cb_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        cb_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        cb_año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        tb_detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden", "Centro de Trabajo", "Horas Mano Obra", "Horas Máquina", "Horas Reposo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_detalles.setColumnSelectionAllowed(true);
        tb_detalles.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_detalles);
        tb_detalles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tb_detalles.getColumnModel().getColumnCount() > 0) {
            tb_detalles.getColumnModel().getColumn(0).setResizable(false);
            tb_detalles.getColumnModel().getColumn(1).setResizable(false);
            tb_detalles.getColumnModel().getColumn(2).setResizable(false);
            tb_detalles.getColumnModel().getColumn(3).setResizable(false);
            tb_detalles.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setText("Versión de Estructura");

        cb_versiones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        cb_versiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_versionesActionPerformed(evt);
            }
        });

        btn_agregar.setText("+");
        btn_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregarMouseClicked(evt);
            }
        });

        btn_sacar.setText("-");

        btn_subir.setText("subir");

        btn_bajar.setText("bajar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_codProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_descproducto)
                        .addGap(206, 206, 206))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_sacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_subir)
                                        .addComponent(btn_bajar))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cb_versiones, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(chb_activa)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txt_version, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(cb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAlta)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_codProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar)
                    .addComponent(lbl_descproducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_versiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_version, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chb_activa)
                    .addComponent(jLabel5)
                    .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sacar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_subir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_bajar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAlta)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        String codProducto = txt_codProducto.getText();
        if (codProducto.isEmpty()) { //no se ha colocado un cod
            JOptionPane.showMessageDialog(this, "Ingrese un código");
        } else { //Hay código
            if (helper.codigoExiste(codProducto)) { // El código existe
                prod = helper.buscarProducto(codProducto);
                lbl_descproducto.setText(prod.getDescripcion());
                verEstr = helper.buscarVersiones(prod.getIdProducto());
                if (verEstr.size() == 0) { //Si no hay versiones falla
                    JOptionPane.showMessageDialog(this, "El producto no tiene estructuras activas");
                    return;
                }
                cb_versiones.addItem("Elija una estructura...");
                for (String version : verEstr) {
                    cb_versiones.addItem(version);
                }
            } else { // El código no existe
                JOptionPane.showMessageDialog(this, "El código ingresado no existe");
            }
        }
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void cb_versionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_versionesActionPerformed
        if (cb_versiones.getSelectedIndex() == 0) {
            versionElegida = "";
            //do nothing
            return;
        }
        versionElegida = String.valueOf(cb_versiones.getSelectedItem());
        estructuras.clear();
        estructurasRespaldo.clear();
        ArrayList<Estructura> estrs = helper.obtenerEstructurasVersion(prod.getIdProducto(), versionElegida);
        for (Estructura est : estrs) {
            estructuras.put(est.getIdEstructura(), est);
            estructurasRespaldo.put(est.getIdEstructura(), est);
        }
        if (prod.getIdProductoBase() != 0) {
            ArrayList<Estructura> estrPadre = helper.obtenerEstructurasActivas(prod.getIdProductoBase());
            for (Estructura est : estrPadre) {
                estructuras.put(est.getIdEstructura(), est);
                estructurasRespaldo.put(est.getIdEstructura(), est);
            }
        }
    }//GEN-LAST:event_cb_versionesActionPerformed

    private void btn_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseClicked
        if (prod == null) {
            JOptionPane.showMessageDialog(this, "Debe buscar un producto");
            return;
        }

        if (versionElegida.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una versión de estructura");
            return;
        }
        new AltaRutaFabUI2(this, true).setVisible(true);
    }//GEN-LAST:event_btn_agregarMouseClicked

    private void botonAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAltaMouseClicked
        if (prod == null) {
            JOptionPane.showMessageDialog(this, "Debe buscar un producto");
            return;
        }

        if (versionElegida.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una versión de estructura");
            return;
        }

        if (txt_version.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe introducir una versión");
            return;
        }

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int año = localDate.getYear();
        int mes = localDate.getMonthValue();
        int dia = localDate.getDayOfMonth();
        if (Integer.valueOf((String) cb_año.getSelectedItem()) <= año) {
            if (Integer.valueOf((String) cb_mes.getSelectedItem()) <= mes) {
                if (Integer.valueOf((String) cb_dia.getSelectedItem()) <= dia) {
                    JOptionPane.showMessageDialog(this, "Debe introducir una fecha posterior a la actual");
                    return;
                }
            }
        }
        if (orden == 1) {
            JOptionPane.showMessageDialog(this, "Debe agregar pasos a la ruta");
            return;
        }
        
        String fechaVigencia = (String) cb_dia.getSelectedItem() + "/" + (String) cb_mes.getSelectedItem() + "/" + cb_año.getSelectedItem();
        //Guardo RutaFabricación
        helper.altaRutaFab(chb_activa.isSelected(), txt_version.getText(), fechaVigencia, prod.getIdProducto());
        int idRuta = helper.obtenerUltimoIdRuta();
        //Guardo Detalles y sus n materiales
        for (Integer orden : detallesRuta.keySet()) {
            DetalleRuta det = detallesRuta.get(orden);
            helper.altaDetalleRuta(det.getOrden(), det.getTiempoManoObra(), det.getTiempoMaquina(), det.getTiempoReposo(), idRuta, det.getIdCentro());
            int idDetalleRuta = helper.obtenerUltimoIdDetalleRuta();
            ArrayList<Materiales> materiales = detallesMateriales.get(orden);
            for (Materiales mat : materiales) {
                //int cantidad, int idDetalleRuta, int idArticulo, int idTipoMateriales
                helper.altaMateriales(mat.getCantidad(), idDetalleRuta, mat.getIdArticulo(), mat.getIdTipoMateriales());
            }
        }

        JOptionPane.showMessageDialog(this, "Alta satisfactoria");
        dispose();

    }//GEN-LAST:event_botonAltaMouseClicked

    public void poblarTablaDetalles() {
        tmodelDet.setRowCount(0);
        //orden, centro, horas MO, horas maq, horas reposo
        //for (ArrayList<Materiales> matAL : detallesRuta.values()) {
        for (DetalleRuta det : detallesRuta.values()) {
            int orden = det.getOrden();
            String descCentro = helper.obtenerDescCentro(det.getIdCentro());
            double horasMO = det.getTiempoManoObra();
            double horasMaq = det.getTiempoMaquina();
            double horasRep = det.getTiempoReposo();
            Object[] row = new Object[]{orden, descCentro, horasMO, horasMaq, horasRep};
            tmodelDet.addRow(row);
        }
        tb_detalles.setModel(tmodelDet);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_bajar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_sacar;
    private javax.swing.JButton btn_subir;
    private javax.swing.JComboBox<String> cb_año;
    private javax.swing.JComboBox<String> cb_dia;
    private javax.swing.JComboBox<String> cb_mes;
    private javax.swing.JComboBox<String> cb_versiones;
    private javax.swing.JCheckBox chb_activa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_descproducto;
    private javax.swing.JTable tb_detalles;
    private javax.swing.JTextField txt_codProducto;
    private javax.swing.JTextField txt_version;
    // End of variables declaration//GEN-END:variables
}
