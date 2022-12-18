/* O desafio consiste em implementar esse jogo em um programa Java, mas para facilitar um pouco,
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
 */

import model.*;

public class Main {

       public static void main(String[] args) {

        Partida partida = new Partida();
        Jogador jogador = new Jogador();
        JogadorMaquina jogadorMaquina = new JogadorMaquina();
        JogadorPessoa jogadorPessoa = new JogadorPessoa();
        boolean existeGanhador = false;
        int placarPessoa = 0;
        int placarMaquina = 0;

        String nomeJogador = jogadorPessoa.solicitaNomeDoJogador().toUpperCase();

        String[][] tabuleiroJogador = new String[10][10];
        String[][] tabuleiroComputador = new String[10][10];

        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.geradorSubmarino(tabuleiroJogador);
        tabuleiro.geradorSubmarino(tabuleiroComputador);

        System.out.println("Iniciando model.Tabuleiro Batalha Naval!");
        tabuleiro.imprimeTabuleiro(tabuleiroJogador, nomeJogador);
               while (!existeGanhador){

         placarPessoa = partida.verificarJogada(jogadorPessoa.fazJogada(), nomeJogador, tabuleiroJogador, tabuleiroComputador);
         tabuleiro.imprimeTabuleiro(tabuleiroJogador,nomeJogador);
         exibirPlacar(placarMaquina,nomeJogador,placarPessoa);
                  existeGanhador = partida.verificaSeHouveGanhador(jogadorPessoa, jogadorMaquina);

         placarMaquina =partida.verificarJogada(jogadorMaquina.fazJogada(), "COMPUTADOR", tabuleiroComputador, tabuleiroJogador);
            exibirPlacar(placarMaquina,nomeJogador,placarPessoa);
            existeGanhador = partida.verificaSeHouveGanhador(jogadorPessoa, jogadorMaquina);

        }
        System.out.println("JOGO FINALIZADO");
        tabuleiro.imprimeTabuleiro(tabuleiroJogador,nomeJogador);
        tabuleiro.imprimeTabuleiro(tabuleiroComputador,"COMPUTADOR");
        }

         public static void exibirPlacar(int placarMaquina,String nomeJogador,int placarPessoa) {
           System.out.printf("-------------------------\n" +
           "NAVIO ABATIDOS: \n" + "COMPUTADOR: %d\n" + "%s : %d\n" + "-------------------------\n", placarMaquina,nomeJogador,placarPessoa)
        ;
    }
}

