package venda.visao;

import javax.swing.JOptionPane;
import venda.controlador.*;
import venda.modelo.Venda;

public class VendaPrincipal extends javax.swing.JInternalFrame {

    private final VendaDataTable vendaDataTable;
    private final VendaDao vendaDao = new VendaDaoImpl();

    public VendaPrincipal() {
        initComponents();
        vendaDataTable = new VendaDataTable();
        jtVenda.setModel(vendaDataTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtVenda = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbEstornar = new javax.swing.JButton();
        jbPagamento = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);
        setResizable(true);

        jtVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtVenda);

        jButton1.setText("Nova");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbEstornar.setText("Estornar");
        jbEstornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstornarActionPerformed(evt);
            }
        });

        jbPagamento.setText("Pagamento");
        jbPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jbPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEstornar)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jbEstornar)
                    .addComponent(jbPagamento))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VendaTela vendaNova = new VendaTela(VendaDaoImpl.getVendaInstancePadrao(), vendaDataTable);
        this.getDesktopPane().add(vendaNova);
        vendaNova.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbEstornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstornarActionPerformed
        if (jtVenda.getSelectedRow() != -1) {
            Venda venda = vendaDataTable.pegarVenda(jtVenda.getSelectedRow());
            if (venda.estornar()) {
                vendaDao.atualizar(venda);
                JOptionPane.showMessageDialog(this, "Estornado com sucesso!");
                vendaDataTable.adicionarLinha();
            } else {
                JOptionPane.showMessageDialog(this, "Não é possível estornar... \nprazo de 7 dias expirado!");
            }

        }
    }//GEN-LAST:event_jbEstornarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jtVenda.getSelectedRow() != -1) {
            Venda venda = vendaDataTable.pegarVenda(jtVenda.getSelectedRow());
            if (venda.getStatus() == Venda.Status.ABERTO.toInt()) {
                VendaTela vendaAlterar = new VendaTela(venda, vendaDataTable);
                this.getDesktopPane().add(vendaAlterar);
                vendaAlterar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Venda \nfinalizada \npaga ou \nestornada não pode ser alterada!");
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPagamentoActionPerformed
        if (jtVenda.getSelectedRow() != -1) {
            Venda venda = vendaDataTable.pegarVenda(jtVenda.getSelectedRow());
            if(venda.getStatus() == Venda.Status.FINALIZADO.toInt()){
                PagamentoTela pagamento = new PagamentoTela(venda);
                this.getDesktopPane().add(pagamento);
                pagamento.setVisible(true);
            }
        }
    }//GEN-LAST:event_jbPagamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEstornar;
    private javax.swing.JButton jbPagamento;
    private javax.swing.JTable jtVenda;
    // End of variables declaration//GEN-END:variables
}
