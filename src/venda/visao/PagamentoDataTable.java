package venda.visao;

import java.util.List;
import venda.controlador.PagamentoDao;
import venda.controlador.PagamentoDaoImpl;
import venda.modelo.Pagamento;
import venda.modelo.Venda;

public class PagamentoDataTable extends TableModel{
    
    private final Venda venda;
    private final PagamentoDao pagamentoDao = new PagamentoDaoImpl();
    private final List<Pagamento> pagamentos;
    
    public PagamentoDataTable(Venda venda){
        this.venda = venda;
        pagamentos = pagamentoDao.todas(venda);
        colunas = new String[] {"Data", "Valor", "Paga"};
    }

    @Override
    public int getRowCount() {
        return pagamentos.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return pagamentos.get(linha).getDataPagamento();
            case 1:
                return pagamentos.get(linha).getValor();
            case 2:
                return pagamentos.get(linha).isPago() ?  "Pagamento efetuado" : "em débito" ;
        }
        return null;
    }
    
    public void pagar(int linha){
        pagamentos.get(linha).setPago(true);
        pagamentoDao.atualizar(pagamentos.get(linha));
        this.fireTableDataChanged();
    }
    
    public void estornar(int linha){
        pagamentos.get(linha).setPago(false);
        pagamentoDao.atualizar(pagamentos.get(linha));
        this.fireTableDataChanged();
    }
}
