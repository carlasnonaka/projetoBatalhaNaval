package model;

import java.util.Scanner;

public class Partida {

    int contadorAtaque = 0;

    public boolean verificaSeHouveGanhador(Jogador jogadorPrincipal, Jogador jogadorOponente) {
        if (jogadorOponente.quantidadeAcertos == 10){
            System.out.println("Parabens "+ jogadorOponente.nome + " !!! Vc é o ganhador!!");
            return true;
        }else if (jogadorPrincipal.quantidadeAcertos == 10){
            System.out.println("Parabens "+ jogadorPrincipal.nome + " !!! Vc é o ganhador!!");
            return true;
        }

        return false;
    }


    public void verificarJogada(String nomeJogador, String[][] tabuleiro1, String[][] tabuleiro2, Tabuleiro tabuleiro) {
        String jogada;
        int linha, coluna;

        Jogador jogador = new Jogador();
        JogadorPessoa  jogadorPessoa = new JogadorPessoa();
        JogadorMaquina jogadorMaquina = new JogadorMaquina();

        while (contadorAtaque < 10) {

            if (!nomeJogador.equalsIgnoreCase("COMPUTADOR")) {
                jogada = jogadorPessoa.fazJogada();
            } else {
                jogada = jogadorMaquina.fazJogada();
            }

            linha = converterLetra(jogada.substring(0,1));
            coluna = Integer.valueOf(jogada.substring(1,2));

            if (tabuleiro1[linha][coluna] == null) {

                if (tabuleiro2[linha][coluna] == null) {
                    tabuleiro1[linha][coluna] = "-";
                    System.out.println("Ops... Tiro na água!");
                } else if (tabuleiro2[linha][coluna] == "N") {
                    tabuleiro1[linha][coluna] = "*";
                    System.out.println("Parabéns... Submarino Atingido!");
                    contadorAtaque++;

                } else {
                    System.out.println("Jogada Inválida. Tente novamente!");
                }

            } else if (tabuleiro1[linha][coluna] == "N") {

                if (tabuleiro2[linha][coluna] == null) {
                    tabuleiro1[linha][coluna] = "n";
                    System.out.println("Ops... Tiro na água!");
                } else if (tabuleiro2[linha][coluna] == "N") {
                    tabuleiro1[linha][coluna] = "X";
                    System.out.println("Parabéns... Submarino Atingido!");
                    contadorAtaque++;
                } else {
                    System.out.println("Jogada Inválida. Tente novamente!");
                }
            } else {
                System.out.println("Jogada Inválida. Tente novamente!");
            }
            tabuleiro.imprimeTabuleiro(tabuleiro1, "");
            controleContadorAtaque();
        }
    }

    public boolean controleContadorAtaque() {
        if (contadorAtaque == 10) {
            return false;
        } else {
            return true;
        }
    }
    public int converterLetra(String letra) {
        switch (letra.toLowerCase()) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            case "i":
                return 8;
            case "j":
                return 9;
            default:
                System.out.println("Número Inválido");
        }

        return 0;
    }
}
