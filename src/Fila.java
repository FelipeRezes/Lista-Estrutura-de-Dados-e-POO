public class Fila {
    
    Lista lista = new Lista();

    public void push(int valor){

        this.lista.addElemento(valor, false);

    }

    public Bloco pop(){

        return this.lista.removerElementoInicio();

    }
}
