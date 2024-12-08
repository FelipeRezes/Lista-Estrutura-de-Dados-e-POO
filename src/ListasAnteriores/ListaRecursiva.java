package ListasAnteriores;
public class ListaRecursiva {
    
    Bloco inicio;

    // QUESTÃO 8:
    public Bloco localizarBloco (int pos){
        return localizarBloco(pos, 0, inicio);
    }

    private Bloco localizarBloco (int pos, int posAtual, Bloco blocoAux){

        if(blocoAux != null){
            if(pos == posAtual){
                return blocoAux;
            }else{
                return localizarBloco(pos, posAtual + 1, blocoAux.prox);
            }
        }

        return blocoAux;
    }

    public int tamanho(){
        return tamanho(inicio);
    }

    private int tamanho(Bloco blocoAux){
        if(blocoAux == null){
            return 0;
        }else{
            return tamanho(blocoAux.prox) + 1;
        }
    }
}
