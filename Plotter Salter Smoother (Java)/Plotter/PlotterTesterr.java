public class PlotterTesterr {

    public static void main(String[] args) {
     
            Plotter plotter = new Plotter();
            Plotter plotter1 = new Plotter();
            Plotter plotter2 = new Plotter();
            plotter.plotQuadraticFormula();
            plotter1.plotDistanceFormula(3, 3, 2, 6);
            plotter2.plotAbsoluteValue(3);

            plotter.writeToFile("quadratic.csv");
            plotter1.writeToFile("distance.csv");
            plotter2.writeToFile("absoluteValue.csv");
    
}
}