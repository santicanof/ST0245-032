/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Counter {
    private String id; //Atributo del nombre del contador
    private int cont = 0; //Atributo encargado de contar

    public Counter(String id) { //Método constructor
        this.id = id;
    }
    
    public void incrementar() { // Método de incrmentar el contador en +1
       cont += 1;
    }
    
    public int incrementos() { //Método getter del atributo encargado de contar
        return cont;
    }
    
    public String toString() { //Método toString del estado del contador
        return "El contador está en" + cont;
    }
       
}
