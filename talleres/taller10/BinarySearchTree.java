
/**
 * Write a description of class BinarySearchTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BinarySearchTree
{
    public Node root;
    public BinarySearchTree() {
        this.root = null;
    }

    public void insertar(int n) {
        if(this.root == null) {
            this.root = new Node(n);
        } else {
            insertar(n, this.root);  
        }
    }

    private void insertar(int n, Node r) {
        Node temp = new Node(n);
        if(n < r.data) {
            if(r.left == null) {
                r.left = temp;
            } else {
                insertar(n, r.left);
            }
        }else {
            if(r.right == null) {
                r.right = temp;
            } else {
                insertar(n, r.right);
            }
        }
    }  

    public boolean buscar(int n) {
        if(this.root == null) {
            return false;
        } else if(n == this.root.data) {
            return true;
        } else {
            return buscar(n, this.root);
        }
    }

    private boolean buscar(int n, Node r) {
        if(r == null) {
            return false;
        } else {
            if(n == r.data) {
                return true;
            } else if (n > r.data){
                return buscar(n, r.right);
            }else {
                return buscar(n, r.left);
            }
        }
    }    

    public void borrar(int n) {
        if(buscar(n) == false) {
            System.out.println("El elemento no se encuentra en el árbol");
        } else {
            borrar(n, this.root);
        }
    }

    private void borrar(int n, Node r) {
        
    }
}
