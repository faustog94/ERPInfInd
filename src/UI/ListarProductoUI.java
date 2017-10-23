package UI;

import Models.Articulo;
import Models.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yair
 */
public class ListarProductoUI extends javax.swing.JFrame {

    //Instancia de la clase helper
    ListarProductoHelper helper = new ListarProductoHelper();
    //Articulos
    ArrayList<Producto> productos;
    //Estado de los filtros
    boolean soloActivos;
    boolean soloProdBase;
    int tipoFiltro;
    DefaultTableModel tmodel;

    public ListarProductoUI() {
        initComponents();
        productos = helper.obtenerProductos();
        soloActivos = false;
        soloProdBase = false;
        //prueba tabla
        tmodel = (DefaultTableModel) tb_articulos.getModel();
        poblarTabla();
        tb_articulos.setModel(tmodel);
        //   
    }

    private void poblarTabla() {
        tmodel.setRowCount(0);
        if (soloProdBase == true){
            tipoFiltro = 1;
        }
        else{
            tipoFiltro = 0;
        }
        for (Producto prod : productos) {
            if (soloActivos == false || soloActivos == prod.isActivo()){
                if (tipoFiltro == 0 || tipoFiltro == prod.getIdTipoProducto()){
                    String padre = (prod.getIdProductoBase() != 0 ? helper.obtenerPadre(prod.getIdProductoBase()) : "-");
                    int idProducto = prod.getIdProducto();
                    Object[] row = new Object[]{prod.getCodProducto(), prod.getDescripcion(), prod.isActivo(), prod.getUnidadMedida(), helper.tieneEstructura(idProducto), helper.tieneRuta(idProducto), helper.obtenerDescTipo(prod.getIdTipoProducto()), padre};
                    tmodel.addRow(row);
                    tb_articulos.setModel(tmodel);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_articulos = new javax.swing.JTable();
        chb_soloActivos = new javax.swing.JCheckBox();
        chb_prodBase = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Lista de productos");

        btn_salir.setText("Salir");
        btn_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salirMouseClicked(evt);
            }
        });

        tb_articulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripcion", "Activo", "Unidad de Medida", "Tiene estructura", "Tiene ruta", "Tipo", "Padre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_articulos.setColumnSelectionAllowed(true);
        tb_articulos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_articulos);
        tb_articulos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tb_articulos.getColumnModel().getColumnCount() > 0) {
            tb_articulos.getColumnModel().getColumn(0).setResizable(false);
            tb_articulos.getColumnModel().getColumn(1).setResizable(false);
            tb_articulos.getColumnModel().getColumn(2).setResizable(false);
            tb_articulos.getColumnModel().getColumn(3).setResizable(false);
            tb_articulos.getColumnModel().getColumn(4).setResizable(false);
            tb_articulos.getColumnModel().getColumn(5).setResizable(false);
            tb_articulos.getColumnModel().getColumn(6).setResizable(false);
            tb_articulos.getColumnModel().getColumn(7).setResizable(false);
        }

        chb_soloActivos.setText("Solo activos");
        chb_soloActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chb_soloActivosMouseClicked(evt);
            }
        });

        chb_prodBase.setText("Solo productos base");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chb_soloActivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chb_prodBase))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_salir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(chb_soloActivos)
                    .addComponent(chb_prodBase))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_salir))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salirMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_salirMouseClicked

    private void chb_soloActivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chb_soloActivosMouseClicked
        soloActivos = chb_soloActivos.isSelected();
        poblarTabla();
    }//GEN-LAST:event_chb_soloActivosMouseClicked

    private void chb_prodBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_prodBaseActionPerformed
        soloProdBase = chb_prodBase.isSelected();
        poblarTabla();
    }//GEN-LAST:event_chb_prodBaseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salir;
    private javax.swing.JCheckBox chb_prodBase;
    private javax.swing.JCheckBox chb_soloActivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_articulos;
    // End of variables declaration//GEN-END:variables
}
