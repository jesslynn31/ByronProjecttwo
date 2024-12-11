import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Salter {


    Random random = new Random();

    private ArrayList<Integer> x = new ArrayList<Integer>();
    private ArrayList<Integer> y = new ArrayList<Integer>();

 /**
  * changes the elements of the list `y` by salting the values
  *
  * <p> The salt value is generated randomly within the range of [0, bound),
  * and is subtracted by 100, then added to the list elements. </p>
  *
  * @param bound The chosen bound for the random salt value generation.
  */

    public void saltFormulas(int bound){


        for (int i = 0; i < y.size(); i++) {
            int salt = random.nextInt(bound) - 100;  
            y.set(i, y.get(i) + salt);
        }
    }

    
   /**
    * Reads data from a file and processes each line, adding values to both x and y lists.
    * Each line in the file should contain two comma-separated integers.
    * the first being the x value and the second is the y value.
    *
    * @param filename the filename inserted in String format ("example.csv")
    * @throws IOException if an error occurs while reading the file
    */

    public void readToFile(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
          
            while (line != null) {
                int xNum = Integer.parseInt(line.split(",")[0].trim());
                int yNum = Integer.parseInt(line.split(",")[1].trim());
                x.add(xNum);
                y.add(yNum);
              
                line = reader.readLine(); 
                
            }
            reader.close();

        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
    
    }
}
    
 
     public void writeToFile(String filename){
        try {
            FileWriter file = new FileWriter(filename);
            PrintWriter output = new PrintWriter(file);

            for(int i = 0; i < x.size(); i++){
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






