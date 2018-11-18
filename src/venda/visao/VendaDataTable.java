/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.visao;

import java.util.List;
import venda.controlador.*;
import venda.modelo.Venda;

public class VendaDataTable extends TableModel {
    
    private VendaDao vendaDao = new VendaDaoImpl();
    private  List<Venda> vendas = vendaDao.todas(); 
    
    public VendaDataTable(){
        colunas = new String[]{"Nome", "Valor", "Data", "Status"};
    }

    @Override
    public int getRowCount() {
        return vendas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return vendas.get(linha).getCliente().getNome();
            case 1:
                return vendas.get(linha).getValorTotal();
            case 2:
                return vendas.get(linha).getData();
            case 3:
                return vendas.get(linha).verificarStatus();
        }
        return null;
    }
    
    public void excluirLinha(int selectedRow) {
        vendaDao.deletar(vendas.get(selectedRow));
        this.vendas.remove(selectedRow);
        this.fireTableRowsDeleted(selectedRow, selectedRow);
    }
    
    public void adicionarLinha() {
        vendas = vendaDao.todas();
        this.fireTableDataChanged();
    }

    public Venda pegarVenda(int linha) {
        return vendas.get(linha);
    }
    
}
