public class Nota{

    public float nota;

    public Nota(float nota) {
        this.nota = nota;
    }

    public double settarMedia(Nota nota1, Nota nota2, Nota nota3) {
        return (nota1.nota + nota2.nota + nota3.nota)/3;
    }

}