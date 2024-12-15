package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fiveOne { 
    public static void main (String[] args) {
        int lineCount = 0;
        String[] dump = {"12","12"};

        try {
            File input = new File("day5/5_decode.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                dump[0] = myReader.nextLine();
                lineCount++; 
            }
            myReader.close();
            int[][] valuePairs = new int[lineCount][];
            lineCount = 0;
            Scanner myReaderTwo = new Scanner(input);
            while (myReaderTwo.hasNextLine()){
                String[] valuePairString = myReaderTwo.nextLine().split("\\|");
                int firstValue = Integer.valueOf(valuePairString[0]);
                int secondValue = Integer.valueOf(valuePairString[1]);
                System.out.println(firstValue + " | " + secondValue);
                valuePairs[lineCount] = new int[]{firstValue,secondValue};
                lineCount++;
            }
            myReaderTwo.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }       
    }
}
