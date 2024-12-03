import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class day1 {
    public static void main(String[] args) {
        int min = 0;
        ArrayList<String> fileData = getFileData("src/input.txt");
        for(int i = 0; i < fileData.size(); i++)
        {
            String str = Array.get(fileData,i).toString();

        }
        System.out.println(fileData);
        String str = "[,\\.\\s]";
        String[] myArray = fileData.split(str);
        for(String s : myArray){
            int num1= s.parseInt(s);

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