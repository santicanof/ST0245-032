import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    private Node first;
    private int size;
    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }
   
    public Node firstGetter() {
        return this.first;
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return this.size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {
        if(index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if(this.size < 1) {
                Node n = new Node(data);
                this.first = n;
                n.next = null;
            } else {
                int count= 0; Node temp = first;
                for(int i = 0; i < index; i++) {
                    temp = temp.next;
                    count++;
                }
                Node n = new Node(data);
                getNode(count - 1).next = n;
                n.next = temp;
            }
            this.size++;
        }
    }

    //Borra el dato en la posición index
    public void remove(int index)
    {
        if(size < 0 || index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if(this.size <= 1) {
                this.first = null;

            } else {
                int count = 0; 
                Node temp = this.first;
                for(int i = 0; i < index; i++) {
                    temp = temp.next;
                    count++;
                }
                getNode(count - 1).next = getNode(count).next;

            }
            size--;
        }
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
        Node temp = this.first;
        for(int i = 0; i < this.size; i++) {
            if(temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}