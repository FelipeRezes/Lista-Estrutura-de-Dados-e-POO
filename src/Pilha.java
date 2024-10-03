public class Pilha {
    
    Lista lista = new Lista();

    public void push(int valor) {

        this.lista.addElemento(valor,false);

    }

    public Bloco pop() {

        return this.lista.removerElementoFim();
    
    }

    public Bloco topo() {

        return this.lista.localizarBloco(this.lista.tamanho());
        /*top retorna localizar(tamanho) porque o elemento da fila que ta no topo 
        é o ultimo, já que é LIFO (last in, first out)
        return this.lista.localizarBloco(0); tava assim antes
         */

    }
}
