package idk;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import org.jfree.data.xy.XYSeries;


import javax.swing.*;

import java.util.Random;


public class PlotSaltSmoothData extends JFrame {
    
    private XYSeries plotSeries = new XYSeries("Quadratic Function");
    private XYSeries saltedSeries = new XYSeries("Salted Function");
    private XYSeries smoothedSeries = new XYSeries("Smoothed Function");
    

    Random random = new Random();


/**
 * Plots a quadratic formula on the plot series by iterating over a range of x-values.
 * <p>
 * This method computes the y-values for the quadratic formula:
 *  y = x^2 + 2x + 1
 */
    public void plotQuadraticFormula() {
        for (int i = -50; i <= 50; i++) {
            double y = Math.pow(i, 2) + 2 * i + 1;
            plotSeries.add(i, y);
        }
    }

/**
 * Applies a "salting" operation to the existing plot series by adding random noise
 * to the y-values of each data point. This method changes the y-values by adding
 * a random integer (within a bound) to each original y-value and stores the
 * resulting salted data into the XYseries saltedSeries.
 * 
 * @param bound The upper limit on the random noise to be added to each y-value. 
 */
    public void saltFormulas(int bound) {

    saltedSeries.clear(); 

    for (int i = 0; i < plotSeries.getItemCount(); i++) {
        Number xValue = plotSeries.getX(i);
        Number yValue = plotSeries.getY(i);

        int ogY = yValue.intValue();
        int salt = random.nextInt(bound) - 100;
        saltedSeries.add(xValue, ogY + salt); 
            }
        }
        
    
/**
 * Applies a "smoothing" operation to the existing plot series by averaging values
 * between an upper and lower bound. This method computes the average of the y-values
 * within a range of x-values and stores the resulting smoothed data into the XYseries.
 * 
 * @param range The number of data points to consider when computing the average.
 */
    public void smoothFormulas(int range) {
        for (int i = 0; i < saltedSeries.getItemCount(); i++) {
            int sum = 0;
            int count = 0;
        
            for (int j = Math.max(0, i - range); j <= Math.min(i + range, saltedSeries.getItemCount() - 1); j++) {
                Number yValue = saltedSeries.getY(j); 
                sum += yValue.intValue();
                count++;
            }
        
            smoothedSeries.add(saltedSeries.getX(i), sum / count); 
        }
    }
        
        
    
/**
 * Retrieves the plotSeries representing the first data series for plotting.
 * @return An instance of XYSeries representing the first data series.
 */
    public XYSeries getPlotSeries() {
        return plotSeries;
    }

/**
 * Retrieves the saltedSeries representing the second data series for plotting.
 * @return An instance of XYSeries representing the second data series.
 */
    public XYSeries getSaltedSeries() {
        return saltedSeries; 
    }
        
    
/**
 * Retrieves the smoothedSeries representing the third data series for plotting.
 * @return An instance of XYSeries representing the third data series.
 */
    public XYSeries getSmoothedSeries() {
        return smoothedSeries;
    }
}