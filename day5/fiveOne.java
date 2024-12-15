package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fiveOne { 
    public static void main (String[] args) {
        //
        int lineCount = 0;
        String[] dump = {"12","12"};

        try {
            //read decode file and put this in the array valueParis
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
                //System.out.println(firstValue + " | " + secondValue);
                valuePairs[lineCount] = new int[]{firstValue,secondValue};
                lineCount++;
            }
            myReaderTwo.close();
            //end of reading decode file

            //read input strings
            File dataInput = new File("day5/5_input.txt");
            Scanner dataReader = new Scanner(dataInput);
            while (dataReader.hasNextLine()){
                String[] dataVStrings = dataReader.nextLine().split(",");
                int[] dataValues = new int[dataVStrings.length];
                for (int index = 0; index < dataVStrings.length;index++){
                    dataValues[index] = Integer.valueOf(dataVStrings[index]);
                }
                for (int index = 0; index < dataValues.length;index++) {
                    if (Arr)
                }
                //System.out.println(" ");
            }
            dataReader.close();
            //finish reading input string
            
            //
            //check if value is in match list
                //value on the left or right side?
                    //left
                        //check if value after is present in array
                            //yes? is it after the right value?
                                //no? create array new array with equal size. 
            //currently only do one line just to test

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }       
    }
}
