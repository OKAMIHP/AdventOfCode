import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static boolean main(String[] args)
    {
        int safeCount = 0;
        boolean safety = false;
        boolean pastIncrement = false;
        boolean increasing = false;
        int[] differences = {};
        String[] split ={};
        ArrayList<Integer> differenceArray = new ArrayList<Integer>();
        ArrayList<String> fileData = getFileData("input");

        boolean sizeCheck(int d){
            if((d < 1) || (d > 3)){ // checks every individual number in the small array
                safety = false;
            }
            else {
                if(levelCheck == true)
                {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        boolean levelCheck() // checks if he array is increasing or decreasing or neither ( not safe)
        {
            for(int j = 0; j < split.length - 1; j++) {
                int difference2 = Integer.parseInt(split[j]) - Integer.parseInt(split[j + 1]);
                for(int i = 0; i < split.length; i++)
                {
                    differenceArray.add(difference2);
                }
                

            }
        }
        for(int i = 0; i < fileData.size(); i++) // goes into the big array
        {
            split = fileData.get(i).split(" ");
            for(int j = 0; j < split.length - 1; j++) // goes into small array
            { // checks for difference of at most 3 or at least 1
                int difference = Math.abs(Integer.parseInt(split[j]) - Integer.parseInt(split[j + 1]));
                if(sizeCheck == true)
                {
                    safeCount++;
                }
            }
        }
        System.out.println(safeCount);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!

    }

    boolean
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