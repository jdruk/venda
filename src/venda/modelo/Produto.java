package venda.modelo;

import java.math.BigDecimal;

public class Produto {

    private Integer codigo;
    private String nome;
    private BigDecimal valor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{ codigo: " + codigo
                + ", nome: " + nome
                + ", valor: " + valor + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Produto produto = (Produto) obj;
        return codigo != null ? codigo.equals(produto.getCodigo()) : produto.getCodigo() == null;
    }

}
