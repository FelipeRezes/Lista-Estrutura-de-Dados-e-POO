public class BlocoAluno {

    public Aluno aluno;
    public BlocoAluno prox;

    public BlocoAluno (Aluno aluno) {
        this.aluno = aluno;
    }
    
    public BlocoAluno (Aluno aluno, BlocoAluno prox) {
        this.aluno = aluno;
        this.prox = prox;
    }
}
