package model;
import java.util.Random;

public class JogadorMaquina extends Jogador {

    public JogadorMaquina() {
        this.tabuleiro  = new String[10][10];
           }

    @Override
    public String fazJogada() {
        String letras[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String numero[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random gerador = new Random();
        Partida partida = new Partida();

        String letra, coluna, jogada;

        System.out.println("Iniciando Jogada do Computador!");

        letra = letras[gerador.nextInt(10)];
        coluna = numero[gerador.nextInt(10)];

        jogada = letra+coluna;

        System.out.println("Jogada do Computador! " + letra +" " + coluna);

        return jogada;



    }
}