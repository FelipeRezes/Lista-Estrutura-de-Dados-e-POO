package ListasAnteriores;
public class Partida {

    private Baralho baralho;   // O baralho usado no jogo
    private ListaBaralho cartasJogador1;   // Cartas do jogador 1
    private ListaBaralho cartasJogador2;   // Cartas do jogador 2

    public Partida() {
        baralho = new Baralho();
        baralho.preencher();    // Preenche o baralho com as cartas
        baralho.embaralhar();   // Embaralha o baralho
        
        cartasJogador1 = new ListaBaralho();
        cartasJogador2 = new ListaBaralho();
    }

    public void jogar() {
        // Cada jogador tira 5 cartas alternadamente
        for (int i = 0; i < 5; i++) {
            Carta cartaJogador1 = baralho.distribuir();  // Jogador 1 tira uma carta
            Carta cartaJogador2 = baralho.distribuir();  // Jogador 2 tira uma carta
            
            // Verifica se as cartas não são nulas antes de imprimir
            if (cartaJogador1 != null) {
                System.out.println("Jogador 1 tirou: " + cartaJogador1.valor + " de " + cartaJogador1.naipe);
                cartasJogador1.add(cartaJogador1.valor, cartaJogador1.naipe);  // Adiciona a carta ao baralho do Jogador 1
            } else {
                System.out.println("Jogador 1 não conseguiu tirar uma carta.");
            }
    
            if (cartaJogador2 != null) {
                System.out.println("Jogador 2 tirou: " + cartaJogador2.valor + " de " + cartaJogador2.naipe);
                cartasJogador2.add(cartaJogador2.valor, cartaJogador2.naipe);  // Adiciona a carta ao baralho do Jogador 2
            } else {
                System.out.println("Jogador 2 não conseguiu tirar uma carta.");
            }
        }
        

        // Após distribuir as cartas, verificamos quem tem o maior valor somado
        int somaJogador1 = calcularSoma(cartasJogador1);
        int somaJogador2 = calcularSoma(cartasJogador2);

        System.out.println("\nSoma das cartas:");
        System.out.println("Jogador 1: " + somaJogador1);
        System.out.println("Jogador 2: " + somaJogador2);

        if (somaJogador1 > somaJogador2) {
            System.out.println("Jogador 1 vence!");
        } else if (somaJogador2 > somaJogador1) {
            System.out.println("Jogador 2 vence!");
        } else {
            System.out.println("Empate!");
        }
    }

    // Método para calcular a soma das cartas de um jogador
    private int calcularSoma(ListaBaralho cartas) {
        int soma = 0;
        Carta aux = cartas.inicio;
        while (aux != null) {
            soma += aux.valor;
            aux = aux.proxima;
        }
        return soma;
    }

    public static void main(String[] args) {
        Partida partida = new Partida();  // Cria uma nova partida
        partida.jogar();  // Inicia o jogo
    }
}
