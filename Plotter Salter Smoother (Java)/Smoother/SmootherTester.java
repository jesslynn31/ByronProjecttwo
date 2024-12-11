
public class SmootherTester {

    public static void main(String[] args) {
    Smoother smoother = new Smoother();
    Smoother smoother2 = new Smoother();
    Smoother smoother3 = new Smoother();
    

    

    smoother.readToFile("saltedQuadratic.csv");
    smoother.smoothData(2);
    smoother.writeToFile("smoothedQuadratic.csv");
    smoother2.readToFile("saltedDistance.csv");
    smoother2.smoothData(6);
    smoother2.writeToFile("smoothedDistance.csv");
    smoother3.readToFile("saltedAbsoluteValue.csv");
    smoother3.smoothData(6);
    smoother3.writeToFile("smoothedAbsoluteValue.csv");
}
}