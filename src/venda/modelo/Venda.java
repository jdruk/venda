package venda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Venda {

    public final static int A_VISTA = 0;
    public final static int MIXTER = 1;
    public final static int PARCELADA = 2;
    
    public Venda() {
    }

    private Venda(Builder builder) {
    }

    public BigDecimal getValorTotal() {
        return BigDecimal.ZERO;
//        return itensVenda.stream().map(
//                x -> x.getValorVenda().multiply(
//                        BigDecimal.valueOf(x.getQuantidade())))
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static enum Status {
        ABERTO(0), FINALIZADO(1), ESTORNADO(2), PAGO(3);
        private final int code;

        private Status(int code) {
            this.code = code;
        }

        public int toInt() {
            return code;
        }

    }
    
    public Status verificarStatus(){
        switch(status){
            case 0:
                return Status.ABERTO;
            case 1:
                return Status.FINALIZADO;
            case 2:
                return Status.ESTORNADO;
            case 3:
                return Status.PAGO;    
        }
        return null;
    }

    public boolean estornar() {
        LocalDate dataVenda = this.data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (LocalDate.now().minusDays(7).isBefore(dataVenda)) {
            status = Status.ESTORNADO.toInt();
            return true;
        }

        return false;
    }

    public static class Builder {

        private final int codigo;
        private Date data;
        private List<ItemVenda> itensVenda;
        private int status;
        private final Cliente cliente;
        private List<Pagamento> pagamentos;
        private int tipo;
        private BigDecimal desconto;

        public Builder(int codigo, Cliente cliente) {
            this.codigo = codigo;
            this.cliente = cliente;
        }

        public Builder comStatus(Status status) {
            this.status = status.toInt();
            return this;
        }

        public Builder data(Date data) {
            this.data = data;
            return this;
        }

        public Builder tipo(int tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder descontoDe(BigDecimal desconto) {
            this.desconto = desconto;
            return this;
        }

        public Builder itemDaVenda(List<ItemVenda> itens) {
            this.itensVenda = itens;
            return this;
        }

        public Builder pagamentos(List<Pagamento> pagamentos) {
            this.pagamentos = pagamentos;
            return this;
        }

        public Venda build() {
            return new Venda(this);
        }

    }

    private int codigo;
    private Date data;
    private List<ItemVenda> itensVenda;
    private int status;
    private Cliente cliente;
    private List<Pagamento> pagamentos;
    private int tipo;
    private BigDecimal desconto;

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamento(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static void main(String[] args) {
        Venda venda = new Venda.Builder(0, new Cliente())
                .descontoDe(new BigDecimal(2))
                .comStatus(Status.ABERTO)
                .build();

    }

    public String toString(){
        return codigo + " data:" + data;
    }
}
