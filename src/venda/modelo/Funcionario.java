package venda.modelo;

public class Funcionario {
    
    public static Double INTEGRAL = 1000.0;
    
    Long codigo;
    private String nome;
    int quantidadeFaltas;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeFaltas() {
        return quantidadeFaltas;
    }

    public void setQuantidadeFaltas(int quantidadeFaltas) {
        this.quantidadeFaltas = quantidadeFaltas;
    }
    
    public double receberPagamento(){
        return Funcionario.INTEGRAL - (quantidadeFaltas*10);
    }
}
