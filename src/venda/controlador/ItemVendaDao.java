package venda.controlador;

import java.util.List;
import venda.modelo.ItemVenda;

public interface ItemVendaDao {
    
    void criar(ItemVenda itemVenda);

    void deletar(ItemVenda itemVenda);

    void atualizar(ItemVenda itemVenda);

    ItemVenda buscar(int codigo);

    List<ItemVenda> todos();
    
}