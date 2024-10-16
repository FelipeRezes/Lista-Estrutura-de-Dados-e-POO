public class FilaPrioridade{

    Lista lista = new Lista();

    public Bloco push(int valor) {

        return this.lista.addElemento(valor, false);

    }

    public Bloco pop() {

        prioridade = this.prioridade();
        this.lista.removerElemento(prioridade);

    }
    
    //QUESTÃO 16 NÃO TESTADA
    public int prioridade(){
        
        Bloco aux = this.lista.inicio;
        Bloco maiorPrioridade = aux;

        while(aux.prox != null){
            if (maiorPrioridade.prioridade < aux.prioridade){
                maiorPrioridade = aux;
            }
            aux = aux.prox;
        }

        return this.localizarBloco(maiorPrioridade.valor);        

    }


}