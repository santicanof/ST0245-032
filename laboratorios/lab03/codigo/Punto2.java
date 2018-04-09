import java.util.*;
/**
 * Write a description of class Punto2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto2
{
    public static void punto22(){
        LinkedList<String> linked = new LinkedList<>();
        Scanner consola= new Scanner(System.in);
        String letter= consola.nextLine();
        String sub="";
        boolean inicio=true;
        for (int i = 0; i < letter.length(); i++) {
            if(letter.charAt(i)=='['){
                if(!inicio){
                    linked.addFirst(sub);
                }else{
                    linked.add(sub);
                }
                sub="";
                inicio=true;
                continue;
            }
            if(letter.charAt(i)==']'){
                if(!inicio){
                    linked.add(sub);
                }else{
                    linked.addFirst(sub);
                }
                sub="";
                inicio=false;
                continue;
            }
            if(i==letter.length() -1 && (letter.charAt(i)!=']' || letter.charAt(i)!='[' )){
                sub=sub+letter.charAt(i);
                if(!inicio){
                    linked.add(sub);
                }else{
                    linked.addFirst(sub);                        
                }
                sub="";
            }
            sub=sub+letter.charAt(i);
        }
        
        for (int i = 0; i < linked.size(); i++) {
            System.out.print(linked.get(i));
        }
        
    }
}
