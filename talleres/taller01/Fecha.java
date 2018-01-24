/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author usuario
 */
public class Fecha {
    
    
    public String dia; //Atributo del día
    public String año;//Atributo del mes
    public String mes;//Atributo del año
    public String fecha;//Atributo del String de la fecha

    public Fecha(String dia,String mes,String ano) { //Método constructor
        this.dia = dia;
        this.año = ano;
        this.mes = mes;
        fecha = ""+ano+mes+dia;
    }


    public String getDia() { //Método getter de día 
        return dia;
    }

    public void setDia(String dia) { //Método setter de día
        this.dia = dia;
    }

    public String getAño() { //Método getter de año
        return año;
    }

    public void setAño(String año) { //Método setter de año
        this.año = año;
    }

    public String getMes() { //Método getter de mes
        return mes;
    }

    public void setMes(String mes) { //Método setter de mes
        this.mes = mes;
    }

    public String toString() { //Método toString de la fecha
        return dia + "/" + año + "/" + mes;
    }

    //Método para comparar fechas en orden cronológico
    public String comparar(Fecha otraFecha){ 
        if(Integer.parseInt(fecha)<Integer.parseInt(otraFecha.fecha)){
            return "La fecha "+ toString()+" es antes que la fecha " + 
                    otraFecha.toString();
        }else if(Integer.parseInt(fecha)>Integer.parseInt(otraFecha.fecha)){
            return "La fecha "+ toString()+" es despues que la fecha " + 
                    otraFecha.toString();
        }else{
            return "Las fechas son iguales";
        }
        
    }   
   
}
