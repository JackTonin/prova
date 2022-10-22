public class Produto {
    private String codigo;
    private String nome;
    private double valor;
    private int estoque; 

    public Produto() {

    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Código: " + this.getCodigo()+ "\nNome: " + this.getNome()+ "\nValor: "
        + this.getValor()+ "\nQuantidade em estoque: " + getEstoque();
    }

}
