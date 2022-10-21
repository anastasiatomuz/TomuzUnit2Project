import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();
        scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();
        scan.nextLine();

        //coordinate 1
        int locParaFirst1 = coord1.indexOf("(");
        int locComma1 = coord1.indexOf(",");
        int locParaSecond1 = coord1.indexOf(")");
        String x1Str = coord1.substring(locParaFirst1 + 1,locComma1);
        x1Str = x1Str.replaceAll("\\s", "");
        int x1 = Integer.parseInt(x1Str);

        String y1Str = coord1.substring(locComma1 + 1, locParaSecond1);
        y1Str = y1Str.replaceAll("\\s", "");
        int y1 = Integer.parseInt(y1Str);


        //coordinate 2
        int locParaFirst2 = coord2.indexOf("(");
        int locComma2 = coord2.indexOf(",");
        int locParaSecond2 = coord2.indexOf(")");
        String x2Str = coord2.substring(locParaFirst2 + 1,locComma2);
        x2Str = x2Str.replaceAll("\\s", "");
        int x2 = Integer.parseInt(x2Str);

        String y2Str = coord2.substring(locComma2 + 1, locParaSecond2);
        y2Str = y2Str.replaceAll("\\s", "");
        int y2 = Integer.parseInt(y2Str);


        //checks if the slope is undefined
        if (x1 != x2) {
            //prints out equation and information about coordinates
            LinearEquation linEq = new LinearEquation(x1, y1, x2, y2);
            System.out.println(linEq.lineInfo());
            //asking for and plugging in user's value of x for the equation
            System.out.print("Enter a value for x: ");
            double userXValue = scan.nextDouble();
            System.out.println("\nThe point on the line is: " + linEq.coordinateForX(userXValue));
        }else{
            System.out.println("These points are in a vertical line: x = " + x1);
        }
    }
}
