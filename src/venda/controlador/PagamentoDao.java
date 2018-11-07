package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Cliente;
import venda.modelo.Pagamento;

public interface PagamentoDao {
    
    void criar(Pagamento pagamento);

    void deletar(Pagamento pagamento);

    void atualizar(Pagamento pagamento);

    Pagamento buscar(Pagamento pagamento);

    ArrayList<Pagamento> todas(Cliente cliente);
}
