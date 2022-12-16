package model;

import java.util.Scanner;

public class JogadorPessoa extends Jogador {
    public JogadorPessoa() {
        this.tabuleiro  = new String[10][10];
        this.quantidadeAcertos = 0;
    }

    @Override
    public String fazJogada() {
        String jogada;
        int linha, coluna;
        Partida partida = new Partida();

        Scanner entrada = new Scanner(System.in);
        System.out.println(this.nome +" - Informe a jogada que deseja letra e número: Exemplo: a1");
        jogada = entrada.next();

        return jogada;

    }
}
