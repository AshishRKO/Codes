import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Preorder {

    public static String nextWord(String str) {

        // if string is empty
        if (str == "")
            return "a";

        // Find first character from
        // right which is not z.
        int i = str.length() - 1;
        while (str.charAt(i) == 'z' && i >= 0)
            i--;

        // If all characters are 'z',
        // append an 'a' at the end.
        if (i == -1)
            str = str + 'a';

        // If there are some
        // non-z characters
        else
            str = str.substring(0, i) + (char) ((int) (str.charAt(i)) + 1) + str.substring(i + 1);
        return str;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("c", "d");
        Collections.sort(list);

        System.out.println(list);


        String curr = "aaaa";
        String second = nextWord(curr);


        for(int i=0; i<list.size()-1;i++)
        {
            curr = list.get(i);
            second = list.get(i+1);

            String next = nextWord(curr);

            if(next.equalsIgnoreCase(second) == false)
            {
                System.out.println(next);
                break;
            }


        }

    }

}
