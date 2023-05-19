//Scrivere un programma che, data in input una stringa s, restituisca true se s è palindroma, false altrimenti
public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("c"));
        System.out.println(isPalindrome("ciic"));
        System.out.println(isPalindrome("aaaa"));
        System.out.println(!isPalindrome("absca"));
        System.out.println(!isPalindrome("abbaa"));
        System.out.println(isPalindrome("zzzzz"));
        System.out.println(isPalindrome("zzczz"));
        System.out.println(isPalindrome("aabbaa"));
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        String var ="";

        for(int i=n-1;i>=0;i--) {
            var = var + s.charAt(i);
        }
        if(s.equals(var)) return true;
        else return false;
        //System.out.println(var);
    }
}
