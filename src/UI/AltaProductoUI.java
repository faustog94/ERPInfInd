/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.ArticuloController;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author franco-lxle
 */
public class AltaProductoUI extends javax.swing.JFrame {

    //Instancia de la clase que da soporte a la interfaz
    AltaProductoHelper helper = new AltaProductoHelper();

    /**
     * Creates new form AltaArticuloUI
     */
    public AltaProductoUI() {
        initComponents();

        //Por defecto activo debe estar seleccionado
        chb_activo.setSelected(true);
        //Obtengo las instancias de los tipos que existen y las añado al selector
        cb_productos.addItem("Ninguno");
        ArrayList<String> productos = helper.getProductosBase();
        for (int i = 0; i < productos.size(); i++) {
            cb_productos.addItem(productos.get(i));
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

        lbl_codArticulo = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_activo = new javax.swing.JLabel();
        lbl_unidadMedida = new javax.swing.JLabel();
        lbl_prodPadre = new javax.swing.JLabel();
        cb_productos = new javax.swing.JComboBox<>();
        chb_activo = new javax.swing.JCheckBox();
        txt_codArticulo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_unidadMedida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_darAlta = new javax.swing.JButton();
        lbl_prodBase = new javax.swing.JLabel();
        chb_prodBase = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_codArticulo.setText("Código del producto");

        lbl_descripcion.setText("Descripcion");

        lbl_activo.setText("Activo");

        lbl_unidadMedida.setText("Unidad de Medida");

        lbl_prodPadre.setText("Producto padre");

        cb_productos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        chb_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_activoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Alta de Producto");

        btn_darAlta.setText("OK");
        btn_darAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_darAltaMouseClicked(evt);
            }
        });

        lbl_prodBase.setText("Es producto base?");

        chb_prodBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_prodBaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_prodPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_darAlta)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_codArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addComponent(txt_codArticulo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_unidadMedida)
                                    .addComponent(lbl_activo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_prodBase))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chb_activo)
                                    .addComponent(chb_prodBase)
                                    .addComponent(txt_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_productos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(146, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_activo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chb_activo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_unidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btn_darAlta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chb_prodBase)
                            .addComponent(lbl_prodBase))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_prodPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chb_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_activoActionPerformed
    }//GEN-LAST:event_chb_activoActionPerformed

    private void btn_darAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_darAltaMouseClicked
        String codProducto = txt_codArticulo.getText();
        String descripcion = txt_descripcion.getText();
        boolean activo = chb_activo.isSelected();
        String unidadMedida = txt_unidadMedida.getText();
        int idTipoProducto;
        if (chb_prodBase.isSelected()) {
            idTipoProducto = 1;
        } else {
            idTipoProducto = 2;
        }
        int idProductoBase;
        if (cb_productos.getSelectedIndex() != 0 && cb_productos.isEnabled()){ // Solo en el caso de que tenga un producto padre (cbProductos este activado) y no esté seleccionado "Ninguno", buscamos el ID
            idProductoBase = helper.getIdProductoPadre((String) cb_productos.getSelectedItem());
        }else {
            idProductoBase = 0;
        }

        if (!codProducto.isEmpty() && !descripcion.isEmpty() && !unidadMedida.isEmpty()) {
            helper.darAlta(codProducto, descripcion, activo, unidadMedida, idTipoProducto, idProductoBase);
            JOptionPane.showMessageDialog(this, "Alta satisfactoria");
        } else {
            JOptionPane.showMessageDialog(this, "Faltan campos por completar");
        }
    }//GEN-LAST:event_btn_darAltaMouseClicked

    private void chb_prodBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_prodBaseActionPerformed
        if (chb_prodBase.isSelected()) {
            cb_productos.setEnabled(false);
        } else {

            cb_productos.setEnabled(true);
        }
    }//GEN-LAST:event_chb_prodBaseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_darAlta;
    private javax.swing.JComboBox<String> cb_productos;
    private javax.swing.JCheckBox chb_activo;
    private javax.swing.JCheckBox chb_prodBase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_activo;
    private javax.swing.JLabel lbl_codArticulo;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_prodBase;
    private javax.swing.JLabel lbl_prodPadre;
    private javax.swing.JLabel lbl_unidadMedida;
    private javax.swing.JTextField txt_codArticulo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_unidadMedida;
    // End of variables declaration//GEN-END:variables
}
