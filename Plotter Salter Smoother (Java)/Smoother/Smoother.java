
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Smoother {

    private ArrayList<Integer> x = new ArrayList<Integer>();
    private ArrayList<Integer> y = new ArrayList<Integer>();



/**
 * Smooths the data in the y array list by averaging values within a specified range.
 * 
 * <p>The smoothing is performed by going through each element in the list and
 * calculating the average of elements within the given range around it. The value 
 * at each index is replaced by this computed average.</p>
 * 
 * @param range the number of neighboring elements to include in the averaging 
 *              process on each side of the current element. 
 */

public void smoothData(int range){
    for (int i = 0; i < y.size(); i++){
        int sum = 0;
        int count = 0;

        for (int j = i - range; j <= i + range; j++){
            if (j >= 0 && j < y.size()){
                sum += y.get(j);
                count++;
            }
        }
        y.set(i, sum / count);
    }
}

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
        }catch (IOException e){
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
