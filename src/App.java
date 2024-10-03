public class App {
    public static void main(String[] args) throws Exception {
        
        Pilha pilha = new Pilha();

        pilha.lista.addElemento(10, true);
        pilha.lista.addElemento(20, true);
        pilha.lista.addElemento(0, true);
        pilha.lista.addElemento(14, true);

        Bloco topo = pilha.topo();

        System.out.println(topo.valor);

    }
}
