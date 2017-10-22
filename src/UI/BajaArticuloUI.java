
package UI;

import Models.Articulo;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair
 */
public class BajaArticuloUI extends javax.swing.JFrame {
    
    //Instancia de la clase que da soporte a la interfaz
    BajaArticuloHelper helper = new BajaArticuloHelper();
    //Instancia de Articulo
    Articulo art;

    public BajaArticuloUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_articulo = new javax.swing.JTable();
        btn_bajaArticulo = new javax.swing.JButton();
        txt_codArticulo = new javax.swing.JTextField();
        btn_buscarArt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Baja de artículo");

        jLabel2.setText("Código de artículo:");

        tb_articulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Descripción", "Unidad medida", "Activo", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb_articulo);
        if (tb_articulo.getColumnModel().getColumnCount() > 0) {
            tb_articulo.getColumnModel().getColumn(0).setResizable(false);
            tb_articulo.getColumnModel().getColumn(1).setResizable(false);
            tb_articulo.getColumnModel().getColumn(2).setResizable(false);
            tb_articulo.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_bajaArticulo.setText("Aceptar");
        btn_bajaArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bajaArticuloMouseClicked(evt);
            }
        });
        btn_bajaArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bajaArticuloActionPerformed(evt);
            }
        });

        btn_buscarArt.setText("Buscar");
        btn_buscarArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarArtMouseClicked(evt);
            }
        });
        btn_buscarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarArtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_bajaArticulo)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_codArticulo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscarArt)
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscarArt))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btn_bajaArticulo)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarArtActionPerformed
        // TODO add your handling code here:
        //Boton buscar que se conecta con la BD del ERP
    }//GEN-LAST:event_btn_buscarArtActionPerformed

    private void btn_bajaArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bajaArticuloActionPerformed
    }//GEN-LAST:event_btn_bajaArticuloActionPerformed

    private void btn_buscarArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarArtMouseClicked
        String codArticulo = txt_codArticulo.getText();
        if (codArticulo.isEmpty()) { //no se ha colocado un cod
            JOptionPane.showMessageDialog(this, "Ingrese un código");
        } else { //Hay código
            if (helper.codigoExiste(codArticulo)) { // El código existe
                art = helper.buscarArticulo(codArticulo);
                if (art.isActivo()) {
                    tb_articulo.setValueAt(art.getDescripcion(), 0, 0);
                    tb_articulo.setValueAt(art.getUnidadMedida(), 0, 1);
                    tb_articulo.setValueAt(art.isActivo(), 0, 2);
                    String descTipo = helper.obtenerDescTipo(art.getIdTipoArticulo());
                    tb_articulo.setValueAt(descTipo, 0, 3);
                } else {
                    JOptionPane.showMessageDialog(this, "El artículo ya está inactivo");
                }

            } else { // El código no existe
                JOptionPane.showMessageDialog(this, "El código ingresado no existe");
            }
        }
    }//GEN-LAST:event_btn_buscarArtMouseClicked

    private void btn_bajaArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bajaArticuloMouseClicked
        if (art == null) {
            JOptionPane.showMessageDialog(this, "No hay un artículo buscado");
            return;
        }
        
        if (!helper.articuloTieneEstructurasActivas(art.getIdArticulo())){
            helper.bajaArticulo(art.getIdArticulo());
            JOptionPane.showMessageDialog(this, "Baja satisfactoria");
        } else {
            JOptionPane.showMessageDialog(this, "El artículo tiene estructuras activas");
        }
    }//GEN-LAST:event_btn_bajaArticuloMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bajaArticulo;
    private javax.swing.JButton btn_buscarArt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_articulo;
    private javax.swing.JTextField txt_codArticulo;
    // End of variables declaration//GEN-END:variables
}
