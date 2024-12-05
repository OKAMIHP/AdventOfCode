import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        int safeCount = 0;
        boolean safety = false;
        boolean lastIncrement = false;
        boolean increasing = false;
        ArrayList<String> fileData = getFileData("input");
        for(int i = 0; i < fileData.size(); i++){
            String[] split = fileData.get(i).split(" ");
            for( int j = 0; j < split.length - 1; j++)
            {
                int difference = Math.abs(Integer.parseInt(split[j]) - Integer.parseInt(split[j + 1]));
                if((difference < 1) || (difference > 3)){
                    safety = false;
                    break;
                }
                else{
                    if(Integer.parseInt(split[j]) < Integer.parseInt(split[j + 1]))
                    {
                        increasing = true;
                        lastIncrement = true;
                    }
                    else
                    {
                        increasing = false;
                        lastIncrement = false;
                    }
                    for( int k = 1; k < split.length; k++)
                    {
                        if(Integer.parseInt(split[j]) < Integer.parseInt(split[j + 1]))
                        {
                            increasing = true;
                        }
                        else{
                            increasing = false;
                        }
                        if(lastIncrement != increasing)
                        {
                            safety = false;
                            break;
                        }
                        else{
                            safety = true;
                        }
                    }
                }
            }
            if(safety == true)
            {
                safeCount++;
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