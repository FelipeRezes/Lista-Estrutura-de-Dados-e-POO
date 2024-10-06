public class Fila {
    
    Lista lista = new Lista();

    public Bloco push(int valor){

        return this.lista.addElemento(valor, false);

    }

    public Bloco pop(){

        return this.lista.removerElementoInicio();

    }

    public void print(){

        this.lista.imprimir();
        
    }
}
