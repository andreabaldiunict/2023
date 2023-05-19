/*
Dato un array di interi (inseriti dall’utente, separati da virgola e senza spazi),
 effettuare la conversione dei valori in interi e stampare in ordine minimo e massimo 
 (separati da virgola). 
Gli interi inseriti possono anche assumere valori negativi.
 */

import java.util.Arrays;
import java.util.Scanner;

public class MinimoMassimo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated):");
        String a = sc.nextLine();
        int[] values = parseNumbers(a);
        computeMinAndMax(values);

    }
 
    static int[] parseNumbers(String s) {
        String[] var;
        var = s.split(",");
        int [] conv = new int[var.length];
        for(int i=0; i<var.length; i++){
            conv[i] = Integer.parseInt(var[i]);
        }
        return conv;
    }
 
    static void computeMinAndMax(int[] values) {
        int min = values[0];
        int temp = 0;
        int index = 0;

        for (int i = 0; i < values.length-1; i++) {
            min = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < values[min]) min = j;
            }

            temp = values[i];
            values[i] = values[min];
            values[min] = temp;
        }
        System.out.println(Arrays.toString(values));
    }
}