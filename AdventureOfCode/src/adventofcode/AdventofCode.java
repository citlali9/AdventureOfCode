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
import java.util.Scanner;

/**
 *
 * @author cielo
 */
public class AdventofCode {

    Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {

        FileReader fr;
        BufferedReader bf;
        System.out.println("Welcome to Adventure of Code");

        Scanner sc = new Scanner(System.in);

        boolean working = true;
        while (working) {
            System.out.println(" **************************** ");
            System.out.println("Select Adventure Code's day: ");
            System.out.println("1.- Day 1 ");
            System.out.println("2.- Day 2");
            System.out.println("3.- Day 4");
            System.out.println("4.- Go out");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("select the option to process");
                    System.out.println("1-. puzzle input  ");
                    System.out.println("2-. Test input");

                    int inputFile = sc.nextInt();
                    if (inputFile == 1) {
                        fr = new FileReader(System.getProperty("user.dir") + "/input");
                    } else {
                        fr = new FileReader(System.getProperty("user.dir") + "/test_1");
                    }
                    bf = new BufferedReader(fr);
                    Day_1 dia_1 = new Day_1(bf);
                    dia_1.getPuzzle();
                    break;
                case 2:
                    System.out.println("select the option to process");
                    System.out.println("1-. puzzle input  ");
                    System.out.println("2-. Test input for exersice A");
                    System.out.println("3-. Test input for exersice B");
                    int inputFile_2 = sc.nextInt();

                    switch (inputFile_2) {
                        case 1:
                            fr = new FileReader(System.getProperty("user.dir") + "/input2");
                            break;
                        case 2:
                            fr = new FileReader(System.getProperty("user.dir") + "/test_2a");
                            break;
                        case 3:
                            fr = new FileReader(System.getProperty("user.dir") + "/test_2b");
                            break;
                        default:
                            fr = new FileReader(System.getProperty("user.dir") + "/input2");
                            break;
                    }
                    bf = new BufferedReader(fr);
                    Day_2 day_2 = new Day_2(bf);
                    day_2.day_2a();
                    break;

                case 3:
                    System.out.println("select the option to process");
                    System.out.println("1-. puzzle input  ");
                    System.out.println("2-. Test input");

                    int inputFile_4 = sc.nextInt();
                    if (inputFile_4 == 1) {
                        fr = new FileReader(System.getProperty("user.dir") + "/input4");
                    } else {
                        fr = new FileReader(System.getProperty("user.dir") + "/test_4");
                    }

                    bf = new BufferedReader(fr);
                    Day_4 day_4 = new Day_4(bf);
                    day_4.day_4();
                    break;
                case 4:
                    working = false;
                    break;
                default:
                    System.out.println("option is wrong try again");
            }
        }
    }
}
