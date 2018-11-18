package venda.controlador;

import java.util.List;
import venda.modelo.ItemVenda;
import venda.modelo.Venda;
import venda.utilitario.QuantidadeException;

public interface ItemVendaDao {
    
    void criar(ItemVenda itemVenda)  throws QuantidadeException;

    void deletar(ItemVenda itemVenda);

    void atualizar(ItemVenda itemVenda)  throws QuantidadeException;

    ItemVenda buscar(int codigo);

    public List<ItemVenda> todos(Venda venda);
    
}
