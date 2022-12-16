/* o desafio consiste em implementar esse jogo em um programa Java, mas para facilitar um pouco,
vamos alterar levemente as especificações do jogo:
Em nossa versão, teremos apenas navios do tipo submarino (1 quadrado).
• Cada jogador deverá posicionar em sua grelha dez submarinos.
• O programa aceitará apenas um jogador, pois o oponente será o computador.
• Para não precisarmos utilizar cores no terminal vamos usar as marcações:
. Navio posicionado N (ene maiúsculo)
. Tiro certeiro * (asterisco)
. Tiro na água – (traço)
. Tiro certeiro com navio posicionado X (xis maiúsculo)
. Tiro na água com navio posicionado n (ene minúsculo)
• Durante a partida o programa exibirá apenas a situação atual do jogador.
• Ao final do jogo, devemos indicar o vencedor e imprimir os dois
tabuleiros.
OBSERVAÇÕES: letra e número nas jogadas
- letra representa a linha e número a coluna; switch case
-
DIVISÃO:
- CRIAR TABULEIROS - falta formatação (Cris)
- INSERIR NAVIOS (criar opções RANDOM, ESCOLHE JOGADAS) e computador sempre random (herança)-
classe Jogador - random padrão - @Override sobreescreve para preenchimento manual
- classe model.Tabuleiro ok
- Preenchimento das Jogadas com frases
- Comparação em cada jogada contador com placar
-
-
- FRASE DO QUE ACONTECEU E PLACAR
-
 */


import model.*;

public class Main {

    public static void main(String[] args) {


        Partida partida = new Partida();
        Jogador jogador = new Jogador();
        JogadorMaquina jogadorMaquina = new JogadorMaquina();
        JogadorPessoa jogadorPessoa = new JogadorPessoa();
        boolean existeGanhador = false;

        String nomeJogador = jogadorPessoa.solicitaNomeDoJogador().toUpperCase();

        String[][] tabuleiroJogador = new String[10][10];
        String[][] tabuleiroComputador = new String[10][10];

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.imprimeTabuleiro(tabuleiroJogador, "");

       tabuleiro.geradorSubmarino(tabuleiroJogador);
       tabuleiro.geradorSubmarino(tabuleiroComputador);

        System.out.println("Iniciando model.Tabuleiro Batalha Naval!");
        tabuleiro.imprimeTabuleiro(tabuleiroJogador, nomeJogador);
        tabuleiro.imprimeTabuleiro(tabuleiroComputador, "COMPUTADOR");

        while (!existeGanhador){

            jogadorPessoa.fazJogada();
            jogadorMaquina.fazJogada();

            existeGanhador = partida.verificaSeHouveGanhador(jogadorPessoa, jogadorMaquina);
        }
        System.out.println("JOGO FINALIZADO");

/*while (partida.controleContadorAtaque()) {
    if (contadorGeral % 2 == 0) {
        partida.verificarJogada(nomeJogador, tabuleiroJogador, tabuleiroComputador, tabuleiro);
    } else {
        partida.verificarJogada("COMPUTADOR", tabuleiroComputador, tabuleiroJogador, tabuleiro);
    }
    contadorGeral++;
}*/

       /* String jogadaLetra = new String();

        int jogadaNumero = 0;

        int contadorNavio = 0;*/








//        do {
//            Scanner entrada = new Scanner(System.in);
//            System.out.println("Digite a posição do Navio "+ contadorNavio);
//
//            System.out.println("Digite uma letra e um número");
//            jogadaLetra = entrada.nextLine();
//            jogadaNumero = entrada.nextInt();
//
//            int letraConvertida = converterLetra(jogadaLetra);
//
//            tabuleiro[letraConvertida][jogadaNumero] = ("N" + "\t");
//            contadorNavio++;
//
//            tabuleiroManual.imprimeTabuleiro(tabuleiro);
//
//        } while(contadorNavio <= 9);

    }






    }