import java.util.Random;

public class ListaBaralho {
    
    public Carta inicio;

    public Carta add(int valor){

        Carta novo = new Carta(valor);

        if (this.isVazia()) {
            this.inicio = novo;
            return novo;
        }

        Carta fim = this.localizar(this.tamanho());
        fim.proxima = novo;
    
        return novo;
    }

    public Carta add(int valor, String naipe){

        Carta novo = new Carta(valor, naipe);

        if (this.isVazia()) {
            this.inicio = novo;
            return novo;
        }

        Carta fim = this.localizar(this.tamanho());
        fim.proxima = novo;
    
        return novo;
    }
    

    public Carta remover(){

        if (this.isVazia()){
            return null;
        }

        if (this.tamanho() == 1){

            Carta removida = this.inicio;
            this.inicio = null;
            return removida;

        }

        Carta penultima = this.localizar(this.tamanho()-1);
        Carta removida = penultima.proxima;
        penultima.proxima = null;

        return removida;
    }

    public Carta remover(int pos){

        if(pos < 0 || inicio == null){
            return null;
        }
        Carta cartaAlvo = localizar(pos);
        if(cartaAlvo == inicio){
            inicio = inicio.proxima;
        }else{
            Carta cartaAnterior = localizar(pos - 1);
            cartaAnterior.proxima = cartaAlvo.proxima;
        }
        cartaAlvo.proxima = null;
        return cartaAlvo;
    }

    public ListaBaralho embaralhar(){

        int tamanhoOriginal = this.tamanho();
        ListaBaralho baralhoEmbaralhado = new ListaBaralho();
        
        for (int i = 0; i < tamanhoOriginal; i++) {
            int cartaSorteada = this.sortearCarta();
            Carta cartaRemovida = this.remover(cartaSorteada); 
            baralhoEmbaralhado.add(cartaRemovida.valor, cartaRemovida.naipe);
        }
    
        return baralhoEmbaralhado;
    }

    public int sortearCarta() {

        Random rand = new Random();
        return rand.nextInt(this.tamanho());

    }

    public int tamanho(){

        Carta aux = this.inicio;
        int cont = 0;
        while(aux!= null){
            cont++;
            aux = aux.proxima;
        }
        
        return cont;
    }

    public Carta localizar(int pos){

        Carta aux = this.inicio;
        int cont =0;


        while(aux!= null && cont < pos -1) {

            cont++;
            aux = aux.proxima;
        }

        return aux;
    }

    public boolean isVazia() {

        return this.inicio == null;

    }
}
