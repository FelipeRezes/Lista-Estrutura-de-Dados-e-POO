package TerceiraListaEstrutura;

import java.util.ArrayList;

public class ListaMatriz {

    private ArrayList<ArrayList<Integer>> ListaMatriz; 

    public ListaMatriz(int linhas, int colunas) {
        ListaMatriz = new ArrayList<>();

        for (int i = 0; i < linhas; i++) {
            ArrayList<Integer> linha = new ArrayList<>();
            for (int j = 0; j < colunas; j++) {
                linha.add(0); 
            }
            ListaMatriz.add(linha);
        }
    }

 
    public void setValor(int linha, int coluna, int valor) {
        if (linha < 0 || linha >= ListaMatriz.size() || coluna < 0 || coluna >= ListaMatriz.get(linha).size()) {
            throw new IndexOutOfBoundsException("Valor Inválido");
        }
        ListaMatriz.get(linha).set(coluna, valor);
    }


    public int getValor(int linha, int coluna) {
        if (linha < 0 || linha >= ListaMatriz.size() || coluna < 0 || coluna >= ListaMatriz.get(linha).size()) {
            throw new IndexOutOfBoundsException("Valor Inválido");
        }
        return ListaMatriz.get(linha).get(coluna);
    }

 
    public void exibirListaMatriz() {
        for (ArrayList<Integer> linha : ListaMatriz) {
            System.out.println(linha);
        }
    }

  
    public void adicionarLinha(ArrayList<Integer> novaLinha) {
        if (novaLinha.size() != ListaMatriz.get(0).size()) {
            throw new IllegalArgumentException("Colunas Insuficientes");
        }
        ListaMatriz.add(novaLinha);
    }

  
    public void adicionarColuna(ArrayList<Integer> novaColuna) {
        if (novaColuna.size() != ListaMatriz.size()) {
            throw new IllegalArgumentException("Colunas Insuficientes");
        }
        for (int i = 0; i < ListaMatriz.size(); i++) {
            ListaMatriz.get(i).add(novaColuna.get(i));
        }
    }

  
    public int getLinhasTamanho() {
        return ListaMatriz.size();
    }

   
    public int getColunasTamanho() {
        return ListaMatriz.isEmpty() ? 0 : ListaMatriz.get(0).size();
    }
} ListaMatriz;
