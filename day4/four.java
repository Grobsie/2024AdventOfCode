package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class four { 
    public static String[][] getInput(String path) {
        int lineCount = 0;
        //String[] sad = {{"sad"},{}};
        String[][] dump = {{"sad"},{"is"},{"real"}};
        try {
            File input = new File(path);
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                dump[0][0] = myReader.nextLine();
                lineCount++; 
            }
            myReader.close(); 

            String[][] inputLine = new String[lineCount][];
            lineCount = 0;
            myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                inputLine[lineCount] = myReader.nextLine().split("");
                lineCount++;
            }
            myReader.close(); 
            return inputLine;
        } catch (FileNotFoundException e) {
        }
        return dump;
    }


    public static void main (String[] args) {
        //word find: for every position, check all directions for the word XMAS

        //get input and create array of arrays
        String[][] data = getInput("day4/4_input_test.txt");
        for (String[] i: data){
            for (String x: i){
                System.out.print(x + " ");
            }
            System.out.println("");
        }
    }
}
