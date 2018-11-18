package venda.visao;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import venda.modelo.*;
import venda.controlador.*;


public class ItemVendaDataTable extends AbstractTableModel{

    private Venda venda;
    private ItemVendaDao itemVendaDao = new ItemVendaDaoImpl();
    private List<ItemVenda> itens;
    private String[] colunas = {"Nome", "Preço", "Quantidade", "Valor"};
            
    public ItemVendaDataTable(Venda venda){
        super();
        itens = itemVendaDao.todos(venda);
    }
    
    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
    
    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return itens.get(linha).getProduto().getNome();
            case 1:
                return itens.get(linha).getProduto().getValor();
            case 2:
                return itens.get(linha).getQuantidade();
            case 3:
                return itens.get(linha).getProduto().getValor().multiply(new BigDecimal(itens.get(linha).getQuantidade()));
        }
        return null;
    }
    
    public void adicionarLinha(ItemVenda itemVenda){
        if(itens.contains(itemVenda)){
            int index = itens.indexOf(itemVenda);
            itens.get(index)
                    .setQuantidade(itemVenda.getQuantidade());
            itemVendaDao.atualizar(itens.get(index));
                    
        }else {
            itemVendaDao.criar(itemVenda);
            itens = itemVendaDao.todos(venda);
        }
        this.fireTableDataChanged();
    }
    
    public void removeItemVenda(int linha){
        itemVendaDao.deletar(itens.get(linha));
        itens.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
