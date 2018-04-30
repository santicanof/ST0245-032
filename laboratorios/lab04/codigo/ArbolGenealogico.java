
/**
 * Write a description of class ArbolGenealogico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolGenealogico
{
    Persona root; 
    ArbolGenealogico(Persona r) {
        this.root = r;
    }

    public void imprimirArbol() {
        ImprimirArbol(this.root);
    }

    private void ImprimirArbol(Persona p) {
        if(p != null) {
            ImprimirArbol(p.left);
            ImprimirArbol(p.right);
            System.out.println(p.nombre);
            
            
        }
        // if(p.left == null && p.right == null) {
            // System.out.println(p.nombre + " es una de las bases del árbol");
        // } else if(p.right == null) {
            // System.out.println("La madre de " + p.nombre + " es " + p.left.nombre + "y no se conoce el nombre del padre");
            // ImprimirArbol(p.left);
        // } else if(p.left == null) {
            // System.out.println("El padre de " + p.nombre + " es " + p.left.nombre + "y no se conoce el nombre de la madre");
            // ImprimirArbol(p.right);
        // } else {
            // System.out.println("El padre de " + p.nombre + " es " + p.right.nombre + " y su madre es " + p.left.nombre);
            // ImprimirArbol(p.left);
            // ImprimirArbol(p.right);
        // }
        
    }
}
