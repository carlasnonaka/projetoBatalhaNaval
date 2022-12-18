package model;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {

    String[][] tabuleiro = new String[10][10];
    String[][] tabuleiro2 = new String[10][10];

    public String[][] imprimeTabuleiro(String[][] tabuleiro, String nomeJogador) {

        Jogador jogador = new Jogador();

        String letras[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.printf("---------------------------------------------\n" +
                "                 JOGADOR: %s                    \n" +
                "---------------------------------------------\n" +
                "|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |\n" +
                "---------------------------------------------\n", nomeJogador);

        for(int linha = 0; linha < tabuleiro.length; linha++ ){
            System.out.print("| "+letras[linha]+" ");
            for(int coluna = 0; coluna < tabuleiro.length; coluna++){
                if (tabuleiro[linha][coluna] == null) {
                    System.out.print("|   ");
                }else {
                    System.out.print("| " + tabuleiro[linha][coluna]+ " " );
                }
            }
            System.out.println("|");
        }
        System.out.println("---------------------------------------------\n");

        return tabuleiro;

    }

    public String[][] geradorSubmarino(String[][] tabuleiro) {

        Random gerador = new Random();

        int contador = 10;
        int linha, coluna;

        while (contador > 0) {
            linha = gerador.nextInt(10);
            coluna = gerador.nextInt(10);
            if (tabuleiro[linha][coluna] == null) {
                tabuleiro[linha][coluna] = "N";
            } else {
                contador++;
            }
            contador--;
        }
        return tabuleiro;
    }
}