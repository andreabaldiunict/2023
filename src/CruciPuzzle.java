import java.util.Locale;
import java.util.Scanner;

public class CruciPuzzle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\n********* CRUCIPUZZLE **********");
        char[][] cruciverba = inizializzaCruci();
        String scelta;
        String parola;

        VisualizzaCruci(cruciverba);

        System.out.print("Inserisci una parola: ");
        parola = input.nextLine();

        System.out.println("\n---ORIZZONTALE: "+ cercaOrizzontale(cruciverba,parola.toUpperCase()));
        System.out.println("-----VERTICALE: "+ cercaVerticale(cruciverba,parola.toUpperCase()));

        System.out.print("\nVuoi effettuare la ricerca in senso inverso? (S/N): ");
        scelta = input.nextLine();
        scelta = scelta.toUpperCase();

        if(scelta.equals("S")){
            System.out.println("\n---ORIZZONTALE: "+ cercaOrizzontale(cruciverba,stringReverse(parola.toUpperCase())));
            System.out.println("-----VERTICALE: "+ cercaVerticale(cruciverba,stringReverse(parola.toUpperCase())));
        }

    }
    public static char[][] inizializzaCruci() {

        char[][] cruciverba = {
                {'H', 'D', 'G', 'U', 'P', 'Y', 'S', 'P', 'A', 'O'},
                {'T', 'S', 'A', 'K', 'O', 'Y', 'O', 'L', 'P', 'S'},
                {'R', 'C', 'M', 'C', 'N', 'R', 'I', 'A', 'A', 'B'},
                {'I', 'O', 'B', 'A', 'I', 'S', 'C', 'T', 'L', 'A'},
                {'G', 'R', 'E', 'L', 'F', 'A', 'C', 'E', 'O', 'L'},
                {'L', 'F', 'R', 'A', 'L', 'L', 'U', 'S', 'I', 'E'},
                {'I', 'A', 'E', 'M', 'E', 'M', 'L', 'S', 'L', 'M'},
                {'A', 'N', 'T', 'A', 'D', 'O', 'C', 'A', 'G', 'A'},
                {'J', 'O', 'T', 'R', 'B', 'N', 'D', 'G', 'O', 'D'},
                {'L', 'Y', 'O', 'O', 'U', 'E', 'S', 'M', 'S', 'M'}
        };

        return cruciverba;
    }

    public static void VisualizzaCruci(char[][] stampa_cruci){
        System.out.println("+------------------------------+");
        for(int i=0; i<stampa_cruci[0].length;i++){
            System.out.print("|");
            for(int j=0; j<stampa_cruci[0].length; j++){
                System.out.print(" "+stampa_cruci[i][j]+" ");
            }
            System.out.print("|");
            System.out.println(" ");
        }
        System.out.println("+------------------------------+");
    }

    public static boolean cercaOrizzontale(char[][] controlla_cruci, String parola) {
        int count = 0;

        for(int i = 0; i<controlla_cruci[0].length; i++){
            for(int j = 0; j<controlla_cruci[0].length; j++) {
                if(controlla_cruci[i][j] == parola.charAt(0) && parola.length() + j - controlla_cruci[0].length <=0) {
                    for(int k = 1; k<parola.length(); k++) {
                        if(controlla_cruci[i][j+k] == parola.charAt(k)) {
                            count++;
                        }
                        else
                            break;
                    }

                    if(count == parola.length()-1)
                        return true;
                    else
                        count = 0;
                }
            }
        }

        return false;
    }

    public static boolean cercaVerticale(char[][] controlla_cruci, String parola) {
        int count = 0;

        for(int j = 0; j<controlla_cruci[0].length; j++) {
            for(int i = 0; i<controlla_cruci[0].length; i++){
                if(controlla_cruci[i][j] == parola.charAt(0) && parola.length() + i - controlla_cruci[0].length <=0) {
                    for(int k = 1; k<parola.length(); k++) {
                        if(controlla_cruci[i+k][j] == parola.charAt(k)) {
                            count++;
                        }
                        else
                            break;
                    }

                    if(count == parola.length()-1)
                        return true;
                    else
                        count = 0;
                }
            }
        }

        return false;
    }

    static String stringReverse(String s) {
        int n = s.length();
        String var ="";

        for(int i=n-1;i>=0;i--) {
            var = var + s.charAt(i);
        }
        return var;
    }

}



