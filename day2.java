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
            for(int j = 0; j < split.length; j++)
            {
                if (levelDifference(split) && increasing(split))
                {
                    safeCount++;
                }
            }
        }
        System.out.println(safeCount);
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!
    }
    // one func for increasing, decreasing, check for level difference

    public static boolean levelDifference(String[] split)
    {
        for(int i = 0; i < split.length - 1; i++)
        {
            int difference = Math.abs(Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]));
            if(difference >= 1 && difference <= 3)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean increasing(String[] split)
    {
        int sum = 0;
        for(int i = 0; i < split.length - 1; i++){
          sum+= Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]);
        }
        return (sum < 0);
    }

    public static boolean incrementCheck(boolean increasing, String[] split)
    {
        ArrayList<Integer> differenceArray = new ArrayList<Integer>();
        for(int i = 0; i < split.length; i++)
        {
            differenceArray.add(Integer.parseInt(split[i]) - Integer.parseInt(split[i + 1]));

        }
        if
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