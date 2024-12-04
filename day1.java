import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        int sum = 0;
        ArrayList<String> fileData = getFileData("input");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> differences= new ArrayList<>();
        for(int i = 0; i < fileData.size(); i++){
            String[] split = fileData.get(i).split("   ");
            list1.add(Integer.parseInt(split[0]));
            list2.add(Integer.parseInt(split[1]));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for( int i = 0; i < list1.size(); i++){
            differences.add(Math.abs(list1.get(i) - list2.get(i)));
        }
        for(int difference : differences)
        {
            sum += difference;
        }
        System.out.println(sum);
        int sim = 0;

        for (Integer value : list1){
            int count = 0;
            for(Integer val : list2){
                if (value.equals(val)){
                    count++;
                }
            }
            sim += count * value;
        }
        System.out.println(sim);
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