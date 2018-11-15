package venda.visao;

import java.math.BigDecimal;
import venda.controlador.*;
import venda.modelo.Estoque;

public class ProdutoTela extends javax.swing.JInternalFrame {

    private Estoque estoque;
    private ProdutoDataTable produtoTable;
    private EstoqueDao estoqueDao = new EstoqueDaoImpl();
    private ProdutoDao produtoDao = new ProdutoDaoImpl();
    
    private ProdutoTela() {
        initComponents();
    }
    
    public ProdutoTela(Estoque estoque, ProdutoDataTable produtoTable){
        this();    
        this.estoque = estoque;
        this.produtoTable = produtoTable;
        carregarEstoqueParaCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtQuantidade = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Nome");

        jLabel2.setText("Preço");

        jLabel3.setText("Qtd");

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalvar)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jbSalvar)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        carregarCamposParaEstoque(); 
        if(estoque.getCodigo() == 0){
            produtoDao.criar(estoque);
         }else{
            produtoDao.atualizar(estoque);
         }
        produtoTable.adicionarLinha();
        dispose();
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void carregarEstoqueParaCampos() {
        if(estoque.getCodigo() != 0){
            jtNome.setText(estoque.getProduto().getNome());
            jtPreco.setText(estoque.getProduto().getValor().toString());
            jtQuantidade.setText(estoque.getQuantidade() + "");
        }
        produtoTable.adicionarLinha();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtPreco;
    private javax.swing.JTextField jtQuantidade;
    // End of variables declaration//GEN-END:variables

    private void carregarCamposParaEstoque() {
        estoque.setQuantidade(Integer.parseInt(jtQuantidade.getText()));
        estoque.getProduto().setNome(jtNome.getText());
        System.out.println("FF");
        estoque.getProduto().setValor(new BigDecimal(jtPreco.getText()));
    }
}
