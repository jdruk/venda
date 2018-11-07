package venda.controlador;

import java.util.List;
import venda.modelo.Estoque;

public interface EstoqueDao {

    void criar(Estoque estoque);

    void deletar(Estoque estoque);

    void atualizar(Estoque estoque);

    Estoque buscar(int codigo);

    List<Estoque> todos();
}
