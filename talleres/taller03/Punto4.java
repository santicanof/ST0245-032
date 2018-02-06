
/**
 * Write a description of class Punto4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto4
{
    public static void perm3r(String s) {
        perm3r("", s);
    }
    private static void perm3r(String a, String s) {
        if(s.length() == a.length()) {
            System.out.println(a);
        } else {
            for(int i = 0; i < s.length(); i++) {
                perm3r(a + s.charAt(i), s);
            }
        }
        }
}
