package taller5;

/**
 *
 * @author 
 */
public class Taller5 {

    
    
    public static int tablas(int n){
        int h=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                h=h+i*j;
                
            }
            
        }
        return h;
    }
    
    
    public static void ordenar(int []arr){
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            j=i;
            while(j>0 && arr[j-1]> arr[j]){
                int temp= arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j=j-1;
            }
        }
    }
    
    
    public static int arraySum(int[] A) {
        int suma = 0;
        for(int i = 0 ; i < A.length ; i++){
            suma= suma+ A[i];
        }        
        return suma;
    }
    
    
    public static int[] rand(int n){
        int[] a = new int[n];
        for(int i = 0 ; i < a.length ; i++){
            a[i] = (int)(Math.random()*10);
        }
        return a;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        TABLAS
        for (int i = 10000; i <= 50000; i=i+1000) {
            long ahora=System.currentTimeMillis();
            tablas(i);
            long despues= System.currentTimeMillis();
            long meDemore= despues-ahora;
            System.out.println(i+ " " + meDemore);
        }
        */
        for(int i = 10000; i <= 50000 ; i+= 1000){
            int[] m = rand(i);
            long ahora=System.currentTimeMillis();
            int suma=arraySum(m);
            long despues= System.currentTimeMillis();
            long meDemore= despues-ahora;
            System.out.println(i+ " " + meDemore );
        }
        
        
        
        /*
        ORDENAMIENTO
        for(int i = 10000; i <= 50000 ; i+= 1000){
            int[] m = rand(i);
            long ahora=System.currentTimeMillis();
            ordenar(m);
            long despues= System.currentTimeMillis();
            long meDemore= despues-ahora;
            System.out.println(i+ " " + meDemore);
        }
        
        */
        
    }
    
}
