import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class Taller8 {

    //Punto 1
    public static Stack<Integer> inversa(Stack<Integer> stack){
        Stack <Integer> inversa = new Stack<>();
        while(stack.empty() == false) {
            Integer i = stack.pop();
            inversa.push(i);
        }
        return inversa;
    }

    //Punto 2
    public static void cola (Queue<String> queue){
        while(queue.isEmpty() == false) {
            String s = queue.poll();
            System.out.println("Atendiendo a" + " " + s);
        }
    }

    //notacion polaca
    public static int polaca  (String string){
        Stack <Integer> pila = new Stack();
        for(String s : string.split(" ")) {
            if(s.equals("+")) {
                pila.push(pila.pop() + pila.pop());
            }else if(s.equals("*")) {
                pila.push(pila.pop() * pila.pop());
            }else if(s.equals("/")) {
                int temp1 = pila.pop();
                int temp2 = pila.pop();
                pila.push(temp2/temp1);
            }else if(s.equals("-")){
                int temp1 = pila.pop();
                int temp2 = pila.pop();
                pila.push(temp2 - temp1);
            }else {
                pila.push(Integer.parseInt(s));
            }
        }
        return pila.pop();
    }
}