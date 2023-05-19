/*Il quadrato di un numero N non è altro che la somma dei primi N numeri dispari.
Per esempio 9 = 5+3+1 e 36 = 11+9+7+5+3+1
Scrivete un programma che preso in input un numero N restituisce il quadrato di N utilizzando questo metodo!*/

import java.util.Scanner;

public class EsercizioA {

    public static void main(String[] args) {
        int n;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number:");
        n = input.nextInt();
        System.out.println(Square(n));

    }

    public static int Square(int n) {
        int nRoot = 0;
        for (int i = 1; i <= n; i++) {
            nRoot = nRoot + (2*i-1);
        }
        return nRoot;
    }
}
