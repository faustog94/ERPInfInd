/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author franco
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        //Interfaces no disponibles
        btn_estrModificacion.setEnabled(false);
        btn_rutaBaja.setEnabled(false);
        btn_rutaModificacion.setEnabled(false);
        btn_rutaListar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        btn_artBaja = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_artAlta = new javax.swing.JButton();
        btn_artModificacion = new javax.swing.JButton();
        btn_artListar = new javax.swing.JButton();
        btn_prodBaja = new javax.swing.JButton();
        btn_prodAlta = new javax.swing.JButton();
        btn_prodModificacion = new javax.swing.JButton();
        btn_prodListar = new javax.swing.JButton();
        btn_estrBaja = new javax.swing.JButton();
        btn_estrAlta = new javax.swing.JButton();
        btn_estrModificacion = new javax.swing.JButton();
        btn_estrListar = new javax.swing.JButton();
        btn_rutaBaja = new javax.swing.JButton();
        btn_rutaAlta = new javax.swing.JButton();
        btn_rutaModificacion = new javax.swing.JButton();
        btn_rutaListar = new javax.swing.JButton();

        jButton13.setText("jButton1");

        jButton14.setText("jButton1");

        jButton15.setText("jButton1");

        jButton16.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_artBaja.setText("Baja");
        btn_artBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_artBajaMouseClicked(evt);
            }
        });

        jLabel1.setText("Artículo");

        jLabel2.setText("Producto");

        jLabel3.setText("Estructura");

        jLabel4.setText("Ruta");

        btn_artAlta.setText("Alta");
        btn_artAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_artAltaMouseClicked(evt);
            }
        });

        btn_artModificacion.setText("Modificacion");
        btn_artModificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_artModificacionMouseClicked(evt);
            }
        });

        btn_artListar.setText("Listar");
        btn_artListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_artListarMouseClicked(evt);
            }
        });

        btn_prodBaja.setText("Baja");
        btn_prodBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prodBajaMouseClicked(evt);
            }
        });

        btn_prodAlta.setText("Alta");
        btn_prodAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prodAltaMouseClicked(evt);
            }
        });

        btn_prodModificacion.setText("Modificacion");
        btn_prodModificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prodModificacionMouseClicked(evt);
            }
        });

        btn_prodListar.setText("Listar");
        btn_prodListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prodListarMouseClicked(evt);
            }
        });

        btn_estrBaja.setText("Baja");
        btn_estrBaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_estrBajaMouseClicked(evt);
            }
        });

        btn_estrAlta.setText("Alta");
        btn_estrAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_estrAltaMouseClicked(evt);
            }
        });

        btn_estrModificacion.setText("Modificacion");

        btn_estrListar.setText("Listar");
        btn_estrListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_estrListarMouseClicked(evt);
            }
        });

        btn_rutaBaja.setText("Baja");

        btn_rutaAlta.setText("Alta");
        btn_rutaAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rutaAltaMouseClicked(evt);
            }
        });

        btn_rutaModificacion.setText("Modificacion");

        btn_rutaListar.setText("Listar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btn_prodAlta)
                            .addComponent(btn_prodBaja)
                            .addComponent(btn_prodModificacion)
                            .addComponent(btn_prodListar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(btn_estrAlta)
                            .addComponent(btn_estrBaja)
                            .addComponent(btn_estrModificacion)
                            .addComponent(btn_estrListar))
                        .addGap(91, 91, 91))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_artAlta)
                    .addComponent(btn_artBaja)
                    .addComponent(btn_artModificacion)
                    .addComponent(btn_artListar)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_rutaAlta)
                            .addComponent(btn_rutaBaja)
                            .addComponent(btn_rutaModificacion)
                            .addComponent(btn_rutaListar))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_artAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_artBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_artModificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_artListar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_prodAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_prodBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_prodModificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_prodListar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_estrAlta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_estrBaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_estrModificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_estrListar)))
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rutaAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rutaBaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rutaModificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rutaListar)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_artAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_artAltaMouseClicked
        new AltaArticuloUI().setVisible(true);
    }//GEN-LAST:event_btn_artAltaMouseClicked

    private void btn_artBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_artBajaMouseClicked
        new BajaArticuloUI().setVisible(true);
    }//GEN-LAST:event_btn_artBajaMouseClicked

    private void btn_artModificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_artModificacionMouseClicked
        new ModificarArticuloUI().setVisible(true);
    }//GEN-LAST:event_btn_artModificacionMouseClicked

    private void btn_artListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_artListarMouseClicked
        new ListarArticuloUI().setVisible(true);
    }//GEN-LAST:event_btn_artListarMouseClicked

    private void btn_prodAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prodAltaMouseClicked
        new AltaProductoUI().setVisible(true);
    }//GEN-LAST:event_btn_prodAltaMouseClicked

    private void btn_prodBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prodBajaMouseClicked
        new BajaProductoUI().setVisible(true);
    }//GEN-LAST:event_btn_prodBajaMouseClicked

    private void btn_prodModificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prodModificacionMouseClicked
        new ModificarProductoUI().setVisible(true);
    }//GEN-LAST:event_btn_prodModificacionMouseClicked

    private void btn_prodListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prodListarMouseClicked
        new ListarProductoUI().setVisible(true);
    }//GEN-LAST:event_btn_prodListarMouseClicked

    private void btn_estrAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_estrAltaMouseClicked
        new AltaEstructuraUI().setVisible(true);
    }//GEN-LAST:event_btn_estrAltaMouseClicked

    private void btn_estrBajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_estrBajaMouseClicked
        new BajaEstructuraUI().setVisible(true);
    }//GEN-LAST:event_btn_estrBajaMouseClicked

    private void btn_estrListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_estrListarMouseClicked
        new ListarEstructurasUI().setVisible(true);
    }//GEN-LAST:event_btn_estrListarMouseClicked

    private void btn_rutaAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rutaAltaMouseClicked
        new AltaRutaFabUI().setVisible(true);
    }//GEN-LAST:event_btn_rutaAltaMouseClicked

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_artAlta;
    private javax.swing.JButton btn_artBaja;
    private javax.swing.JButton btn_artListar;
    private javax.swing.JButton btn_artModificacion;
    private javax.swing.JButton btn_estrAlta;
    private javax.swing.JButton btn_estrBaja;
    private javax.swing.JButton btn_estrListar;
    private javax.swing.JButton btn_estrModificacion;
    private javax.swing.JButton btn_prodAlta;
    private javax.swing.JButton btn_prodBaja;
    private javax.swing.JButton btn_prodListar;
    private javax.swing.JButton btn_prodModificacion;
    private javax.swing.JButton btn_rutaAlta;
    private javax.swing.JButton btn_rutaBaja;
    private javax.swing.JButton btn_rutaListar;
    private javax.swing.JButton btn_rutaModificacion;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
