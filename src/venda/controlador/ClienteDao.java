package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Cliente;

public interface ClienteDao {
    
    void criar(Cliente cliente);
    void deletar(Cliente cliente);
    void atualizar(Cliente cliente);
    Cliente buscar(int cliente);
    public ArrayList<Cliente> todas();
}
