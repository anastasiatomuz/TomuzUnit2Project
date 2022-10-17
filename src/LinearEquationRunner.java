import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        scan.nextLine();
        System.out.println("Enter coordinate 2: ");
        String coord2 = scan.nextLine();
        scan.nextLine();

        //coordiate 1
        int locParaFirst1 = coord1.indexOf("(");
        int locComma1 = coord1.indexOf(",");
        int locParaSecond1 = coord1.indexOf(")");
        String x1Str = coord1.substring(locParaFirst1 + 1,locComma1);
        x1Str = x1Str.replaceAll("\\s", "");
        int x1 = Integer.parseInt(x1Str);

        String y1Str = coord1.substring(locParaFirst1 + 1,locComma1);
        y1Str = y1Str.replaceAll("\\s", "");
        int y1 = Integer.parseInt(y1Str);
        y1 ++;

        //coordinate 2
        int locParaFirst2 = coord2.indexOf("(");
        int locComma2 = coord2.indexOf(",");
        int locParaSecond2 = coord2.indexOf(")");
        String x2Str = coord2.substring(locParaFirst2 + 1,locComma2);
        x2Str = x2Str.replaceAll("\\s", "");
        int x2 = Integer.parseInt(x1Str);

        String y2Str = coord2.substring(locParaFirst2 + 1,locComma2);
        y1Str = y1Str.replaceAll("\\s", "");
        int y2 = Integer.parseInt(y2Str);
        y2 ++;

        System.out.println("x1: " + (x1 + 1) + "    y1: " +  y1  );
        System.out.println("x2: " + (x2 + 1) + "    y2: " +  y2 );
        /*
        Write initial code in your LinearEquationRunner class to obtain the coordinates from the user and figure out
         how to parse the  two int x and y values from each coordinates entered as (x, y) and stored as a String;
         once you have two x’s and two y’s as ints, move on to developing the LinearEquation class and writing its methods.
        Once you begin working on the LinearEquation class, you will quickly discover that the most challenging part
         of this task is the equation() method, which returns the equation as a String in the format y = mx + b with
         various constraints on how the printing looks; you might consider getting all other methods working (and tested!)
         before tackling the equation() method.

You might do the lineInfo() method last, since that requires all other methods to be completed.

         */
    }
}
