package venda.controlador;

import java.util.List;
import venda.modelo.Produto;

public interface ProdutoDao {

    void criar(Produto produto);

    void deletar(Produto produto);

    void atualizar(Produto produto);

    Produto buscar(Integer codigo);

    List<Produto> todos();
}
