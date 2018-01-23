/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author aricop
 */
public class Punto2D {
    private float x;
    private float y;

    public Punto2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public float distancia(Punto2D otroPunto) {
        return (float) Math.sqrt(Math.pow(x-otroPunto.getX(),2) +
                Math.pow(y-otroPunto.getY(),2));
                
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    public float radio() {
        return (float) Math.sqrt((x*x)+(y*y));
    }
    
    public float angulo() {
        return (float)  Math.atan2(x,y);    
    }

    
}
