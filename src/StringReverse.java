/*Scrivere un metodo che, data una stringa s in input, ne stampi il reverse, ossia la
stringa al contrario. Esempio: data la stringa «ciao», dovrà stampare «oaic».*/
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        stringReverse(a);
    }

    static void stringReverse(String s) {
        int n = s.length();
        String var ="";

        for(int i=n-1;i>=0;i--) {
            var = var + s.charAt(i);
        }
        System.out.println(var);
    }
}
