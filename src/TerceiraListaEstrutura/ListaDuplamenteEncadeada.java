package TerceiraListaEstrutura;

public class ListaDuplamenteEncadeada {

    public Bloco inicio;

    public Bloco addBloco(int valor, boolean isInicio){

        if (isInicio) {
            return addBlocoInicio (valor);
        }else {
            return addBlocoFim (valor);
        }

    }

    public Bloco addBlocoInicio (int valor) {
        Bloco novo = new Bloco();
        novo.valor = valor;

        if (this.isVazia()) {
            this.inicio = novo;
        }else {
            novo.prox = this.inicio;
            this.inicio = novo;
        }

        return novo;
    }

    public Bloco addBlocoFim (int valor) {

        if (isVazia()) {

            return addBlocoInicio(valor);

        }else {
            Bloco novo = new Bloco();
            novo.valor = valor;
            Bloco aux = this.inicio;

            while (aux.prox != null) {
                aux = aux.prox;
            }

            aux.prox = novo;
    
            return novo;
        }
   
    }
    
    public Bloco removerBloco (Bloco refBloco) {
        if (isVazia()) {
            return null;
        }

        if (refBloco == this.inicio) {
            this.inicio = null;
            return refBloco;
        }

        Bloco aux = this.inicio;

        while (aux != null && aux.prox != refBloco) {
            aux = aux.prox;
        }

        aux.prox = null;

        return refBloco;
    }

    public Bloco localizarValor(int valor) {
        Bloco aux = this.inicio;
        
            while (aux != null && aux.valor != valor){

                aux = aux.prox;

            }

            return aux;
        }

    public Boolean isVazia(){
        return this.inicio == null;
    }

    public void printLista() {
        Bloco blocoAux = this.inicio;
        while (blocoAux != null) {
            System.out.println(blocoAux.valor);
            blocoAux = blocoAux.prox;
        }
    }
}
