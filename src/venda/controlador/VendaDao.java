package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Venda;

public interface VendaDao {
    Venda criar(Venda venda);
    void deletar(Venda venda);
    void atualizar(Venda venda);
    Venda buscar(int codigo);
    ArrayList<Venda> todas();
}
