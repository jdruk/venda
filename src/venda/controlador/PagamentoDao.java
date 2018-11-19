package venda.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;
import venda.modelo.Pagamento;
import venda.modelo.Venda;

public interface PagamentoDao {
    
    void criar(Pagamento pagamento);

    void deletar(Pagamento pagamento);

    void atualizar(Pagamento pagamento);

    Pagamento buscar(int pagamento);

    ArrayList<Pagamento> todas(Venda cliente);
    
    void deletarTodos(Venda venda);
    
    void criarParcelas(Venda venda, BigDecimal valor, int quantidade );
}
