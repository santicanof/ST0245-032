
/**
 * Write a description of class Punto4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto3
{
    public static void perm3(String s) {
        perm3("", s);
    }
    private static void perm3(String a, String s) {
        if(s.length() == 0) {
            System.out.println(a);
        } else {
            for(int i = 0; i < s.length(); i++) {
                perm3(a + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
            }
        }
        }
    }

