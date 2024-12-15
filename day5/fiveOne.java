package day5;

import java.io.File;
import java.util.Scanner;

public class fiveOne { 
    public static void main (String[] args) {
        try {
            File input = new File("5_input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                
            }
            myReader.close(); 
        } catch (Exception e){
            System.out.println("oopsie, an error occured. Have a look: " + e);
        }
    }
}
