import java.util.Comparator;

public class ComparadorValor implements Comparator<Pagamento> {

    @Override
    public int compare(Pagamento o1, Pagamento o2) {
        return o1.getValorTexto().compareTo(o2.getValorTexto());
    }
    
}
