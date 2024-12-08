package ListasAnteriores;
import java.util.List;

public class Turma{

    public int codigo;
    public ListaAluno alunos;
    public Disciplina disciplina;
    public List<Prova> provas;

    public Turma (int codigo, ListaAluno alunos, Disciplina disciplina) {
        this.codigo = codigo;
        this.alunos = alunos;
        this.disciplina = disciplina;
    }
}