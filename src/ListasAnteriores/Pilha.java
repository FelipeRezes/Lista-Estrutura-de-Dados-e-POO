package ListasAnteriores;
public class Pilha {
    
    Lista lista = new Lista();

    public void push(int valor) {

        this.lista.addElemento(valor,false);

    }

    public Bloco pop() {

        return this.lista.removerElementoFim();
    
    }

    public Bloco topo() {

        return this.lista.localizarBloco(0);

    }

    // QUESTÃO 5
    public Fila filaEquivalente(){
        Fila fila = new Fila();
        Bloco blocoAux = lista.inicio;

        while (blocoAux != null){
            fila.push(blocoAux.valor);
            blocoAux = blocoAux.prox;
        }
        return fila;
    }


}
