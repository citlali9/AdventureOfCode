/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cielo
 */
public class Day_1 {
   
    private ArrayList<Integer> frequencies;
    private BufferedReader bf; 
    public int resultA;
    public int resultB;
    
    public Day_1(){}
    public Day_1(BufferedReader bf){
    this.bf = bf;
    }
    
public void getPuzzle() throws FileNotFoundException, IOException{
        ArrayList<Integer> f = new ArrayList<>();
        frequencies = new ArrayList<>();
        int suma = 0;
        int total= 0;
        //Leer Archivo  
        String sCadena;
        while ((sCadena = bf.readLine())!=null) {
            f.add(Integer.valueOf(sCadena));
        }
        Boolean duplicated = false;
        boolean opt = true;
        /* Metodo que se encarga de sumar todos los elementos encontrados en el archivo
        ** El metodo suma se itera hasta encontrar la primera coincidencia 
        */
        do{
            int i;
            for(i = 0; i<f.size(); i++){
                suma = suma + f.get(i);
                if(firstTwise(suma)){
                    duplicated= true;
                    break;
                }
                frequencies.add(suma);
            }
            if(opt){
                total = suma;
                opt= false;
                resultA = total;
                System.out.println("Result Day 1 exercise A : " + total);
                System.out.println("Please wait for result B ");
            }
        }while(!duplicated); 
        System.out.println("Result Day 1 exercise B : "+ suma);
        resultB = suma;
    }   

    private boolean firstTwise(int suma) {
        for(int firstFrecuency: frequencies){
            if(suma == firstFrecuency){
                return true;
            }
        }
         return false;
    }
}
