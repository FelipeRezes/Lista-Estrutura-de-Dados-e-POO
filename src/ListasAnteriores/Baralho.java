package ListasAnteriores;


import java.util.List;
import java.util.Arrays;

public class Baralho {

    public ListaBaralho baralho = new ListaBaralho();
    List<String> naipe = Arrays.asList("Ouros", "Copas", "Espadas", "Paus");

    
    public void preencher() {

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                this.baralho.add(j, naipe.get(i));
            }
        }

    }

    public ListaBaralho embaralhar() {
        
        baralho = this.baralho.embaralhar();
        return baralho;

    }

    public Carta distribuir(){

        return this.baralho.remover();

    }

}
