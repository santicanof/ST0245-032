
/**
 * Write a description of class Punto2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto2
{
    //Punto 2
    public static void combs(String s) {
        combs("",s);
    }
    private static void combs(String a, String s) {
        if(s.length() == 0) {
            System.out.println(a);
        } else {
            combs(a + s.charAt(0),s.substring(1));
            combs(a, s.substring(1));
        }
    }
    public static void a(String s) {
        System.out.println((s.length())+(s));
    }
}
