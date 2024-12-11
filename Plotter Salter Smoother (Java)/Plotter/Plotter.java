import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Plotter {

// make a print writer, and make up random equation (3)
// output the data into a .csv file

private ArrayList<Integer> x = new ArrayList<Integer>();
private ArrayList<Integer> y = new ArrayList<Integer>();

    /**
     * Generates x and y values for the quadratic equation y = x^2 + 2x + 1
     * within the range of -50 to 50, and stores them in respective lists.
     */

    public void plotQuadraticFormula(){

        for (int i = -50; i <= 50; i++){
         x.add(i);
         y.add ((int) Math.pow(i, 2) + 2*i + 1);

        }
    }

    /**
     * Calculates the distance between two points (x1, y1) and (x2, y2)
     * and generates the x values -50 to 50 and y values from the equation
     *
     * @param x1 the x-coordinate of the first point
     * @param y1 the y-coordinate of the first point
     * @param x2 the x-coordinate of the second point
     * @param y2 the y-coordinate of the second point
     */

    public void plotDistanceFormula(int x1, int y1, int x2, int y2){
       int distance = (int) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        for (int i = -50; i <= 50; i++){
            x.add(i);
            
            y.add(distance + i);
        }
    }


    
    /**
     * the y values by the absolute value equation y = |a * x|. 
     * The x values range from -50 to 50.
     *
     * @param a the coefficient that scales the absolute value function vertically.
     *          Larger values stretch the graph, and smaller values compress it.
     */

    public void plotAbsoluteValue(int a) {
        for (int i = -50; i <= 50; i++) {
            x.add(i);
            y.add(Math.abs(a * i));
        }
    }



  /**
   * writes the data points stored in x and y lists to file
   * each data point is written in a csv form as x,y on a separate line
   *
   * <p> the file will be created if not already. If the file already exits,
   * it will be overwritten and updated if there were any changes made.
   * 
   * @param filename the filename chosen in String format ("example.csv")
   * @throws IOException if an error occurs while writing to the file
   * 
   */

    public void writeToFile(String filename){
        try {
            FileWriter file = new FileWriter(filename);
            PrintWriter output = new PrintWriter(file);
            int numOfPoints = x.size();
            
            for(int i = 0; i < numOfPoints; i++){
                output.println(x.get(i) + "," + y.get(i));
            }
            output.close();
        }

        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
       

    }

}


