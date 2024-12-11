
public class SalterTester {
    public static void main(String[] args) {
    Salter salter = new Salter();
    Salter salter1 = new Salter();
    Salter salter2 = new Salter();

   
    
    salter.readToFile("quadratic.csv");
    salter.saltFormulas(100);
    salter.writeToFile("saltedQuadratic.csv");
    salter1.readToFile("distance.csv");
    salter1.saltFormulas(550);
    salter1.writeToFile("saltedDistance.csv");
    salter2.readToFile("absoluteValue.csv");
    salter2.saltFormulas(300);
    salter2.writeToFile("saltedAbsoluteValue.csv");
}
}