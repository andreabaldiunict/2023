//Scrivere un metodo che, dato un char a e una stringa b, stampa il numero di occorrenze di a in b.
import java.util.Scanner;
import java.lang.String;

public class ContaOccorrenze {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter character a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b =sc.nextLine();
        countOccurrences(a.charAt(0), b);
        ciao
    }

    static void countOccurrences(char a, String b) {
        int n = b.length();
        int c=0;
        for(int i=0;i<n;i++) {
            if(b.charAt(i)==a) {
                c++;
            }
        }
        System.out.println(c);
    }
}

