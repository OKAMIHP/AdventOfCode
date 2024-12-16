import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class day3 {
    public static void main(String[] args) {
        int sum = 0;
        ArrayList<String> allMatches = new ArrayList<String>();
        String searchString = "xmul(999,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        Matcher m = Pattern.compile(regex).matcher(searchString);
        while (m.find()) {
            allMatches.add(m.group());
        }

        for (int i = 0; i < allMatches.size(); i++) {
            System.out.println(allMatches.get(i));
            int indexOfB1 = allMatches.get(i).indexOf("(");
            System.out.println(indexOfB1);
            int indexOfP = allMatches.get(i).indexOf(",");
            System.out.println(indexOfP);
            int indexOfB2 = allMatches.get(i).indexOf(")");
            System.out.println(indexOfB2);
            int multiplication = Integer.parseInt(allMatches.get(i).substring(indexOfB1 + 1, indexOfP)) * Integer.parseInt(allMatches.get(i).substring(indexOfP + 1, indexOfB2));
            sum += multiplication;
        }
        System.out.println(sum);
    }
    }