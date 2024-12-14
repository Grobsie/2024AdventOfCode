package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fourTwo { 
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
        int xmasCounter = 0;
        //get input and create array of arrays
        String[][] data = getInput("day4/4_input_test.txt");

        for (int colValue = 0; colValue < data.length ; colValue++){
            for (int rowValue = 0; rowValue < data[0].length ; rowValue++){
                if (data[colValue][rowValue].equals("A")) {
                    boolean left = false;
                    boolean right = false;
                    //look for surroundings, if out of bounds error just continue with the next
                    try {
                        //check if \ contains MAS or SAM
                        if (data[colValue-1][rowValue-1].equals("M") && data[colValue+1][rowValue+1].equals("S")){
                            left = true;
                        } else if (data[colValue-1][rowValue-1].equals("S") && data[colValue+1][rowValue+1].equals("M")){
                            left = true;
                        }
                        // check if / contains MAS or SAM
                        if (data[colValue-1][rowValue+1].equals("M") && data[colValue+1][rowValue-1].equals("S")){
                            right = true;
                        } else if (data[colValue-1][rowValue+1].equals("S") && data[colValue+1][rowValue-1].equals("M")){
                            right = true;
                        }
                        //if both match report it
                        if (left && right) {
                            System.out.println("founda a hit at " + colValue + " " + rowValue);
                            xmasCounter++;
                        }
                    } catch (Exception e){
                        continue;
                    }

                }
            }
        }
        System.out.println("we found " + xmasCounter + " counts of X-MAS.");
    }
}
