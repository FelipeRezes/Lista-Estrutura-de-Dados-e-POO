public class Lista {

    Bloco inicio;

    public Bloco addElemento(int valor,boolean posicaoIncio) {

        Bloco novo = null;

        if(posicaoIncio == true) {

            novo = this.addElementoInicio(valor);

        } else {

            novo = this.addElementoFim(valor);
        }

        return novo;
    }

    // QUESTÃO 8
    public Bloco addElemento (int valor, int pos){
        Bloco blocoNovo = localizarBloco(pos);
        if(blocoNovo == null){
            this.addElemento(1, false);
            this.addElemento(valor, pos);
        }else{
           blocoNovo.valor = valor;
        }
        return blocoNovo;
    }

    public Bloco removerElementoFim() {

        Bloco result = null;

        if(this.isVazia()) {
            return result;
        }

        if(this.tamanho() == 1) {
            //this.inicio = null;
            result = this.removerElementoInicio();
        } else {

            Bloco target = this.localizarBloco(this.tamanho()-1);
    
            result = target.prox;
            target.prox = null;
        }

        return result;
    }

    public Bloco removerElementoInicio() {

        Bloco result = this.inicio;
        if(!this.isVazia()) {

            this.inicio = this.inicio.prox;
        }

        return result;
    }

    // QUESTÃO 17
    public Bloco removerElemento (int pos){
        if(pos < 0 || inicio == null){
            return null;
        }
        Bloco blocoAlvo = localizarBloco(pos);
        if(blocoAlvo == inicio){
            inicio = inicio.prox;
        }else{
            Bloco blocoAnterior = localizarBloco(pos - 1);
            blocoAnterior.prox = blocoAlvo.prox;
        }
        blocoAlvo.prox = null;
        return blocoAlvo;
    }

    public boolean isVazia() {

        return this.inicio == null;
    }

    private Bloco addElementoInicio(int valor) {

        Bloco novo = new Bloco();
        novo.valor = valor;
        
        novo.prox = this.inicio;
        this.inicio = novo;

        return novo;
    }

    private Bloco addElementoFim(int valor) {

        Bloco novo = null;

        Bloco fim = this.localizarBloco(this.tamanho());

        if(fim == null) {

            novo = this.addElementoInicio(valor);
        } else {

            novo = new Bloco();
            novo.valor = valor;
    
            fim.prox = novo; 
        }

        return novo;
    }

    public Bloco localizarBloco(int pos) {

        Bloco aux = this.inicio;
        int cont =0;

        while(aux!= null && cont < pos -1) {

            cont++;
            aux = aux.prox;
        }

        return aux;
    }

    public int tamanho() {

        Bloco aux = this.inicio;
        int cont =0;

        while(aux!= null) {

            cont++;
            aux = aux.prox;
        }

        return cont;
    }
    //QUESTÃO 18:
    public Lista localizarMaior(int valor) {

        Bloco blocoAux = this.inicio;
        Lista nova = new Lista();
        while(blocoAux != null){
            if(blocoAux.valor > valor){
                nova.addElemento(blocoAux.valor, true);
            }
        blocoAux = blocoAux.prox;
        } 
        return nova;
    }

    public void printLista(){
        Bloco blocoAux = this.inicio;
        while (blocoAux != null) {
            System.out.println(blocoAux.valor);
            blocoAux = blocoAux.prox;
        }
    }

    // QUESTÃO 7:
    public Lista inverter(){

        int tamanho = this.tamanho();
        Lista aux = new Lista();
        for(int i = tamanho; i>0; i--){
            int valor = this.localizarBloco(i).valor;
            aux.addElemento(valor,false);
        }

        return aux;
    }

    //QUESTÃO 14:
    public void removerDuplicados(){

        Bloco blocoAtual = this.inicio;
        while(blocoAtual != null){
            Bloco blocoAux = blocoAtual;
            while(blocoAux.prox != null){
                if(blocoAtual.valor == blocoAux.prox.valor){
                    blocoAux.prox = blocoAux.prox.prox;
                }else{
                    blocoAux = blocoAux.prox;
                }
        }
            blocoAtual = blocoAtual.prox;
        }
    }

    //QUESTÃO 13 NÃO TESTADA
    public Lista concatena(Lista lista){

        Lista listaconcatenada = new Lista();
        listaconcatenada.inicio = this.inicio;
        Bloco ultimo = listaconcatenada.localizarBloco(this.tamanho());
        ultimo.prox = lista.inicio;
        
        return listaconcatenada;
    }

    //QUESTÃO 15 NÃO TESTADA
    public Lista clone(Lista lista){

        Lista clone = new Lista();
        Bloco aux = this.inicio;
        while(aux.prox != null){
            clone.addElementoFim(aux.valor);
            aux = aux.prox;
        }

        return clone;
    }


}