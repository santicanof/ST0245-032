//Una tabla de hash donde la llave es un String y el valor un int.
import java.util.HashMap;
import java.util.LinkedList;
public class UnaTablaDeHash
{
    private int[] tabla;
    
    public UnaTablaDeHash(){
        tabla = new int[10];
    }

    private int funcionHash(String k){
        if(k.length() == 0) {
            return 0;
        } 
        int h = 0;
        for(int i = 0; i < k.length(); i++) {
            h += (int)k.charAt(0) + (int)k.charAt(k.length() - 1) * Math.pow(2,(int)k.charAt(i));
        }
        return h%10;
    }

    public int get(String k){
        int n = funcionHash(k);
        return tabla[n];
    }
    
    public void put(String k, int v){
        tabla[v] = funcionHash(k);
    }
}