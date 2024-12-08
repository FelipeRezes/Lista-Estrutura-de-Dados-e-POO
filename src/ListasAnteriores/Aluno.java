package ListasAnteriores;
public class Aluno {

    public String nome;
    public int matricula;
    
    public Nota media;
    public Nota nota1;
    public Nota nota2;
    public Nota nota3;

    public Aluno (String nome, int matricula, Nota nota1, Nota nota2, Nota nota3) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public Aluno (String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = new Nota(0);
        this.nota2 = new Nota(0);
        this.nota3 = new Nota(0);
    }

    public double settarMedia() {
        return media.settarMedia(nota1, nota2, nota3);
    }
}