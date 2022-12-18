package model;

import java.util.Scanner;
    public class Jogador {

        public String[][] tabuleiro;
       public String nome;

        public String fazJogada(){

            return "";
        }

        public String solicitaNomeDoJogador() {
            Scanner entrada = new Scanner(System.in);

            System.out.println("Digite o nome do jogador: ");
            this.nome = entrada.next().toUpperCase();

            return this.nome;

        }
}
