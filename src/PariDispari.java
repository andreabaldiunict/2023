/*Dato un numero, stampare true se il numero è pari, false altrimenti.
Suggerimento: inserite il codice della vostra soluzione all’interno del metodo checkEvenOdd del codice che trovate a questo indirizzo:*/
import java.util.Scanner;

public class PariDispari {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number:");
        int number =sc.nextInt();
        checkEvenOdd(number);
    }

    private static void checkEvenOdd(int number) {
        if(number%2==0){
            System.out.println("Il numero "+ number + " è pari: "+ true);
        }else{
            System.out.println("Il numero "+ number + " è dispari: "+ false);
        }
    }
}

