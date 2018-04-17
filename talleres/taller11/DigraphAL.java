import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
public class DigraphAL extends Graph
{
    private LinkedList [] l;
    public DigraphAL(int size) 
    {
        super(size);
        this.l = new LinkedList[size];
    }

    public void addArc(int source, int destination, int weight) {
        Pareja p = new Pareja(destination, weight);
        l[source].add(p);
    }

    public int getWeight(int source, int destination) {
        LinkedList <Pareja> temp = l[source];
        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getVertice() == destination) {
                return temp.get(i).getWeight();
            }
        }
        return 0;
    }

    public ArrayList<Integer> getSuccessors(int vertice) {
        LinkedList <Pareja> temp = l[vertice];
        ArrayList <Integer> arr = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getWeight() != 0) {
                arr.add(temp.get(i).getVertice());
            }
        }
        return arr;
    }
}
