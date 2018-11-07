package venda.controlador;

import venda.modelo.Cliente;
import venda.modelo.Endereco;

public interface EnderecoDao {
    
    void criar(Endereco endereco);

    void deletar(Endereco endereco);

    void atualizar(Endereco endereco);

    Endereco buscar(Cliente cliente);
}
