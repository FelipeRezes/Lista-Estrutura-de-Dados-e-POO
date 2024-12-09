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

    public Bloco removerBlocoHeadTail (Bloco refBloco) {

        if (this.header == null) {

            return null;

        }else if (refBloco == this.header) {

            this.header = null;
            return refBloco;

        }else if (refBloco == this.tail) {

            Bloco aux = this.tail.ant;
            this.tail = aux;
            this.tail.prox = this.header;

            return refBloco;
        }

        Bloco aux = this.header;

        while (aux.prox != refBloco) {
            aux = aux.prox;
        }

        aux.prox = aux.prox.prox;

        return refBloco;
    }
    
    public Bloco localizarBlocoHeadTail (int valor) {

        if (this.header == null) {
            return null;
        }

        if (this.header.valor == valor) {
            return this.header;
        }else if(this.tail.valor == valor) {
            return this.tail;
        }

        Bloco aux = this.header;
        while (aux.valor != valor) {
            aux = aux.prox;
        }

        return aux;
    }

    public void printListaHeadTail() {

        Bloco blocoAux = this.header;
        int cont = 0;

        System.out.println("Valor" + cont + ": " + blocoAux.valor);
        cont++;
        blocoAux = blocoAux.prox;

        while (blocoAux != this.header) {
            System.out.println("Valor " + cont + ": " + blocoAux.valor);
            blocoAux = blocoAux.prox;
            cont++;
        }
    }

    public double valorMedioBlocos () {
        if (this.header == null) {
            return 0;
        }

        if (this.header.prox == this.header) {
            return this.header.valor;
        }

        double soma = this.header.valor;
        double cont = 1;
        Bloco aux = this.header.prox;

        while (aux != this.header) {
            soma = aux.valor;
            cont++;
            aux = aux.prox;
        }

        return soma / cont;
    }

    public int valorMaiorBlocos () {

        if (this.header == null) {
            return 0;
        }
        if (this.header.prox == this.header) {
            return this.header.valor;
        }

        Bloco aux = this.header.prox;
        int valorMaior = this.header.valor;

        while (aux != this.header) {

            if (valorMaior < aux.valor) {
                valorMaior = aux.valor;
            }
            aux = aux.prox;
        }

        return valorMaior;
    }

    public int valorMenorBlocos () {

        if (this.header == null) {
            return 0;
        }
        if (this.header.prox == this.header) {
            return this.header.valor;
        }

        Bloco aux = this.header.prox;
        int valorMenor = this.header.valor;

        while (aux != this.header) {
            if (valorMenor > aux.valor) {
                valorMenor = aux.valor;
            }
            aux = aux.prox;
        }

        return valorMenor;
        
    }
}
