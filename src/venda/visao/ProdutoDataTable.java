package venda.visao;

import java.util.List;
import venda.modelo.Estoque;
import venda.controlador.EstoqueDaoImpl;
import venda.controlador.EstoqueDao;
import venda.controlador.ProdutoDao;
import venda.controlador.ProdutoDaoImpl;

public class ProdutoDataTable extends TableModel{

    private EstoqueDao estoqueDao = new EstoqueDaoImpl();
    private ProdutoDao produtoDao = new ProdutoDaoImpl();
    private List<Estoque> itens = estoqueDao.todos();

    public ProdutoDataTable() {
        colunas = new String[]{"Nome", "Preço", "Quantidade"};
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
        }
        return null;
    }
    
    public void adicionarLinha() {
        itens = estoqueDao.todos();
        this.fireTableDataChanged();
    }

    public void excluirLinha(int selectedRow) {
        produtoDao.deletar(itens.get(selectedRow).getProduto());
        this.itens.remove(selectedRow);
        this.fireTableRowsDeleted(selectedRow, selectedRow);
    }

    public Estoque pegarEstoque(int linha) {
        return itens.get(linha);
    }
    
}
