package uva;

import java.io.IOException;
import java.util.StringTokenizer;

class UVA100 {
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        UVA100 myWork = new UVA100();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b, min, max, num, n, cycle, cyclemax;

        while ((input = UVA100.ReadLn (255)) != null)
        {
            idata = new StringTokenizer (input);
            a = Integer.parseInt (idata.nextToken());
            b = Integer.parseInt (idata.nextToken());
            int output = doWork(a, b);
            System.out.println (a + " " + b + " " + output);
        }
    }

    int doWork(int a, int b) {
        int min, max, num, n, cycle, cyclemax;
        if (a < b) { min=a; max=b; } else { min=b; max=a; }
        for (cyclemax=-1, num=min; num<=max; num++) {
            for (n=num, cycle=1; n != 1; cycle++) if ((n % 2) != 0) n=3*n+1; else n >>= 1;
            if (cycle > cyclemax) cyclemax=cycle;
        }
        return cyclemax;
    }
}