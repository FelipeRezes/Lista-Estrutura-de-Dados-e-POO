package TerceiraListaEstrutura;

public class ListaSimplesmenteDupla {

    Bloco inicio;

    public Bloco addBlocoSD (int valor, boolean isInicio) {

        if (isInicio) {
            return addBlocoSDInicio (valor);
        }else{
            return addBlocoSDFim (valor);
        }
    }
 
    private Bloco addBlocoSDInicio (int valor) {
        
        if (this.inicio == null) {
            return null;
        }

        Bloco novo = new Bloco();
        novo.valor = valor;
        
        novo.prox = this.inicio;
        this.inicio = novo;


        return novo;
    }

    private Bloco addBlocoSDFim (int valor) {

        if (this.inicio == null) {
            return null;
        }

        Bloco novo = new Bloco();
        novo.valor = valor;

        Bloco aux = this.inicio;

        while (aux.prox != null) {
            aux = aux.prox;
        }

        aux.prox = novo;

        return novo;
    }

    public Bloco getAnt (Bloco refBloco) {

        if (this.inicio == null) {
            return null;
        }

        Bloco aux = this.inicio;

        while (aux != null && aux.prox != refBloco) {
            aux = aux.prox;
        }

        return aux;
    }

    public void printListaSD () {

        Bloco aux = this.inicio;

        while (aux != null) {
            System.out.println(aux.valor);
            aux = aux.prox;
        }

    } 
}
