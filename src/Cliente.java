public class Cliente {
   private String codigo;
   private String cpf;
   private String nome;

    public Cliente(String codigo, String cpf, String nome){
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
    }
   
public String getCodigo() {
    return codigo;
}
public void setCodigo(String codigo) {
    this.codigo = codigo;
}
public String getCpf() {
    return cpf;
}
public void setCpf(String cpf) {
    this.cpf = cpf;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
}
