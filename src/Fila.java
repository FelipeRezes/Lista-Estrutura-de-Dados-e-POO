public class Fila {

    Lista lista = new Lista();

    public Bloco push(int valor) {

        return this.lista.addElemento(valor, false);

    }

    // QUESTÃO 2
    public Bloco pop() {

        return this.lista.removerElementoInicio();

    }

    // QUESTÃO 6
    public Pilha pilhaEquivalente() {
        Pilha pilha = new Pilha();
        Bloco blocoAux = lista.inicio;

        while (blocoAux != null) {
            pilha.push(blocoAux.valor);
            blocoAux = blocoAux.prox;
        }
        return pilha;
    }

}
