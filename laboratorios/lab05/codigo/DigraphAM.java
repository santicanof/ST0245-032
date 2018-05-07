import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
public class DigraphAM extends Graph
{
    private int [][] m;
    public DigraphAM(int size) {
        super(size);
        this.m = new int[size][size];
    }

    public int getWeight(int source, int destination) {
        return this.m[source][destination];
    }

    public void addArc(int source, int destination, int weight) {
        this.m[source][destination] = weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList <Integer> successors = new ArrayList<>();
        for(int i = 0; i <= m[vertex].length; i++) {
            if(m[vertex][i] != 0) {
                successors.add(i);
            }
        }
        return successors;
    }
}