package idk;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import java.awt.Color;
import java.util.Scanner;

import javax.swing.*;


public class GraphMaker extends JFrame {

   PlotSaltSmoothData data = new PlotSaltSmoothData();



 /**
 * Displays a plot of the original quadratic function using JFreeChart.
 * <p>
 * This method uses the JFreeChart library to create and display an XY line chart
 * representing a quadratic function. The chart has a title, axis labels, and a distinct 
 * color for the plot series. It has unique dimensions and is centered on the screen.
 * </p>
 */
    public void Graph()  {
        data.plotQuadraticFormula();
        

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(data.getPlotSeries());
        
      

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Quadratic Function Plot",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(153, 0, 153));
       
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
    setContentPane(chartPanel);
    setTitle("Original Quadratic Graph");
    revalidate();
    repaint();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);  
    setLocationRelativeTo(null);
    


}


 /**
 * Displays a plot of the salted quadratic function using JFreeChart.
 * <p>
 * This method uses the JFreeChart library to create and display a salted XY line chart
 * representing a quadratic function. The chart has a title, axis labels, and a distinct 
 * color for the salted series. It has unique dimensions and is centered on the screen.
 * </p>
 */

    public void Graph2() {
        data.plotQuadraticFormula();
        data.saltFormulas(100); 
     
    
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        dataset2.addSeries(data.getSaltedSeries()); 
    
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Salted Quadratic Function Plot",
            "X",
            "Y",
            dataset2,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
    
        chart.getXYPlot().getRenderer().setSeriesPaint(0, Color.BLUE); 
    
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    
        setTitle("Salted Quadratic Graph");
        revalidate();
        repaint();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    

 /**
 * Displays a plot of the smoothed quadratic function using JFreeChart.
 * <p>
 * This method uses the JFreeChart library to create and display an XY line chart
 * representing a quadratic function. The chart has a title, axis labels, and a distinct 
 * color for the smoothed series. It has unique dimensions and is centered on the screen.
 * </p>
 */

public void Graph3() {

    XYSeriesCollection dataset3 = new XYSeriesCollection();
    data.plotQuadraticFormula();
    data.saltFormulas(100);
    data.smoothFormulas(3);
        


    dataset3.addSeries(data.getSmoothedSeries());

JFreeChart chart = ChartFactory.createXYLineChart(
    "Smoothed Quadratic Function Plot",
    "X",
    "Y",
    dataset3,
    PlotOrientation.VERTICAL,
    true,
    true,
    false
);


chart.getXYPlot().getRenderer().setSeriesPaint(0, new Color(255, 0, 127));


ChartPanel chartPanel = new ChartPanel(chart);
chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
setContentPane(chartPanel);


    setTitle("Smoothed Quadratic Graph");
    revalidate();
    repaint();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);  
    setLocationRelativeTo(null);

}

/**
 * Continuously prompts the user to select and view different types of graphs
 * until the user chooses to exit the program.
 * <p>
 * This method provides a simple text-based interface for the user to interact
 * with graph plot, salt, smooth options. The user can choose to view:
 * the original graph, the salted graph, the smoothed graph, or exit the program.
 * </p>
*/
    public void run() {
        Scanner option = new Scanner(System.in);
        boolean running = true;
        while(running){

        System.out.println("Enter 1 to view the original graph, 2 to view the salted graph, 3 to view the smoothed graph, and 4 to exit.");
    
        int choice = option.nextInt();  

        if (choice == 1) {
            Graph();
        } else if (choice == 2) {
            Graph2();
        } else if (choice == 3) {
            Graph3();
        } else if (choice == 4) {
            System.out.println("Goodbye!");
            running = false;
        } else {
            System.out.println("Wrong option selected. Please try again.");
        }
    }
    option.close();  
}
}




