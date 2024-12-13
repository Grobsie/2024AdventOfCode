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

    public static int checkDirection(String[][] dataInput, int colPosition, int rowPosition, int directionHorizontal, int directionVertical){
        int matchCount = 0;
        int modifierHorizontal = 0;
        int modifierVertical = 0;
        boolean match = false;
        String[] hit = {"X","M","A","S"};
        try {
            for (int positionOfHit = 0; positionOfHit < hit.length; positionOfHit++){
                if (hit[positionOfHit].equals(dataInput[colPosition+modifierHorizontal][rowPosition+modifierVertical])){
                    match = true;
                    modifierHorizontal += directionHorizontal;
                    modifierVertical += directionVertical;
                } else {
                    match = false;
                    break;   
                }
            }
            if (match == true){
                System.out.println("found a hit at " + colPosition + " " + rowPosition);
                matchCount++;
            }     
        } catch (Exception e){
            match = false;
        }
        return matchCount;
    }    
    public static void main (String[] args) {
        //word find: for every position, check all directions for the word XMAS
        int xmasCounter = 0;
        //get input and create array of arrays
        String[][] data = getInput("day4/4_input_test.txt");
        for (int colValue = 0; colValue < data.length ; colValue++){
            for (int rowValue = 0; rowValue < data[0].length ; rowValue++){
                if (data[colValue][rowValue].equals("X")) {
                    //check horizontal, first normal and then backwards
                    xmasCounter += checkDirection(data, colValue, rowValue, 1,0);
                    xmasCounter += checkDirection(data, colValue, rowValue, -1,0);
                    //check vertical
                    xmasCounter += checkDirection(data, colValue, rowValue, 0,1);
                    xmasCounter += checkDirection(data, colValue, rowValue, 0,-1);
                    //check diagonal
                    xmasCounter += checkDirection(data, colValue, rowValue, -1,-1);
                    xmasCounter += checkDirection(data, colValue, rowValue, 1,-1);
                    xmasCounter += checkDirection(data, colValue, rowValue, -1,1);
                    xmasCounter += checkDirection(data, colValue, rowValue, 1,1);
                }
            }
        }
        System.out.println("we found " + xmasCounter + " counts of the word XMAS.");
    }
}
