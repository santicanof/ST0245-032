

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArbolGenealogicoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArbolGenealogicoTest
{
    //Para ejecutar la prueba, creé una instancia de ArbolGeneaoligicoTest e invoque el método setUp, que creará las personas que componen el árbol genealógico y ejecutará su impresión.
    private Persona Agus;
    private Persona Humberto;
    private Persona Liliana;
    private Persona Cruzana;
    private Persona Oswaldo;
    private ArbolGenealogico arbolGen1;

    public void setUp()
    {
        Agus = new Persona("Agustin", "m");
        Agus.addFamiliar("Humberto", "m");
        Humberto = Agus.right;
        Humberto.addFamiliar("Ricardo", "m");
        Humberto.addFamiliar("AliciaMadreHumberto", "f");
        Agus.addFamiliar("Liliana", "f");
        Liliana = Agus.left;
        Liliana.addFamiliar("Cruzana", "f");
        Cruzana = Liliana.left;
        Liliana.addFamiliar("Oswaldo", "m");
        Oswaldo = Liliana.right;
        Cruzana.addFamiliar("AliciaMadreCruzana", "f");
        Cruzana.addFamiliar("mario", "m");
        Oswaldo.addFamiliar("Rosmira", "f");
        Oswaldo.addFamiliar("Manuel", "m");
        arbolGen1 = new ArbolGenealogico(Agus);
        arbolGen1.imprimirArbol();
    }
}
