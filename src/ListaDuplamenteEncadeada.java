public class ListaDuplamenteEncadeada {

    Header cabecalho = new Header();

    public Bloco addBloco(int valor){
        Bloco novo = new Bloco();
        cabecalho.tamanho ++;
        novo.valor = valor;
        if (this.isVazia()){
            this.cabecalho.inicio = novo;
            this.cabecalho.fim = novo;
        } else {
            novo.ant = this.cabecalho.fim;
            this.cabecalho.fim.prox = novo;
            this.cabecalho.fim = novo;
        }
        return novo;
    }

    public Bloco localizarFim(int position){  //Percorre a partir do fim
        Bloco aux = cabecalho.fim;
        int contador = this.cabecalho.tamanho;
            while(aux != cabecalho.inicio && contador > position){
                if (aux != null){
                    aux = aux.ant;
                }
                contador--;
        }

        return aux;
    }
    
    public ListaDuplamenteEncadeada localizarValor(int valor) {
        Bloco aux = cabecalho.inicio;
        ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
            while (aux != null){
                if (aux.valor == valor){
                    novaLista.addBloco(valor);
                }
                aux = aux.prox;
            }
            return novaLista;
        }

    public Bloco removerBloco(int posicao){ //remover começando do fim
        if(this.cabecalho.fim == null){
            return null;
        }
        if(posicao < 0){
            return null;
        }
        Bloco blocoAlvo = localizarFim(posicao);
        if(blocoAlvo == this.cabecalho.fim){
            this.cabecalho.fim = blocoAlvo.ant;
            if(this.cabecalho.fim != null){
                this.cabecalho.fim.prox = null;
            }else{
                this.cabecalho.inicio = null;
            }
        }else if(blocoAlvo == this.cabecalho.inicio){
            this.cabecalho.inicio = blocoAlvo.prox;
        }else{
            Bloco blocoAnterior = blocoAlvo.ant;
            Bloco blocoProximo = blocoAlvo.prox;
            blocoAnterior.prox = blocoProximo;
            if(blocoProximo != null){
                blocoProximo.ant = blocoAnterior;
            }
        }
        this.cabecalho.tamanho --;
        blocoAlvo.prox = null;
        blocoAlvo.ant = null;
        return blocoAlvo;
    }

    public Boolean isVazia(){
        return this.cabecalho.inicio == null;
    }

    public void mostrarLista() {
        Bloco blocoAux = this.cabecalho.inicio;
        while (blocoAux != null) {
            System.out.println(blocoAux.valor);
            blocoAux = blocoAux.prox;
        }
        int tamanho = this.cabecalho.tamanho;
        if(tamanho > 0) {
            System.out.println(tamanho + " blocos");
        }else{
            System.out.println("Lista vazia");
        }
    }
}