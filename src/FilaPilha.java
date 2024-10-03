public class FilaPilha {
    
    Pilha pilha = new Pilha();

    public void push(int valor) {

        this.pilha.lista.addElemento(valor, true);

    }

    public Bloco pop() {

        return this.pilha.lista.removerElementoInicio();

    }
}
