import java.util.HashMap;
/**
 *
 * @author 
 */
public class Taller9{
    public static void main (String [] args) {
        HashMap<String, String> m = new HashMap<>();

        //Punto 2
        agregar(m, "Google", "Estados Unidos");
        agregar(m, "La Locura", "Colombia");
        agregar(m, "Nokia", "Finlandia");
        agregar(m, "Sony", "Japon");

        //Punto 3
        buscar(m, "Google");
        buscar(m, "Motorola");
        
        //Punto 4
        m.containsValue("India");
        m.containsValue("Estados Unidos");
    }

    public static void agregar(HashMap empresas,String empresa,String pais){
        empresas.put(empresa, pais);
    }

    public static void buscar(HashMap empresas,String empresa){
        if(empresas.containsKey(empresa) == true) {
            empresas.get(empresa);
        } else {
            System.out.println("La tabla no contiene la empresa " + empresa);
        }
    }

    public static boolean contienekey(HashMap empresas,String pais){
        return empresas.containsValue(pais);
    } 
}
