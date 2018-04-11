
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

    public Node buscarPadre(int n) {
        if(this.root == null) {
            return null;
        } else if(n == this.root.data) {
            return this.root;
        } else {
            return buscarPadre(n, this.root);
        }
    }

    private Node buscarPadre(int n, Node r) {
        if(r == null) {
            return null;
        } else {
            if(n == r.right.data || n==r.left.data) {
                return r;
            } else if (n > r.data){
                return buscarPadre(n, r.right);
            }else {
                return buscarPadre(n, r.left);
            }
        }
    }    

    public void borrar(int n) {
        if(buscarPadre(n) == null) {
            this.root=null;
        } else{
            BinarySearchTree a= this;
            Node x;
            if(buscarPadre(n).right.data==n){
                x=buscarPadre(n).right;
                buscarPadre(n).right=null;
            }else{
                x=buscarPadre(n).left;
                buscarPadre(n).left=null;
            }
            borrar(x);
        }
    }

    private void borrar(Node r) {
        if(r.left!=null){
            insertar(r.left.data);
            borrar(r.left);
        }
        if(r.left!=null){
            insertar(r.right.data);
            borrar(r.right);
        }
    }
}
