package venda.modelo;

public class Endereco {

    private int codigo;
    private String rua;
    private String bairro;
    private String estado;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco(){}
    
    public Endereco(int codigo, String rua, String bairro, String estado, Cliente cliente) {
        this.codigo = codigo;
        this.rua = rua;
        this.bairro = bairro;
        this.estado = estado;
        this.cliente = cliente;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return this.rua + ", " + this.bairro + " - " + this.estado ;
    }
}
