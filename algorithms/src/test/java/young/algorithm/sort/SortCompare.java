package young.algorithm.sort;

import young.library.standard.StdOut;
import young.library.standard.StdRandom;
import young.library.standard.Stopwatch;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-20
 */
public class SortCompare {
    public static double time(String sort, Comparable[] arr) {
        Stopwatch stopwatch = new Stopwatch();

        if ("Insertion".equals(sort)) {
            Insertion.sort(arr);
        } else if ("Selection".equals(sort)) {
            Selection.sort(arr);
        }
        return stopwatch.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = 1000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}
