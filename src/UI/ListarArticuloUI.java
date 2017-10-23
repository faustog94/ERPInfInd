package UI;

import Models.Articulo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yair
 */
public class ListarArticuloUI extends javax.swing.JFrame {

    //Instancia de la clase helper
    ListarArticuloHelper helper = new ListarArticuloHelper();
    //Articulos
    ArrayList<Articulo> articulos;
    //Estado de los filtros
    boolean soloActivos;
    int tipoFiltro;
    DefaultTableModel tmodel;

    public ListarArticuloUI() {
        initComponents();
        articulos = helper.obtenerArticulos();
        soloActivos = false;
        tipoFiltro = 0;
        //prueba tabla
        tmodel = (DefaultTableModel) tb_articulos.getModel();
        poblarTabla();
        tb_articulos.setModel(tmodel);
        //   
        
        List<String> filtros = Arrays.asList("Todo", "Materia Prima", "Productos componentes", "Productos en proceso de elaboración");
        for (String filtro : filtros) {
            cb_filtro.addItem(filtro);
        }
    }

    private void poblarTabla() {
        tmodel.setRowCount(0);
        for (Articulo art : articulos) {
            if (tipoFiltro == 0 || tipoFiltro == art.getIdTipoArticulo()) {
                if (soloActivos == false || soloActivos == art.isActivo()) {
                    Object[] row = new Object[]{art.getCodArticulo(), art.getDescripcion(), art.isActivo(), art.getUnidadMedida(), helper.obtenerDescTipo(art.getIdTipoArticulo())};
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
        jLabel2 = new javax.swing.JLabel();
        cb_filtro = new javax.swing.JComboBox<>();
        chb_soloActivos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Lista de artículos");

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
                "Código", "Descripcion", "Activo", "Unidad de Medida", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
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
        }

        jLabel2.setText("Filtrar:");

        cb_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        cb_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_filtroActionPerformed(evt);
            }
        });

        chb_soloActivos.setText("Solo activos");
        chb_soloActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chb_soloActivosMouseClicked(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_salir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cb_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chb_soloActivos))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void cb_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_filtroActionPerformed
        tipoFiltro = cb_filtro.getSelectedIndex();
        poblarTabla();
    }//GEN-LAST:event_cb_filtroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> cb_filtro;
    private javax.swing.JCheckBox chb_soloActivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_articulos;
    // End of variables declaration//GEN-END:variables
}
