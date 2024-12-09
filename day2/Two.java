package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Two {
    public static boolean isIncreasing(int[] a){
        int previousValue = a[0];
        for (int position = 1; position < a.length; position++){  
            if (a[position] > previousValue){
                previousValue = a[position];
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(int[] a){
        int previousValue = a[0];
        for (int position = 1; position < a.length; position++){  
            if (a[position] < previousValue){
                previousValue = a[position];
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectRange(int[] a){
        int previousValue = a[0];
        for (int position = 1; position < a.length; position++){  
            if (Math.abs(a[position] - previousValue) < 4){
                previousValue = a[position];
            } else {
                return false;
            }
        }
        return true;
    }

    public static int[] removeOneValue(int[] inputArray, int indexOfValue){
        int[] result = new int[inputArray.length-1];
        int count = 0;
        for (int index = 0; index < inputArray.length; index++){
            if (index != indexOfValue){
                result[count] = inputArray[index];
                count++;
            }
        }
        return result;
    }
    public static void main (String[] args) {
        int safeReports = 0;
        //read file
        try {
            File input = new File("day2/Two_input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] lineValuesStr = data.split(" ");
                int[] lineValues = new int[lineValuesStr.length];
                for (int i = 0; i < lineValuesStr.length; i++){
                    lineValues[i] = Integer.parseInt(lineValuesStr[i]);
                }
                System.out.println(data);
                //System.out.println("is this increasing: " + isIncreasing(lineValues));
                //System.out.println("is this decreasing: " + isDecreasing(lineValues));
                //System.out.println("is this in range  : " + isCorrectRange(lineValues));
                int fixes = 0;
                
                if ((isIncreasing(lineValues) || isDecreasing(lineValues)) && isCorrectRange(lineValues)){
                    //System.out.println("adding to safereports");
                    System.out.println("this one is safe without changes");
                    safeReports++;
                } else if (fixes < 1){
                    for (int x = 0; x < lineValues.length; x++){
                        int[] adjustedData = removeOneValue(lineValues, x);
                        if ((isIncreasing(adjustedData) || isDecreasing(adjustedData)) && isCorrectRange(adjustedData)){
                            for (int i: adjustedData){
                                System.out.print(i + " ");
                            }
                            System.out.println("This one is safe after one adjustment");
                            safeReports++;
                            fixes++;
                            break;
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Number of safe reports is: " + safeReports);

    }
}