import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Run1 {

//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(calcPrimeNumbers(36L)));
//    }

    /**
     * Write a function that takes the number X (1 <= X<= 10^16). Returns an array containing all unique prime
     * divisors in ascending order. (X is prime if it is not divisible by any number up to sqrt(X) (inclusive));
     * @cpu O(sqrt(x));
     * @ram O(1);
     * @param x - input value;
     * @return - an array that contains all the prime divisors of the number 'X';
     */
    public static long[] calcPrimeNumbers(long x) {
        long[] results;
        if (x > 1) {
            final long maxValue = (long) Math.sqrt(x) + 1;
            long divider = 2L;
            List<Long> resultsList = new ArrayList();

            while (divider <= maxValue) {
                if (x % divider == 0 ) {
                    resultsList.add(divider);
                    while (x % divider == 0) {
                        x /= divider;
                    }
                }
                divider++;
            }
            if (x != 1) {
                resultsList.add(x);
            }
            results = resultsList.stream().mapToLong(Long::longValue).toArray();
        } else {
            results = new long[0];
        }
        return results;
    }

}
