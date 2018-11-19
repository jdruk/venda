package venda.visao;

import java.math.BigDecimal;
import java.util.List;
import venda.modelo.*;
import venda.controlador.*;
import venda.utilitario.QuantidadeException;

public class ItemVendaDataTable extends TableModel {

    private final Venda venda;
    private final ItemVendaDao itemVendaDao = new ItemVendaDaoImpl();
    private List<ItemVenda> itens;

    public ItemVendaDataTable(Venda venda) {
        this.venda = venda;
        itens = itemVendaDao.todos(venda);
        colunas = new String[]{"Nome", "Preço", "Quantidade", "Valor"};
    }

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
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

    public void adicionarLinha(ItemVenda itemVenda) throws QuantidadeException {
        itemVendaDao.criar(itemVenda);
        itens = itemVendaDao.todos(venda);
        this.fireTableDataChanged();
    }

    public void removeItemVenda(int linha) {
        itemVendaDao.deletar(itens.get(linha));
        itens.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Double subTotal(){
        Double subtotal = 0.0;
        for (int i = 0; i < itens.size(); i++) {
            subtotal += itens.get(i).getProduto().getValor().multiply(new BigDecimal(itens.get(i).getQuantidade())).doubleValue();
        }
        return subtotal;
    }

}
