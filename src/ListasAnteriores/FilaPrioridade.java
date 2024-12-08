package ListasAnteriores;
public class FilaPrioridade{

    Lista lista = new Lista();

    public Bloco push(int valor) {

        return this.lista.addElemento(valor, false);

    }

    public Bloco pop() {

        int prioridade = this.prioridade();
        return this.lista.removerElemento(prioridade);

    }
    
    //QUESTÃO 16 NÃO TESTADA
    public int prioridade(){
        
        Bloco aux = this.lista.inicio;
        Bloco maiorPrioridade = aux;
        int posicaoMaior;
        int posicaoAtual = 1;

        while(aux.prox != null){
            if (maiorPrioridade.prioridade < aux.prioridade){
                maiorPrioridade = aux;
                posicaoMaior = posicaoAtual;
            }
            aux = aux.prox;
            posicaoAtual++;
        }

        return this.lista.localizarBloco(posicaoMaior).valor;

    }


}