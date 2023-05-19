/*
Negli anni 80 molti videogiochi &#x1F3AE; avevano una grafica "testuale" e cioè usavano i caratteri base del computer per disegnare a schermo.

Possiamo rappresentare un labirinto come una matrice di caratteri, in cui il carattere "-" rappresenta uno spazio vuoto, la "P" la posizione del giocatore e la "E" l’uscita.

Scrivete un programma che permette ad un utente di giocare al vostro labirinto. Per farlo potrà scrivere sulla console di java le lettere «WASD» per muoversi (come in molti videogiochi per PC). Quando il giocatore raggiunge il traguardo, verrà avvisato di aver vinto e il programma termina.

 */

import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("***** LABIRINTO *****");
        int dim;

        do {
            System.out.print("Inserisci la dimensione del labirinto: ");
            dim = input.nextInt();
            input.nextLine();
        } while (dim < 4);

        char[][] labirinto = inizializzaLabirinto(dim);
        visualizzaLabirinto(labirinto);

        int[] P = posizioneP(labirinto); // = {Riga, Colonna}
        int[] E = posizioneE(labirinto); // = {Riga, Colonna}

        String mossa;

        do {
            System.out.print("Fai la tua mossa: ");
            mossa = input.nextLine();

            switch (mossa) {
                case "w":
                    spostaSu(labirinto, P);
                    break;
                case "s":
                    spostaGiu(labirinto, P);
                    break;
                case "d":
                    spostaDx(labirinto, P);
                    break;
                case "a":
                    spostaSx(labirinto, P);
                    break;
                default:
                    System.exit(0);
                    break;
            }
            visualizzaLabirinto(labirinto);
            P = posizioneP(labirinto);

        } while (labirinto[P[0]][P[1]] != labirinto[E[0]][E[1]]);
        System.out.println("***** HAI VINTO!!! *****");

    }

    public static char[][] inizializzaLabirinto(int dim) {
        // char[][] labirinto = {{'-', '-', 'W', 'W', '-'}, {'-', 'W', '-', 'W', '-'}, {'P', 'W', '-', 'W', 'W'}, {'-', '-', 'W', '-', 'E'}, {'W', '-', '-', '-', 'W'}};
        char[][] labirinto = new char[dim][dim];

        Random r = new Random();

        String carrateri = "WW---";

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                labirinto[i][j] = carrateri.charAt(r.nextInt(carrateri.length()));
            }
        }

        labirinto[r.nextInt(labirinto[0].length)][0] = 'P';
        labirinto[r.nextInt(labirinto[0].length)][dim - 1] = 'E';
        int[] P = posizioneP(labirinto);
        int[] E = posizioneE(labirinto);

        if (!isSolvable(labirinto))
            return inizializzaLabirinto(dim);
        else {
            labirinto[P[0]][P[1]] = 'P';
            labirinto[E[0]][E[1]] = 'E';
            return labirinto;
        }
    }

    public static void visualizzaLabirinto(char[][] labirinto) {
        for (int i = 0; i < labirinto[0].length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] posizioneP(char[][] labirinto) {
        int[] posizioneP = new int[2];

        for (int i = 0; i < labirinto[0].length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                if (labirinto[i][j] == 'P') {
                    posizioneP[0] = i;
                    posizioneP[1] = j;
                }
            }
        }
        return posizioneP;
    }

    public static int[] posizioneE(char[][] labirinto) {
        int[] posizioneE = new int[2];

        for (int i = 0; i < labirinto[0].length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                if (labirinto[i][j] == 'E') {
                    posizioneE[0] = i;
                    posizioneE[1] = j;
                }
            }
        }
        return posizioneE;
    }

    public static char[][] spostaSu(char[][] labirinto, int[] posizioneP) {
        char temp;

        if (posizioneP[0] - 1 < 0)
            return labirinto;
        if (labirinto[posizioneP[0] - 1][posizioneP[1]] == '-' || labirinto[posizioneP[0] - 1][posizioneP[1]] == 'E') {
            labirinto[posizioneP[0] - 1][posizioneP[1]] = 'P';
            labirinto[posizioneP[0]][posizioneP[1]] = '-';
            return labirinto;
        } else
            return labirinto;
    }

    public static char[][] spostaGiu(char[][] labirinto, int[] posizioneP) {
        if (posizioneP[0] + 1 >= labirinto[0].length)
            return labirinto;
        if (labirinto[posizioneP[0] + 1][posizioneP[1]] == '-' || labirinto[posizioneP[0] + 1][posizioneP[1]] == 'E') {
            labirinto[posizioneP[0] + 1][posizioneP[1]] = 'P';
            labirinto[posizioneP[0]][posizioneP[1]] = '-';
            return labirinto;
        } else
            return labirinto;
    }

    public static char[][] spostaDx(char[][] labirinto, int[] posizioneP) {
        if (posizioneP[1] + 1 >= labirinto[0].length)
            return labirinto;
        if (labirinto[posizioneP[0]][posizioneP[1] + 1] == '-' || labirinto[posizioneP[0]][posizioneP[1] + 1] == 'E') {
            labirinto[posizioneP[0]][posizioneP[1] + 1] = 'P';
            labirinto[posizioneP[0]][posizioneP[1]] = '-';
            return labirinto;
        } else
            return labirinto;
    }

    public static char[][] spostaSx(char[][] labirinto, int[] posizioneP) {
        if (posizioneP[1] - 1 < 0)
            return labirinto;
        if (labirinto[posizioneP[0]][posizioneP[1] - 1] == '-' || labirinto[posizioneP[0]][posizioneP[1] - 1] == 'E') {
            labirinto[posizioneP[0]][posizioneP[1] - 1] = 'P';
            labirinto[posizioneP[0]][posizioneP[1]] = '-';
            return labirinto;
        } else
            return labirinto;
    }

    public static boolean isSolvable(char[][] labirinto) {
        int count = 0;
        int[] P = posizioneP(labirinto);
        int[] E = posizioneE(labirinto);

        Random r = new Random();

        while (labirinto[P[0]][P[1]] != labirinto[E[0]][E[1]] && count < 100 * labirinto[0].length) {
            count++;
            int numero = r.nextInt(4);
            switch (numero) {
                case 0:
                    spostaSu(labirinto, P);
                    break;
                case 1:
                    spostaGiu(labirinto, P);
                    break;
                case 2:
                    spostaDx(labirinto, P);
                    break;
                case 3:
                    spostaSx(labirinto, P);
                    break;
            }
            P = posizioneP(labirinto);
        }

        if (count < 100 * labirinto[0].length) {
            return true;
        } else
            return false;
    }
}
