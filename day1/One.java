import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class
import java.lang.Math;

public class One {
    public static void main (String[] args) {
        int totalDistance = 0;
        // get the left hand values and the right hand values from the input file
        ArrayList<Integer> leftValues = new ArrayList<Integer>();
        ArrayList<Integer> rightValues = new ArrayList<Integer>();
        try {
            File input = new File("day1/One_input_test.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] lineValues = data.split("   ");
                leftValues.add(Integer.valueOf(lineValues[0]));
                rightValues.add(Integer.valueOf(lineValues[1]));
            }
            myReader.close();
            leftValues.sort(null);
            rightValues.sort(null);

        // loop over an arraylist
        int arraySize = leftValues.size();
        for (int e = 0; e < arraySize; e++) {
            totalDistance += Math.abs(rightValues.get(e) - leftValues.get(e));
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(totalDistance);
    }
}