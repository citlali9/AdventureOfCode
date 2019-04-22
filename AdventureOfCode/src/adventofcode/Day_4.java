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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author cielo
 */
public class Day_4 {
    
    private BufferedReader bf; 
    public int resultA;
    public int resultB;
    
    public Day_4(){}
    public Day_4(BufferedReader bf){
    this.bf = bf;
    }

    public void day_4() throws FileNotFoundException, IOException, ParseException {
        ArrayList<String> z = new ArrayList<>();

        ArrayList<Integer> ordenada;
        ArrayList<Integer> horasGuard = new ArrayList<>();

        ArrayList<Guard> masMinutos = new ArrayList<>();
        Guard guard;

        String sCadena;
        while ((sCadena = bf.readLine()) != null) {
            z.add(sCadena);
        }   
        Collections.sort(z, Collections.reverseOrder());

        int fall = 0;
        int wake = 0;
        int sumaSleep = 0;
        int timeSleep = 0;
        String prueba = z.get(0);
        String idGuard;
        String finaly = "";
        boolean letConteo = false;
        // itera el array pero obteniendo solo los id para cada guardia
        for (int j = z.size() - 1; j >= 0; j--) {
            String ida = z.get(j).substring(19, 20);
            /* permite iterar la lista ordenada para cada id correspondiente
            ** para todos los datos encontrados que correspondan a ese "id"
            */
            if (ida.equals("G")) {
                String id = z.get(j).substring(26, 30);
                sumaSleep = 0;
                ordenada = new ArrayList<>();
                for (int i = z.size() - 1; i >= 0; i--) {
                    String value = z.get(i).substring(19, 20);
                    switch (value) {
                        case "G":
                            idGuard = z.get(i).substring(26, 30);
                            if (id.equals(idGuard)) {
                                letConteo = true;
                            } else {
                                letConteo = false;
                            }
                            break;
                        case "f":
                            if (letConteo) {
                                fall = Integer.parseInt(z.get(i).substring(15, 17));
                                ordenada.add(fall);
                            }
                            break;
                        case "w":
                            if (letConteo) {
                                wake = Integer.parseInt(z.get(i).substring(15, 17));
                                sumaSleep = sumaSleep + (wake - fall);
                                ordenada.add(wake);
                            }
                            break;
                    }
                }
                if (sumaSleep > timeSleep) {
                    finaly = id;
                    timeSleep = sumaSleep;
                    horasGuard = ordenada;
                }
                guard = new Guard();
                guard.setIdGuard(id);
                guard.setDuerme(ordenada);
                masMinutos.add(guard);
            }
        }

        int[] dia = ordenarMinutos(horasGuard);
        int valor = getNumber(finaly);
        resultA =(dia[0] * valor);
        System.out.println("Result Day 2 exercise A : " + (dia[0] * valor));
        Strategy_2(masMinutos);

    }

    private void Strategy_2(ArrayList<Guard> masMinutos) {

        String id = "";
        int[] suma = new int[]{0, 0};
        int sleeping = 0;
        int daySleep = 0;

        for (Guard guard : masMinutos) {
            suma = ordenarMinutos(guard.getDuerme());
            if (suma[1] > sleeping) {
                id = guard.getIdGuard();
                sleeping = suma[1];
                daySleep = suma[0];
            }
        }

        resultB = getNumber(id) * daySleep;
        System.out.println("Result Day 2 exercise B : " + resultB );
    }

    /**
     * ordenarMinutos, of class Day_4.
     * ordena los minutos de tal forma obtener en que minuto durmio mas un 
     * determinado guardia
     */
    private int[] ordenarMinutos(ArrayList<Integer> numbers) {
        ArrayList<Integer> ordenada = new ArrayList<>();
        for (int k = 0; k < 61; k++) {
            ordenada.add(0);
        }
        for (int i = 0; i < numbers.size(); i = i + 2) {
            for (int j = numbers.get(i); j < numbers.get(i + 1); j++) {
                ordenada.set(j, ordenada.get(j) + 1);
            }
        }
        int[] array = new int[]{0, 0};
        int dia = 0;
        int valor = 0;
        /* una vez obtenido las veces que duerme el guardia por minuto, 
         * se determina en cual minuto durmio mas veces 
        */
        for (int j = 0; j < ordenada.size(); j++) {
            if (ordenada.get(j) > valor) {
                dia = j;
                valor = ordenada.get(j);
            }
        }
        array[0] = dia;
        array[1] = valor;
        return array;
    }

    private int getNumber(String id) {

        char[] cadenaId = id.toCharArray();
        String n = "";
        for (int i = 0; i < cadenaId.length; i++) {
            if (Character.isDigit(cadenaId[i])) {
                n += cadenaId[i];
            }
        }
        return Integer.parseInt(n);
    }
}
