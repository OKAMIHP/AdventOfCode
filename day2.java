import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        int safeCount = 0;
        boolean safety = false;
        boolean firstIncrement = false;
        boolean increasing = false;
        ArrayList<String> fileData = getFileData("input");
        for(int i = 0; i < fileData.size(); i++) // goes into the big array
        {
            int[] differences = {};
            String[] split = fileData.get(i).split(" ");
            for(int j = 0; j < split.length - 1; j++) // goes into small array
            { // checks for difference of atmost 3 or atleast 1
                int difference = Math.abs(Integer.parseInt(split[j]) - Integer.parseInt(split[j + 1]));

                if((difference < 1) || (difference > 3)){ // checks every individual number in the small array
                    safety = false;
                    break; // breaks out of entire loop immediately to the safety check
                }
                else { // step 2: checking if the levels are increasing or decreasing

                }
            }
        }
        System.out.println(safeCount);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}