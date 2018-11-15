package venda.controlador;

import java.util.List;
import venda.modelo.Estoque;
import venda.modelo.Produto;

public interface ProdutoDao {

    void criar(Produto produto);
    
    void criar(Estoque estoque);

    void deletar(Produto produto);

    void atualizar(Produto produto);
    
    void atualizar(Estoque produto);

    Produto buscar(Integer codigo);
    
    

    List<Produto> todos();
}
