/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cielo
 */
public class Day_2 {

    private BufferedReader bf;
    public static  String resultB; 
    public static int resultA;
    
    public Day_2() {
    }

    public Day_2(BufferedReader bf) {
        this.bf = bf;
    }

    public void day_2a() throws IOException {

        ArrayList<String> f = new ArrayList<>();
        String sCadena;
        while ((sCadena = bf.readLine()) != null) {
            f.add(sCadena);
        }
        StringBuilder srBuilder;
        char index;
        int uno1 = 1;
        int dos2 = 2;
        char compara;
        int finalDos = 0;
        int finalTres = 0;
        int tres = 0;
        int dos = 0;
        // inicia a iterar todos los elementos del array
        for (String worldId : f) {
            dos = 0;
            tres = 0;
            srBuilder = new StringBuilder(worldId);
            for (int i = 0; i < srBuilder.length(); i++) {
                index = srBuilder.charAt(i);
                int considens = 0;
                for (int j = i + 1; j < srBuilder.length(); j++) {
                    compara = srBuilder.charAt(j);
                    if (index == compara) {
                        considens = considens + 1;
                        srBuilder.deleteCharAt(j);
                        j = j - 1;
                    }
                }// Termina de iterar la letra
                if (considens == uno1) {
                    dos = dos + 1; 
                } else if (considens == dos2) {
                    tres = tres + 1;
                }
            } // termina de iterar la palabra completa
            if (tres >= 1) {
                finalTres = finalTres + 1;
            }
            if (dos >= 1) {
                finalDos = finalDos + 1;
            }
        }
        //System.out.println("se repite 2 veces: " + finalDos +"se repite 3 veces: " + finalTres);
        resultA = finalTres * finalDos;
        System.out.println("Result Day 2 exercise A : " + resultA);
        day_2b(f);
    }

    public void day_2b(ArrayList<String> x) throws IOException {
        int i = 0;
        int suma = 0;
        String compara1, compara2;
        //itera el array
        for (i = 0; i < x.size(); i++) {
            compara1 = x.get(i);
            //itera todo el array para comparar por cada letra en todas las otras cadenas
            for (int j = i + 1; j < x.size(); j++) {
                compara2 = x.get(j);
                suma = 0;
                for (int k = 0; k < compara1.length(); k++) {
                    if (compara1.charAt(k) == compara2.charAt(k)) {
                        suma = suma + 1;
                    }
                }
                if (suma == compara1.length() - 1) {
                    resultB = findString(compara2, compara1);
                    System.out.println("Result Day 2 exercise B : "+ resultB);
                }
            }
        }
    }

    private String findString(String one, String two) {
        char[] cadenaOne = one.toCharArray();
        char[] cadenaTwo = two.toCharArray();
        String n = "";
        for (int i = 0; i < cadenaOne.length; i++) {
            if (cadenaOne[i] == cadenaTwo[i]) {
                n += cadenaOne[i];
            }
        }
        return n;
    }
}
