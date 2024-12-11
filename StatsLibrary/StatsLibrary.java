import java.math.BigInteger;

public class StatsLibrary {


/**
 * gives the number of combinations (n choose r) 
 *
 * <p>This method calculates the number of ways to choose r items from a set of n items
 * without caring about order, the formula is:
 * nCr = n! / (r! * (n - r)!).
 *
 * @param n the total number of items 
 * @param r the number of items to choose 
 * @return the combination answer 
 */
public double computeCombination(int n, int r){

    return computeFactorial(n).divide(computeFactorial(r).multiply(computeFactorial(n - r))).doubleValue();
   }

/**
 * Computes the factorial of a positive integer.
 *
 * <p>The factorial of a positive integer n is the product of integers
 * less than or equal to n. It is defined by n! </p>
 *
 * @param num the positive integer inputted
 * @return the factorial of the given integer inputted (BigInteger)
 */

 public BigInteger computeFactorial(int num){

    BigInteger factorial = BigInteger.ONE;
    
        for (int i = 1; i <= num; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

/**
 * Computes the probability of a negative binomial distribution for a given number of
 *  successes and the number of trials.
 * <p>
 * In a negative binomial distribution, we are computing the equation:
 * P(Y = y) = (y - 1)C(r-1) * p^r * (1-p) * (1-p)^(y-r)
 * </p>
 *
 * @param p the probability of success on a single trial 
 * @param r the number of required successes. 
 * @param y the total number of trials needed 
 * @return the computed probability using the negative binomial distribution formula
 */
public double computeNegativeBinominalDistribution(double p, int r, int y){
    double combination = computeCombination(y - 1, r - 1);
    
    return combination * Math.pow(p, r) * Math.pow(1 - p, y - r);
}


/**
 * Computes the expected value (mean) of a negative binomial distribution.
 *
 * In a negative binomial distribution, the expected number of trials 
 * required to achieve a specified number of successes is calculated using the formula: 
 * E(X) = r / p
 *
 * @param p The probability of success on each trial 
 * @param r The number of required successes 
 * @return The expected number of trials to achieve 'r' successes.
 */
public double computeNegativeBinominalExpected(double p, int r){
    return r / p;
}

/**
 * computes the variance of a negative binominal distribution.
 * <p>
 * the variance of a negative binominal distribution is found by:
 * V(Y) = r * (1 - p) / p^2
 * @param p the probability of success on a single trial
 * @param r the number of required successes
 * @return the variance of negative binominal distribution
 */

public double computeNegativeBinominalVariance(double p, int r){
    return r * (1 - p) / Math.pow(p, 2);
}

/**
 * Computes the hypergeometric distribution probability.
 * 
 * The hypergeometric distribution models the probability of 
 * obtaining exactly y successes (desired outcomes) 
 * in n draws from a population of size N, 
 * where there are r total successes in the population.
 * 
 * Formula:
 * P(Y = y) = [ C(r, y) * C(N-r, n-y) ] / C(N, n)
 * 
 * @param n the number of draws from the population (sample size).
 * @param r the number of successes in the population.
 * @param N the total size of the population.
 * @param y the number of successes in the sample.
 */
public double hyperGeometricDistribution(int n, int r, int N, int y){
    double combination = computeCombination(r, y);
    double combination2 = computeCombination(N-r, n-y);
    double combination3 = computeCombination(N, n);

    return combination * combination2 / combination3;
}


/**
 * Calculates the expected value in a hypergeometric distribution.
 *
 * <p>The hypergeometric distribution models the probability of k successes 
 * in n draws from a population of size N containing r successes without replacement.
 * This method returns the expected value, which is calculated as (n * r) / N.
 *
 * @param n the number of draws (sample size)
 * @param r the total number of successes in the population
 * @param N the total size of the population
 * @return the expected value of the hypergeometric distribution
 */
public double hyperGeometricExpected(int n, int r, int N) {
    return n * r / N; 
}

/**
 * Calculates the variance of a hypergeometric distribution.
 *
 * <p>The hypergeometric distribution models the probability of k successes 
 * in n draws from a population of size N containing r successes without replacement.
 * This method computes the variance using the formula:
 * n * p * q * (N - n) / (N - 1)
 *
 * @param n the number of draws (sample size)
 * @param r the total number of successes in the population
 * @param N the total size of the population
 * @return the variance of the hypergeometric distribution
 */

public double hyperGeometricVariance(int n, int r, int N) {

    double p = (double) r / N;
    double q = 1 - p; 
    double variance = n * p * q * (double) (N - n) / (N - 1);

    return variance;
}


/**
 * Calculates the Poisson distribution probability for a given mean (lambda) and 
 * a specific number of occurrences (y).
 *
 * <p>The formula for the Poisson distribution is:
 * P(Y = Y) = (λ^y * e^(-λ)) / y!
 *
 * @param Lamda the average number of occurrences (λ)
 * @param y the number of occurrences
 * @return the Poisson probability for the given λ and y
 */
public double poissonDistribution(double Lamda, int y){
    return (Math.pow(Lamda, y) * Math.exp(-Lamda)) / computeFactorial(y).doubleValue();
}

/**
 * Calculates the expected value (mean) of a Poisson distribution.
 *
 * <p>In a Poisson distribution, the expected value (mean) is equal to the 
 * rate parameter λ (Lamda). </p>
 *
 * @param Lamda the rate parameter (λ) of the Poisson distribution
 * @return the expected value (mean) of the Poisson distribution
 */
public double poissonExpected(double Lamda) {
    return Lamda;
}

/**
 * Calculates the variance of a Poisson distribution.
 *
 * <p>In a Poisson distribution, the expected value (mean) is equal to the 
 * rate parameter λ (Lamda). </p>
 *
 * @param Lamda the rate parameter (λ) of the Poisson distribution
 * @return the variance of the Poisson distribution
 */
public double poissonVariance(double Lamda) {
    return Lamda; 
}

public double tchebysheffEquation(double mean, double standardDeviation, double upperBound) {
    
    double withinNumber = Math.abs(upperBound - mean);
    double k = withinNumber / standardDeviation;
    double result = 1 - (1 / Math.pow(k, 2));

    return result; 
}

public void test() {
    System.out.println("Distributions from after the midterm: \n");
    System.out.println("The hypergeometric distribution of ten marbles (3.102) n = 3, r = 5, N = 10, y = 3" + hyperGeometricDistribution(3, 5, 10, 3));
    System.out.println("The hypergeometric expected value of 3.102 is (n = 3, r = 5, N = 10)" + hyperGeometricExpected(3, 5, 10));
    System.out.println("The hypergeometric variance of 3.102 is (n = 3, r = 5, N = 100) " + hyperGeometricVariance(3, 5, 10));
    System.out.println("The negative binominal distribution of 3.14 (p = .20, r = 3, y = 5) " + computeNegativeBinominalDistribution(.20, 3, 5));
    System.out.println("the negative binominal expected value of 3.14 is (p = .20, r = 3) " + computeNegativeBinominalExpected(.20, 3));
    System.out.println("The negative binominal variance of 3.14 is (p = .20, r = 3) " + computeNegativeBinominalVariance(.20, 3));
    System.out.println("The poisson distribution with mean 2 (3.121): (lamda = 2, y = 4)" + poissonDistribution(2, 4));
    System.out.println("the poisson expected value of 3.121 is: ( lamda = 2) " + poissonExpected(2));
    System.out.println("The poisson variance of 3.121 is: (lamda = 2) " + poissonVariance(2) + "\n");

    System.out.println("Tchebysheff's answer to 3.170: (mean - .5, standard dev: .01, between .48 and .52): " + tchebysheffEquation(.5, .01, .52));
}
}