package ListasAnteriores;
import java.util.Array;
public class ListaArray{
    
    //questão 10 - Não testada
    public int capacidadeInicial = 2;
    public int tamanhoAtual;

    public Bloco[] bloco = new Bloco[capacidadeInicial];

    void Bloco expandirArray{
        Bloco[] arrayNovo = new Bloco[bloco.lenght *2]; 
        for (int i = 0; i<bloco.lenght; i++){
            arrayNovo [i]= bloco [i];

        }
    }

    public Bloco addBlocoArray(Bloco bloco){
        if (tamanhoAtual == bloco.lenght){
            expandirArray();
        } 
        bloco(tamanhoAtual) = bloco;
        tamanhoAtual++;
        return bloco;
    }
}