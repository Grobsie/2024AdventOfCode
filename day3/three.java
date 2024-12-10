package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class three {
    public static void main (String[] args) {
        //import the data and write it to variable data
        String data = "";
        try {
            File input = new File("day3/3_input_test.txt");
            Scanner myReader = new Scanner(input);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();   
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //find the don't do's in the document and split on those
        String[] dataFixed = data.split("(don\\'t\\(\\)).*?(do\\(\\))");
        System.out.println(dataFixed.length);
        //remove the trailing don't
        String StringFixed = Arrays.toString(dataFixed);
        String[] dataFixed2 = StringFixed.split("(don\'t\\(\\))");

        //find mul's and add them together
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("(mul\\(\\d+,\\d+\\))");
        Matcher matcher = pattern.matcher(dataFixed2[0]);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        //now combine all the values from the multiplications
        int multiplication = 0;
        for (String i: result){
            String trimOne = i.substring(4,i.length()-1);
            String[] stringValues = trimOne.split(",");
            int multi = Integer.valueOf(stringValues[0])* Integer.valueOf(stringValues[1]);
            multiplication += multi;
        }

        System.out.println(multiplication);
    }
}


