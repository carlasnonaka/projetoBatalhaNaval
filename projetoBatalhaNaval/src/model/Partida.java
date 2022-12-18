package model;

import java.util.Scanner;

public class Partida {

 int placarPessoa = 0;
    int placarMaquina = 0;

    public boolean verificaSeHouveGanhador(Jogador jogadorPrincipal, Jogador jogadorOponente) {
        if (placarMaquina == 10) {
            System.out.println("Parabens " + jogadorOponente.nome + " !!! Vc é o ganhador!!");
            return true;
        } else if (placarPessoa == 10) {
            System.out.println("Parabens " + jogadorPrincipal.nome + " !!! Vc é o ganhador!!");
            return true;
        }
        return false;
    }


    public int verificarJogada(String jogada, String nomeJogador, String[][] tabuleiro1, String[][] tabuleiro2) {

        int linha=0, coluna =0;

        Jogador jogador = new Jogador();
        JogadorPessoa jogadorPessoa = new JogadorPessoa();
        JogadorMaquina jogadorMaquina = new JogadorMaquina();


       try {
           linha = converterLetra(jogada.substring(0,1));
           coluna = Integer.valueOf(jogada.substring(1,2));
        }catch(StringIndexOutOfBoundsException e) {
           System.out.println("Coordenada inválida! Digite uma coordenada válida.");
           jogadorPessoa.fazJogada();
                  }
       catch(NumberFormatException e) {
           System.out.println("Coordenada inválida! Digite uma coordenada válida.");
           jogadorPessoa.fazJogada();
       }

        if (tabuleiro1[linha][coluna] == null) {

            if (tabuleiro2[linha][coluna] == null) {
                tabuleiro1[linha][coluna] = "-";
                System.out.println("Ops... Tiro na água!");
            } else if (tabuleiro2[linha][coluna] == "N" || tabuleiro2[linha][coluna]  == "n") {
                tabuleiro1[linha][coluna] = "*";
                System.out.println("Parabéns... Submarino Atingido!");
                if (!nomeJogador.equalsIgnoreCase("COMPUTADOR")) {
                    placarPessoa++;
                } else {
                    placarMaquina++;
                }

            } else {
                System.out.println("Jogada Inválida. Tente novamente!");
                jogadorPessoa.fazJogada();
            }

        } else if (tabuleiro1[linha][coluna] == "N") {

            if (tabuleiro2[linha][coluna] == null) {
                tabuleiro1[linha][coluna] = "n";
                System.out.println("Ops... Tiro na água!");
            } else if (tabuleiro2[linha][coluna] == "N" || tabuleiro2[linha][coluna]  == "n") {
                tabuleiro1[linha][coluna] = "X";
                System.out.println("Parabéns... Submarino Atingido!");
                if (!nomeJogador.equalsIgnoreCase("COMPUTADOR")) {
                    placarPessoa++;
                } else {
                    placarMaquina++;
                }
            } else {
                System.out.println("Jogada Inválida. Tente novamente!");
                jogadorPessoa.fazJogada();
            }
        } else {
            System.out.println("Jogada Inválida. Tente novamente!");
            jogadorPessoa.fazJogada();
        }
            if (!nomeJogador.equalsIgnoreCase("COMPUTADOR")) {
            return placarPessoa;
        } else {
            return placarMaquina;
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