package venda.visao;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import venda.controlador.ClienteDao;
import venda.controlador.ClienteDaoImpl;
import venda.controlador.EstoqueDao;
import venda.controlador.EstoqueDaoImpl;
import venda.controlador.PagamentoDao;
import venda.controlador.PagamentoDaoImpl;
import venda.controlador.VendaDao;
import venda.controlador.VendaDaoImpl;
import venda.modelo.Cliente;
import venda.modelo.Endereco;
import venda.modelo.Estoque;
import venda.modelo.ItemVenda;
import venda.modelo.Pagamento;
import venda.modelo.Venda;
import venda.utilitario.QuantidadeException;

public class VendaTela extends javax.swing.JInternalFrame {

    private final ClienteDao clienteDao = new ClienteDaoImpl();
    private final EstoqueDao estoqueDao = new EstoqueDaoImpl();
    private final PagamentoDao pagamentoDao = new PagamentoDaoImpl();
    private final VendaDao vendaDao = new VendaDaoImpl();
    private List<Estoque> estoques;
    private TreeSet<Cliente> clientes;
    private final ItemVendaDataTable itemVendaDataTable;
    private final Venda venda;
    private final TableModel table;

    public VendaTela(Venda venda, TableModel table) {
        initComponents();
        this.venda = venda;
        this.table = table;
        itemVendaDataTable = new ItemVendaDataTable(venda);
        inicialiazarComponentes();
        atualizarSubtotal();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbFormasPamento = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItensVenda = new javax.swing.JTable();
        jrParcelado = new javax.swing.JRadioButton();
        jrMixte = new javax.swing.JRadioButton();
        jrVista = new javax.swing.JRadioButton();
        jtEntradaMixter = new javax.swing.JTextField();
        jcParcelada = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jcClientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jbAdicionarCliente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jcMixte = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtStatus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtSubTotal = new javax.swing.JTextField();
        jtAdicionarItem = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jcProdutos = new javax.swing.JComboBox<>();
        jtQuantidadeProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jtItensVenda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtItensVenda);

        jbFormasPamento.add(jrParcelado);
        jrParcelado.setText("Parcelada");

        jbFormasPamento.add(jrMixte);
        jrMixte.setText("Mixte");
        jrMixte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMixteActionPerformed(evt);
            }
        });

        jbFormasPamento.add(jrVista);
        jrVista.setText("A vista");

        jcParcelada.setToolTipText("Quantidade de parcelas");

        jLabel2.setText("Pagamento");

        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcClientesActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente");

        jbAdicionarCliente.setText("Adicionar Cliente");
        jbAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarClienteActionPerformed(evt);
            }
        });

        jButton3.setText("Estornar");

        jcMixte.setToolTipText("Quantidade de parcelas");

        jLabel4.setText("Status");

        jtStatus.setEditable(false);

        jLabel5.setText("Total");

        jtTotal.setEditable(false);

        jLabel6.setText("Subtotal");

        jtSubTotal.setEditable(false);

        jtAdicionarItem.setText("Add item");
        jtAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtAdicionarItemActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);

        jTextField6.setEditable(false);

        jLabel7.setText("Quantidade");

        jButton2.setText("Excluir Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrVista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrParcelado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcParcelada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jrMixte)
                                        .addGap(8, 8, 8)
                                        .addComponent(jtEntradaMixter, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcMixte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAdicionarCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jLabel7))
                            .addComponent(jcProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtAdicionarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtAdicionarItem)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrVista)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrMixte)
                    .addComponent(jtEntradaMixter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcMixte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrParcelado)
                    .addComponent(jcParcelada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAdicionarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrMixteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMixteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrMixteActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        inicializarRadioButtons();
        inicializarJCClientes();
        inicializarJCProdutos();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jtAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtAdicionarItemActionPerformed
        Estoque estoque = estoques.get(jcProdutos.getSelectedIndex());
        estoque.getProduto();
        System.out.println(venda.getCodigo());
        int quantidade = Integer.parseInt(jtQuantidadeProduto.getText());
        try {
            itemVendaDataTable.adicionarLinha(new ItemVenda(venda, estoque.getProduto(), quantidade));
        } catch (QuantidadeException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade insuficiente em estoque!");
            Logger.getLogger(VendaTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jtAdicionarItemActionPerformed

    private void jcClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcClientesActionPerformed
        verificarQuantidadeParcelas((Cliente) jcClientes.getSelectedItem());
    }//GEN-LAST:event_jcClientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (carregarDadosPara(venda)) {
            vendaDao.atualizar(venda);
            criarPagamentos();
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarClienteActionPerformed

        String nome = JOptionPane.showInputDialog(this, "Nome cliente");
        String rg = JOptionPane.showInputDialog(this, "Número de RG");
        String rua = JOptionPane.showInputDialog(this, "Rua");
        String bairro = JOptionPane.showInputDialog(this, "Bairro");
        String estado = JOptionPane.showInputDialog(this, "Estado com 2 digitos");
        boolean fidelidade = false;

        if (JOptionPane.showConfirmDialog(this, "Plano de fidelidade?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            fidelidade = true;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setRg(rg);
        cliente.setPlanoDeFidelidade(fidelidade);
        Endereco endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setEstado(estado);
        cliente.setEndereco(endereco);

        new ClienteDaoImpl().criar(cliente);
        jcClientes.addItem(cliente);
        jcClientes.setSelectedItem(cliente);
    }//GEN-LAST:event_jbAdicionarClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jtItensVenda.getSelectedRow() != -1) {
            itemVendaDataTable.removeItemVenda(jtItensVenda.getSelectedRow());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void inicializarJCProdutos() {
        Iterator<Estoque> iterator = estoques.iterator();
        while (iterator.hasNext()) {
            jcProdutos.addItem(iterator.next().toString());
        }
    }

    @Override
    public void dispose() {
        if (itemVendaDataTable.getRowCount() == 0) {
            vendaDao.deletar(venda);
        }
        table.fireTableDataChanged();
        super.dispose();
    }

    private void inicializarJCClientes() {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            jcClientes.addItem(iterator.next());
        }
        verificarClienteVenda();
    }

    private void inicializarListas() {
        estoques = estoqueDao.disponiveis();
        clientes = new TreeSet<>(clienteDao.todos());
    }

    private void inicializarRadioButtons() {
        jrMixte.setActionCommand("mixter");
        jrParcelado.setActionCommand("parcelado");
        jrVista.setActionCommand("vista");
        verificarTipoVenda();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton jbAdicionarCliente;
    private javax.swing.ButtonGroup jbFormasPamento;
    private javax.swing.JComboBox<Cliente> jcClientes;
    private javax.swing.JComboBox<Integer> jcMixte;
    private javax.swing.JComboBox<Integer> jcParcelada;
    private javax.swing.JComboBox<String> jcProdutos;
    private javax.swing.JRadioButton jrMixte;
    private javax.swing.JRadioButton jrParcelado;
    private javax.swing.JRadioButton jrVista;
    private javax.swing.JButton jtAdicionarItem;
    private javax.swing.JTextField jtEntradaMixter;
    private javax.swing.JTable jtItensVenda;
    private javax.swing.JTextField jtQuantidadeProduto;
    private javax.swing.JTextField jtStatus;
    private javax.swing.JTextField jtSubTotal;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables

    private void verificarTipoVenda() {
        switch (venda.getTipo()) {
            case Venda.A_VISTA:
                jrVista.setSelected(true);
                break;
            case Venda.MIXTER:
                jrMixte.setSelected(true);
                break;
            case Venda.PARCELADA:
                jrParcelado.setSelected(true);
                break;
        }
    }

    private void verificarClienteVenda() {
        jcClientes.setSelectedItem(venda.getCliente());
        verificarQuantidadeParcelas((Cliente) jcClientes.getSelectedItem());
    }

    private void atualizarSubtotal() {
        BigDecimal subtotal = BigDecimal.valueOf(itemVendaDataTable.subTotal());
        subtotal.setScale(2);
        jtSubTotal.setText(subtotal.toString());
        jtTotal.setText(subtotal.toString());

        if (venda.getCliente().isPlanoDeFidelidade()) {
            subtotal = subtotal.multiply(BigDecimal.valueOf(0.9));
            jtTotal.setText(subtotal.toString());
        }
    }

    private void verificarStatusVenda() {
        jtStatus.setText(venda.verificarStatus().toString());
    }

    private void inicialiazarComponentes() {
        verificarStatusVenda();
        inicializarListas();
        jtItensVenda.setModel(itemVendaDataTable);
        itemVendaDataTable.addTableModelListener((TableModelEvent table) -> {
            atualizarSubtotal();
        });
    }

    private void verificarQuantidadeParcelas(Cliente cliente) {
        jcParcelada.removeAllItems();
        jcMixte.removeAllItems();

        opcoesPadroesPara(jcParcelada);
        opcoesPadroesPara(jcMixte);

        if (cliente.isPlanoDeFidelidade()) {
            jcMixte.addItem(5);
            jcMixte.addItem(6);
            jcParcelada.addItem(5);
            jcParcelada.addItem(6);
        }
    }

    private void opcoesPadroesPara(JComboBox<Integer> jc) {
        jc.addItem(1);
        jc.addItem(2);
        jc.addItem(3);
        jc.addItem(4);
    }

    private boolean carregarDadosPara(Venda venda) {
        venda.setCliente((Cliente) jcClientes.getSelectedItem());
        venda.setStatus(Venda.Status.FINALIZADO.toInt());
        if (!validarFormaDePagamento(
                jbFormasPamento.getSelection().getActionCommand())) {
            JOptionPane.showMessageDialog(this, "Verifique o valor de entrada!");
            return false;
        }
        if (!jbFormasPamento.getSelection().getActionCommand().equals("vista")
                && venda.getCliente().equals(ClienteDaoImpl.getClientePadrao())) {
            JOptionPane.showMessageDialog(this, "Venda diferente de a vista é necessario cadastro do cliente!");
            return false;
        }
        return true;
    }

    private boolean validarFormaDePagamento(String command) {
        if (command.equals("mixter")) {
            try {
                BigDecimal entrada = new BigDecimal(jtEntradaMixter.getText());
                BigDecimal total = new BigDecimal(jtTotal.getText());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private void criarPagamentos() {
        switch (jbFormasPamento.getSelection().getActionCommand()) {
            case "vista":
                pagamentoVista();
                break;

            case "mixter":
                pagamentoMixter();
                break;
            case "parcelado":
                pagamentoParcelado();
                break;
        }
    }

    public void pagamentoVista() {
        Pagamento pagamento = new Pagamento();
        pagamento.setVenda(venda);
        BigDecimal total = new BigDecimal(jtTotal.getText());
        pagamento.setValor(total);
        pagamento.setDataPagamento(new Date());
        pagamentoDao.criar(pagamento);
    }

    public void pagamentoMixter() {
        Pagamento pagamento = new Pagamento();
        pagamento.setVenda(venda);
        pagamento.setDataPagamento(new Date());

        BigDecimal total = new BigDecimal(jtTotal.getText());
        BigDecimal entrada = new BigDecimal(jtEntradaMixter.getText());
        total = total.subtract(entrada);

        pagamento.setValor(entrada);

        pagamentoDao.criar(pagamento);

        total = total.divide(BigDecimal.valueOf((int) jcMixte.getSelectedItem()), MathContext.DECIMAL32);
        pagamentoDao.criarParcelas(venda, total, (int) jcMixte.getSelectedItem());
    }

    public void pagamentoParcelado() {
        Pagamento pagamento = new Pagamento();
        pagamento.setVenda(venda);
        BigDecimal total = new BigDecimal(jtTotal.getText());
        pagamentoDao.criarParcelas(venda,
                total.divide(BigDecimal.valueOf((int) jcParcelada.getSelectedItem()), MathContext.DECIMAL32),
                (int) jcParcelada.getSelectedItem());
    }
}
