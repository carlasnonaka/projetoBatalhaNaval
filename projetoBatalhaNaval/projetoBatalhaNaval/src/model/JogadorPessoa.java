package model;

import java.util.Scanner;
public class JogadorPessoa extends Jogador {
    public JogadorPessoa() {
        this.tabuleiro  = new String[10][10];
         }

    @Override
    public String fazJogada() {
        String jogada;
        int linha, coluna;
        Partida partida = new Partida();

        Scanner entrada = new Scanner(System.in);

            System.out.println(this.nome + " - Informe a coordenada que deseja atacar, com letra e número.\n Exemplo: A1");
            jogada = entrada.next();
          return jogada;

        }
}