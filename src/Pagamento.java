public class Pagamento {
    private double valor;
    private Cliente cl;

    public Pagamento(double valor, Cliente cl){
        this.valor = valor;
        this.cl = cl;
    }

    public double getValor() {
        return valor;
    }
    public String getValorTexto() {
        return String.valueOf(valor);
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Cliente getCl() {
        return cl;
    }
    public void setCl(Cliente cl) {
        this.cl = cl;
    }
}
