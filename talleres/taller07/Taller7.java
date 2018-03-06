
/**
 * Write a description of class Taller7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller7
{
    private static int maximo(Node n) {
        if(n.next == null) {
            return n.data;
        } else {
            return Math.max(n.data, maximo(n.next));
        }
    }

    public static int maximo(LinkedListMauricio l) {
        if(l.firstGetter() == null) {
            throw new NullPointerException();
        }else {
            return maximo(l.firstGetter());
        }
    }

    public static boolean iguales(LinkedListMauricio l, LinkedListMauricio s) {
        if(l.size() != s.size()) {
            return false;
        }

        Node temp1 = l.firstGetter(); Node temp2 = s.firstGetter();
        for(int i = 0; i < l.size(); i++) {
            if(temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next; temp2 = temp2.next;
        }
        return true;
    }
}
