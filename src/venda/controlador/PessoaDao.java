package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Pessoa;

public interface PessoaDao {
    
    void criar(Pessoa pessoa);
    void deletar(Pessoa pessoa);
    void atualizar(Pessoa pessoa);
    Pessoa buscar(int codigo);
    ArrayList<Pessoa> todas();
}
