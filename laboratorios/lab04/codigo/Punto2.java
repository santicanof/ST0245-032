/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class Punto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        EJERCICIO 2.1
        BinarySearchTree a= new BinarySearchTree();
        a.preToPost();        
         */

        /*

        EJERCICIO 2.2
        Scanner consola= new Scanner(System.in);
        String str = consola.nextLine();
        int n= str.indexOf("(");
        int suma=0;
        suma= Integer.parseInt(str.substring(0, n-1));
        str= str.substring(n+1);
        if(tus(str,suma)){
        System.out.println("yes");
        }else{
        System.out.println("no");
        }

         */
    }

    public static int metodo(String str){
        String[] cadenas;
        //str.replaceAll("\\)", "");
        str=str.replaceAll(" ","");
        cadenas=str.split("\\(");
        String str2="";
        boolean expresion=false;
        int suma=0;
        for (int i = 0; i < cadenas.length; i++) {

            if(cadenas[i].indexOf("))")!=-1){

                str2=str2.substring(0, str2.indexOf(cadenas[i-2]));
                expresion=true;

            }else if(cadenas[i].indexOf(")")!=-1 ){
                expresion= true;
            }else{
                if(i==cadenas.length-1){
                    str2= str2+ cadenas[i];
                }else{
                    str2= str2+ cadenas[i] +"(";
                }
            }
        }
        if(expresion){
            return metodo(str2);
        }

        for(int i = 0; i < cadenas.length; i++) {
            suma= suma + Integer.parseInt(cadenas[i]);

        }
        return suma;
    }

    public static boolean tus(String str, int suma){
        int x= str.indexOf("() ()");
        if(x==-1) return false;
        String s= str.substring(0, x);
        int y= s.lastIndexOf("(");
        if(y==-1) return false;
        if(metodo(s)==suma){
            return true;
        }else{
            s= str.substring(0, y) +str.substring(x+6);
            return tus(s, suma);

        }

    }
    
}
