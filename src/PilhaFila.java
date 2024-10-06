public class PilhaFila {
    
    Fila fila = new Fila();
    Fila filaAux = new Fila();

    public Bloco push(int valor) {

        Bloco resultado = this.filaAux.push(valor);
        this.transferir();

        return resultado;

    }

    public Bloco pop() {

        return this.fila.pop();

    }

    public void print(){
        this.fila.print();
    }

    public void transferir() {

        if (fila.lista.isVazia()){
            Bloco blocoTransferido = filaAux.pop();
            fila.push(blocoTransferido.valor);
        }
        while (!fila.lista.isVazia()) {
            Bloco blocoTransferido = fila.pop();
            filaAux.push(blocoTransferido.valor);
        }

        Fila tempfila = filaAux;
        this.filaAux = fila;
        this.fila = tempfila;
    }
}
