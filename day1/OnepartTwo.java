import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; // import the ArrayList class
import java.lang.Math;

public class OnepartTwo {
    public static void main (String[] args) {
        int similarityScore = 0;
        // get the left hand values and the right hand values from the input file
        ArrayList<Integer> leftValues = new ArrayList<Integer>();
        ArrayList<Integer> rightValues = new ArrayList<Integer>();
        try {
            File input = new File("day1/One_input.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] lineValues = data.split("   ");
                leftValues.add(Integer.valueOf(lineValues[0]));
                rightValues.add(Integer.valueOf(lineValues[1]));
            }
            myReader.close();

        // loop over an arraylist

        for (int leftValue : leftValues){
            int valueCount = 0;
            for (int rightValue : rightValues){
                if (java.util.Objects.equals(leftValue, rightValue)) {
                    valueCount++;
                }
            }
            similarityScore += leftValue*valueCount;
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(similarityScore);
    }
}