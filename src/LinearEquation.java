import java.math.RoundingMode;
import java.math.BigDecimal;//used for rounding

public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)
 */
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance(int x1, int x2, int y1, int y2){
        return roundedToHundredth(Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2)));
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double slope(){
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        return roundedToHundredth(y1 - x1 * slope());
    }

    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".
     */
    public String equation(){
        String equation = "";
        String slopeForm;
        boolean slopeChanged = false;

        if (slope() == 0.0){
            return "y = " + (int) yIntercept();
        }

        String yInt = "";
        if (yIntercept() < 0){
            yInt += " - " + yIntercept() * -1;
        }if (yIntercept() > 0){
            yInt += " + " + yIntercept();
        }
        double slopeY = (y2 - y1);
        double slopeX = (x2 - x1);

        // if the negative is only in the denominator, move it to the numerator
        if (slopeY > 0 && slopeX < 0){
            slopeY *= - 1;
            slopeX *= - 1;
        }
        //if both the numerator and denominator in slope are both negative, turns the "fraction" positive
        if ((slopeX < 0) && (slopeY < 0)) {
            slopeX = Math.abs(slopeX);
            slopeY = Math.abs(slopeY);
        }
        // checks if the slope double is an int
        if (slope() % 1 == 0){
            slopeChanged = true;
            equation = "y = " + (int) slope() + "x" + yInt;
        }
        // if slope is 1, removes the one in front of the x
        if (slope() == 1.0){
            slopeChanged = true;
            equation = "y = x" + yInt;
        }
        // if slope is 1, removes the one in front of the x
        if (slope() == - 1.0){
            slopeChanged = true;
            equation =  "y = -x" + yInt;
        }
        if (slopeChanged == false){
            equation =  "y = " + (int) slopeY + "/" + (int) slopeX + "x" + yInt;
        }
        return equation;
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
       both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){
        double yValue = roundedToHundredth(slope() * xValue + yIntercept());
        return "(" + xValue + ", " + yValue + ")";
    }

    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
        to the nearest hundredth
     */
    public double roundedToHundredth(double toRound){
        return new BigDecimal(toRound).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    /* Returns a string that includes all information about the linear equation, each on
       separate lines
      */
    public String lineInfo(){
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 +
                ")\nThe equation of the line between these two points is: " + equation() +
                "\nThe slope of this line is: " + slope() +
                "\nThe y-intercept of the line is: " + yIntercept() +
                "\nThe distance between the points is: " + distance(x1, x2, y1, y2) + "\n";
    }
}