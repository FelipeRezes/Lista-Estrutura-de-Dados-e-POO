

public class Carta {
    
    String naipe;
    int valor;
    Carta proxima;
    
    public Carta(int valor){
        this.valor = valor;
    }

    public Carta(int valor, String naipe){
        this.valor = valor;
        this.naipe = naipe;
    }

    @Override
    public String toString(){

        return "Carta [valor=" + valor + ", naipe=" + naipe + "]";
    }
}
