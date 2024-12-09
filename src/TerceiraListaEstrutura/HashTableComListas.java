package TerceiraListaEstrutura;

import java.util.LinkedList;

public class HashTableComListas {

    static class HashTable {
        private LinkedList<Integer>[] tabela;
        private int tamanho;

        @SuppressWarnings("unchecked")
        public HashTable(int tamanho) {
            this.tamanho = tamanho;
            this.tabela = new LinkedList[tamanho];

            for (int i = 0; i < tamanho; i++) {
                tabela[i] = new LinkedList<>();
            }
        }

        private int calcularIndice(int valor) {
            return valor % tamanho;
        }

        public void inserir(int valor) {
            int indice = calcularIndice(valor);

            if (!tabela[indice].contains(valor)) {
                tabela[indice].add(valor);
            }
        }

        public void exibirTabela() {
            for (int i = 0; i < tamanho; i++) {
                System.out.print("Posição " + i + ": " + tabela[i]);
                System.out.println();
            }
        }

        public boolean existe(int valor) {
            int indice = calcularIndice(valor);
            return tabela[indice].contains(valor);
        }

  
        public boolean remover(int valor) {
            int indice = calcularIndice(valor);
            return tabela[indice].remove((Integer) valor);
        }
    }
}
