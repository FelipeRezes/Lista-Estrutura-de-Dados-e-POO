package TerceiraListaEstrutura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class ArvoreB<T> {

    static class No<T> {
        T valor;
        List<No<T>> filhos;

        public No(T valor, int numFilhos) {
            this.valor = valor;
            this.filhos = new ArrayList<>(numFilhos);
        }
    }

    private final int numFilhos;
    private No<T> raiz;
    public ArvoreB(int numFilhos) {
        if (numFilhos < 1) {
            throw new IllegalArgumentException("Deve ter ao menos 1");
        }
        this.numFilhos = numFilhos;
        this.raiz = null;
    }

    public void adicionarRaiz(T valor) {
        if (raiz == null) {
            raiz = new No<>(valor, numFilhos);
        } else {
            throw new IllegalStateException("Raiz já existente");
        }
    }

    public void adicionarPorNivel(T valor) {
        No<T> novoNo = new No<>(valor, numFilhos);

        if (raiz == null) {
            raiz = novoNo;
            return;
        }

        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();

            if (atual.filhos.size() < numFilhos) {
                atual.filhos.add(novoNo);
                return;
            }

    
            fila.addAll(atual.filhos);
        }
    }

    public int altura() {
        return alturaCalc(raiz);
    }

    private int alturaCalc(No<T> no) {
        if (no == null) {
            return 0;
        }

        int alturaMax = 0;
        for (No<T> filho : no.filhos) {
            alturaMax = Math.max(alturaMax, alturaCalc(filho));
        }

        return alturaMax + 1;
    }

    public void balancear() {
        if (raiz == null) {
            return;
        }

        List<T> valores = new ArrayList<>();
        coletarValores(raiz, valores);

        raiz = null;
        for (T valor : valores) {
            adicionarPorNivel(valor);
        }
    }

    private void coletarValores(No<T> no, List<T> valores) {
        if (no == null) {
            return;
        }

        valores.add(no.valor);
        for (No<T> filho : no.filhos) {
            coletarValores(filho, valores);
        }
    }

    public boolean removerValor(T valor) {
        if (raiz == null) {
            return false;
        }

        if (raiz.valor.equals(valor)) {
            raiz = null;
            return true;
        }

        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();

            for (int i = 0; i < atual.filhos.size(); i++) {
                No<T> filho = atual.filhos.get(i);
                if (filho.valor.equals(valor)) {
                    atual.filhos.remove(i);
                    fila.addAll(filho.filhos);
                    return true;
                }
            }

            fila.addAll(atual.filhos);
        }

        return false; 
    }

    public No<T> localizarValor(T valor) {
        if (raiz == null) {
            return null;
        }

        Queue<No<T>> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No<T> atual = fila.poll();

            if (atual.valor.equals(valor)) {
                return atual;
            }

            fila.addAll(atual.filhos);
        }

        return null;
    }

    public void percorrerPreOrdem(No<T> no) {
        if (no == null) {
            return;
        }

        System.out.print(no.valor + " ");

        for (No<T> filho : no.filhos) {
            percorrerPreOrdem(filho);
        }
    }

    public No<T> getRaiz() {
        return raiz;
    }
} ArvoreB;
