public class CadastroAluno {

    public static void main(String[] args) {

        // Criação da lista de alunos
        ListaAluno listaAlunos = new ListaAluno();

        // Adicionando alunos na lista
        System.out.println("Adicionando Alunos:");
        listaAlunos.addElemento("João", 101, true);  // Adiciona no início
        listaAlunos.addElemento("Maria", 102, false); // Adiciona no fim
        listaAlunos.addElemento("Carlos", 103, false); // Adiciona no fim
        listaAlunos.addElemento("Ana", 104, true);    // Adiciona no início
        
        // Imprimindo a lista de alunos
        System.out.println("Lista de Alunos:");
        listaAlunos.printLista();

        // Remover o primeiro aluno
        System.out.println("Removendo o primeiro aluno:");
        listaAlunos.removerElementoInicio();
        listaAlunos.printLista();

        // Remover o último aluno
        System.out.println("Removendo o último aluno:");
        listaAlunos.removerElementoFim();
        listaAlunos.printLista();

        // Remover aluno em uma posição específica
        System.out.println("Removendo aluno na posição 1:");
        listaAlunos.removerElemento(1);
        listaAlunos.printLista();

        // Mostrar tamanho da lista
        System.out.println("Tamanho da lista:");
        System.out.println(listaAlunos.tamanho());
    }
}

