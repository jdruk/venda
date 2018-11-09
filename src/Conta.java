public class Conta {
    
    private String nome;
    private String senha;
    private String email;
    
    private Conta(Builder builder){
        this.email = builder.email;
        this.nome = builder.nome;
        this.senha = builder.senha;
    }
    
    public static class Builder{
        
        private String nome;
        private String senha;
        private String email;
        
        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }
        
        public Builder email(String email){
            this.email = email;
            return this;
        }
        
        public Builder senha(String senha){
            this.senha = senha;
            return this;
        }
        
        public Conta build(){
            return new Conta(this);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public static void main(String[] args) {
        Conta conta = new Conta.Builder().email("email")
                .nome("nome")
                .senha("senha")
                .build();
        
        System.out.println(conta.getEmail());
    }
}
