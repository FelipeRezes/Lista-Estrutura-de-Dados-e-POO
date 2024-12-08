package ListasAnteriores;
public class ListaAluno {
    BlocoAluno inicio;

    public BlocoAluno addElemento(String nome, int codigo, boolean posicaoIncio) {

        BlocoAluno novo = null;

        if(posicaoIncio == true) {

            novo = this.addElementoInicio(nome, codigo);

        } else {

            novo = this.addElementoFim(nome, codigo);
        }

        return novo;
    }

    public BlocoAluno removerElementoFim() {

        BlocoAluno result = null;

        if(this.isVazia()) {
            return result;
        }

        if(this.tamanho() == 1) {
            //this.inicio = null;
            result = this.removerElementoInicio();
        } else {

            BlocoAluno target = this.localizarBloco(this.tamanho()-1);

            result = target.prox;
            target.prox = null;
        }

        return result;
    }

    public BlocoAluno removerElementoInicio() {

        BlocoAluno result = this.inicio;
        if(!this.isVazia()) {

            this.inicio = this.inicio.prox;
        }

        return result;
    }

    // QUESTÃO 17
    public BlocoAluno removerElemento (int pos){
        if(pos < 0 || inicio == null){
            return null;
        }
        BlocoAluno blocoAlvo = localizarBloco(pos);
        if(blocoAlvo == inicio){
            inicio = inicio.prox;
        }else{
            BlocoAluno blocoAnterior = localizarBloco(pos - 1);
            blocoAnterior.prox = blocoAlvo.prox;
        }
        blocoAlvo.prox = null;
        return blocoAlvo;
    }

    public boolean isVazia() {

        return this.inicio == null;
    }

    private BlocoAluno addElementoInicio(String nome, int codigo) {

        BlocoAluno novo = new BlocoAluno();
        novo.aluno = new Aluno();
        novo.aluno.nome = nome;
        novo.aluno.matricula = codigo;

        novo.prox = this.inicio;
        this.inicio = novo;

        return novo;
    }

    private BlocoAluno addElementoFim(String nome, int codigo) {

        BlocoAluno novo = null;

        BlocoAluno fim = this.localizarBloco(this.tamanho());

        if(fim == null) {

            novo = this.addElementoInicio(nome, codigo);
        } else {

            novo = new BlocoAluno();
            novo.aluno = new Aluno();
            novo.aluno.nome = nome;
            novo.aluno.matricula = codigo;

            fim.prox = novo;
        }

        return novo;
    }

    public BlocoAluno localizarBloco(int pos) {

        BlocoAluno aux = this.inicio;
        int cont =0;

        while(aux!= null && cont < pos -1) {

            cont++;
            aux = aux.prox;
        }

        return aux;
    }

    public int tamanho() {

        BlocoAluno aux = this.inicio;
        int cont =0;

        while(aux!= null) {

            cont++;
            aux = aux.prox;
        }

        return cont;
    }

    



    public void printLista(){
        BlocoAluno blocoAux = this.inicio;
        while (blocoAux != null) {
            System.out.println("----------");
            System.out.println(blocoAux.aluno.nome);
            System.out.println(blocoAux.aluno.matricula);
            System.out.println("----------");
            blocoAux = blocoAux.prox;
        }
    }
 
} 