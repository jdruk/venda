package venda.controlador;

import java.util.List;
import venda.modelo.Estoque;
import venda.modelo.Produto;

public interface EstoqueDao {

    void criar(Estoque estoque);

    void deletar(Estoque estoque);

    void atualizar(Estoque estoque);

    Estoque buscar(int codigo);
    
    Estoque buscar(Produto p);

    List<Estoque> todos();
    
    List<Estoque> disponiveis();
}
