package uva.UVA102;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Name class as Main
// default package
class Main {

    static String ReadLn(int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;
        String line = "";

        try {
            while (lg < maxLg) {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String(lin, 0, lg));
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dynamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin() {
        String input;
        StringTokenizer idata;

        while ((input = Main.ReadLn(255)) != null) {
            if (input.equals("")) break;
            idata = new StringTokenizer(input);
            // program goes here

            System.out.println(input);
        }
    }

    public static List<String> generatePermutations(String bcg) {
        List<StringBuffer> out = new ArrayList<>();
        generatePerms(bcg.toCharArray(), 0, out);
        List<String> stringOut = new ArrayList<>();
        for (StringBuffer permutations : out)
            stringOut.add(permutations.toString());
        return stringOut;
    }

    private static void generatePerms(char[] chars, int index, List<StringBuffer> builder) {
        if (index >= chars.length) return;
        for (StringBuffer fragment : builder) {
            fragment.append(chars[index]);
        }
        generatePerms(chars, index + 1, builder);
    }
}
