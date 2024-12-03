package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Two {
    public static void main (String[] args) {
        try {
            File input = new File("day1/Two_input_test.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] lineValues = data.split(" ");
                
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}