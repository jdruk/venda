package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Pagamento;
import venda.modelo.Parcela;

public interface ParcelaDao {

    void criar(Parcela parcela);

    void deletar(Parcela parcela);

    void atualizar(Parcela parcela);

    Parcela buscar(Parcela parcela);

    ArrayList<Parcela> todas(Pagamento pagamento);
}
