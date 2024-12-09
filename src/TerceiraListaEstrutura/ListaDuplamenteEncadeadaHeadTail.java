package TerceiraListaEstrutura;

public class ListaDuplamenteEncadeadaHeadTail {
    public Bloco header;
    public Bloco tail;

    public Bloco addBlocoHeadTail (int valor, boolean isInicio) {

        if (isInicio) {
            return addBlocoHeadTailInicio(valor);
        }else {
            return addBlocoHeadTailFim (valor);
        }
    }

    public Bloco addBlocoHeadTailInicio (int valor) {
        Bloco novo = new Bloco();
        novo.valor = valor;

        if (this.header == null) {
            this.header = this.tail = novo;
            this.header.prox = this.header.ant = this.tail.prox = this.tail.ant = novo;
            return novo;
        }

        novo.prox = this.header;
        this.header.ant = novo;
        novo.ant = this.tail;
        this.header = novo;
        this.tail.prox = novo;

        return novo;
    }

    public Bloco addBlocoHeadTailFim (int valor) {

        if (this.header == null) {
            return addBlocoHeadTailInicio(valor);
        }

        Bloco novo = new Bloco();
        novo.valor = valor;

        Bloco aux = this.header;

        while (aux.prox != this.header) {
            aux = aux.prox;
        }

        aux.prox = novo;
        novo.ant = aux;
        novo.prox = this.header;
        this.tail = novo;

        return novo;
    }
}
