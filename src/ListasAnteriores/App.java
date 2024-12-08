package ListasAnteriores;
public class App {
    public static void main(String[] args) throws Exception {
        
        Lista lista = new Lista();
        lista.addElemento(1, false);
        lista.addElemento(3, false);
        lista.addElemento(3, false);
        lista.addElemento(3, false);
        lista.addElemento(5, false);

        lista.removerDuplicados();

        lista.printLista();

    }
}
