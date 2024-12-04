package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Two {
    public boolean isIncreasing(int[] a){
        boolean increase = false;

        for (int position = 1; position < a.length; position++){  
            if (a[position] > a[position-1]){
                increase = true;
            } else {
                return false;
            }
        }
        return increase;
    }
    public static void main (String[] args) {
        int safeReports = 0;
        //read file
        try {
            File input = new File("day2/Two_input_test.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] lineValuesStr = data.split(" ");
                int[] lineValues = new int[lineValuesStr.length];
                for (int i = 0; i < lineValuesStr.length; i++){
                    lineValues[i] = Integer.parseInt(lineValuesStr[i]);
                }
                //System.out.println(lineValues);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}