/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Punto2D {
    private float x; //Atributo coordenada X
    private float y; //Atributo coordenada Y

    public Punto2D(float x, float y) { //Método constructor
        this.x = x;
        this.y = y;
    }
    
    //Método que determina la distancia entre dos puntos:
    public float distancia(Punto2D otroPunto) {
        
        return (float) Math.sqrt(Math.pow(x-otroPunto.getX(),2) +
                Math.pow(y-otroPunto.getY(),2));
                
    }

    public float getX() { //Método getter de la coordenada X
        return x;
    }

    public float getY() { //Método getter de la coordenada Y
        return y;
    }
    
    public float radio() {
        return (float) Math.sqrt((x*x)+(y*y));
    }
    
    public float angulo() {
        return (float)  Math.atan2(x,y);    
    }

    
    
}
