import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args)
    {
        int safeCount = 0;
        String[] split ={};
        ArrayList<String> fileData = getFileData("input");

        for(int i = 0; i < fileData.size(); i++) // goes into the big array
        {
            split = fileData.get(i).split(" ");
            boolean check = levelCheck(split);
            for(int j = 0; j < split.length - 1; j++) // goes into small array
            { // checks for difference of at most 3 or at least 1
                int difference = Math.abs(Integer.parseInt(split[j]) - Integer.parseInt(split[j + 1]));
                if(sizeCheck(difference, levelCheck(split)))
                {
                    safeCount++;
                }
            }
        }
        System.out.println(safeCount);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!

    }

    public static boolean levelCheck(String[] split) // checks if the array is increasing or decreasing or neither ( not safe)
    {
        boolean increasing = false;
        ArrayList<Integer> differenceArray = new ArrayList<Integer>();
        int sum = 0;
            for(int i = 0; i < split.length; i++)
            {
                int difference2 = Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]);
                differenceArray.add(difference2);
            }
            for(int k = 0; k< differenceArray.size(); k++) // creates a sum of all differences ( if positive decreasing, if negative increasing)
            {
                sum+= differenceArray.get(k);
            }
            if(sum > 0) // checks if it's increasing or not
            {
                increasing = false;
            }
            else
            {
                increasing = true;
            }
            for(int i = 0; i < split.length; i++)
            {
                if(differenceArray.get(i) > 0 && increasing) // 1 - 3 = -2 decreasing but increasing
                {
                    return false;
                }
                else
                {
                    if(differenceArray.get(i) < 0 && !increasing) // 3 - 1 = 2 increasing but decreasing
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
            }
        return false;
    }

    static boolean sizeCheck(int d, boolean levelCheck){
        if((d < 1) || (d > 3)){ // checks every individual number in the small array
            return false;
        }
        else {
            if(levelCheck)
            {
                return true;
            }
            else {
                return false;
            }
        }
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