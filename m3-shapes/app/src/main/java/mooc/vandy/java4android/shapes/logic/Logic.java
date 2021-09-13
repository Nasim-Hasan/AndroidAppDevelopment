package mooc.vandy.java4android.shapes.logic;

import java.util.Locale;

import mooc.vandy.java4android.shapes.ui.OutputInterface;

import static java.lang.String.format;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough)
     */
    private final OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    @Override
    public void process() {
        // Get which calculation should be computed.  Do not worry
        // about the specifics of this right now.
        Shapes shapeForCalculations = mOut.getShape();

        // Store the values returned by the User Interface.
        double mLength = mOut.getLength();
        double mWidth = mOut.getWidth();
        double mHeight = mOut.getHeight();
        double mRadius = mOut.getRadius();

        // Determine which calculation to process right now.  Again,
        // do not worry about the specifics of how this works for now.
        switch (shapeForCalculations) {
            case Box:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxVolume(mLength, mWidth, mHeight)));
                mOut.println();

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println();
                // If you are paying attention, you will notice that
                // there is no 'break;' here like there is in other
                // places, meaning that if 'Box' was selected, it will
                // run the two sets of print statements above and the
                // two statements below until the 'break;' statement.
            case Rectangle:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectanglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectangleArea(mLength, mWidth)));
                mOut.println();
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereVolume(mRadius)));
                mOut.println();

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereSurfaceArea(mRadius)));
                mOut.println();
                // Same here as with 'Box' above. If 'Sphere' is picked, it will run the
                // two sets of print statements above and the two below until the 'break;'
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleCircumference(mRadius)));
                mOut.println();

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleArea(mRadius)));
                mOut.println();
                break;
            case Triangle:
                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTrianglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth
                        + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTriangleArea(mLength, mWidth)));
                mOut.println();
                break;
            default:
                break;
        }
    }

    // TODO -- add your code here

    public static double rectangleArea(double length, double width)
    {
        /* This Method Calculates the Area of a Rectangle
            Formula: Area=Length*Width
         */
        double recArea=0.0;
        recArea=length*width;
        return recArea;
    }

    public static double rectanglePerimeter(double length, double width)
    {
        /* This Method Calculates the Perimeter of a Rectangle
            Formula: Perimeter=2*(Length+Width)
         */

        double recPerimeter=0.0;
        recPerimeter=2*(length+width);
        return recPerimeter;

    }

    public static double circleArea(double radius)
    {
         /* This Method Calculates the Area of a Circle
            Formula: Area=PI*Radius*Radius
         */
        double cirArea=0.0;
        cirArea=Math.PI*radius*radius;
        return cirArea;

    }

    public static double circleCircumference(double radius)
    {
        /* This Method Calculates the Circumference of a Circle
           Formula: Circumference= 2*PI*Radius
         */
        double cirCircumference=0.0;
        cirCircumference=2*Math.PI*radius;
        return cirCircumference;

    }

    public static double rightTriangleArea(double base, double height)
    {
        /* This Method Calculates the Area of a Right Triangle
           Formula: Right Triangle Area = Base*Height/2
         */
         double rightTriArea=0.0;
         rightTriArea=(base*height)/2;
         return rightTriArea;

    }

    public static double rightTrianglePerimeter(double base, double height)
    {
        /* This Method Calculates the Perimeter of a Right Triangle
            Formula: Right Triangle Perimeter = Base + Height + SQRT (Base*Base + Height*Height)
         */

        double rightTriPerimeter=0.0,c=0.0;
        c=Math.sqrt(base*base+height*height);
        rightTriPerimeter=base+height+c;
        return rightTriPerimeter;


    }

    public static double boxVolume(double length, double width, double depth)
    {
        /* This Method Calculates the Volume of a Box
            Formula: Volume of a Box = Length * Width * Depth
         */
        double bxVolume=0.0;
        bxVolume = length*width*depth;
        return bxVolume;


    }

    public static double boxSurfaceArea(double length, double width, double depth)
    {
        /* This Method Calculates the Area of a Box Surface
            Formula: Area of a Box Surface = 2*(Length*Width+Length*Depth+Width*Depth);
         */
        double bxSurfArea=0.0;
        bxSurfArea = 2*(length*width+length*depth+width*depth);
        return bxSurfArea;
    }

    public static double sphereVolume(double radius)
    {
        /* This Method Calculates the Volume of a Sphere
            Formula: Volume of a Sphere = (4*PI*Radius*Radius*Radius)/3
         */
        double sphrVolume=0.0;
        sphrVolume = (4*Math.PI*radius*radius*radius)/3;
        return sphrVolume;

    }

    public static double sphereSurfaceArea(double radius)
    {
        /* This Method Calculates the Surface Area of a Sphere
            Formula: Surface Area of a Sphere = 4*PI*Radius*Radius
         */
        double sphrSurfArea=0.0;
        sphrSurfArea = 4*Math.PI*radius*radius;
        return sphrSurfArea;


    }
    
}
