package uva;

import java.io.IOException;
import java.util.StringTokenizer;

public class Template {

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
        Template myWork = new Template();  // create a dynamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin() {
        String input;
        StringTokenizer idata;
        int a, b, min, max, num, n, cycle, cyclemax;

        while ((input = Template.ReadLn(255)) != null) {
            idata = new StringTokenizer(input);
            // program goes here

            System.out.println(input);
        }
    }
}
