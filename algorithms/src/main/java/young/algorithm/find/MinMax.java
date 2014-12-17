package young.algorithm.find;

/**
 * @author young.alway@gmail.com
 * @since 2014-12-17
 *
 * 比较次数:
 * T(1) = 0
 * T(2) = 1
 * T(n) = 2T(n/2) + 2 => T(n) = 3n/2 - 1, n=2^k
 */
public class MinMax {

    public static class Result {
        private int min;
        private int max;

        public Result(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }
    }

    public static Result find(int...array) {
        int n = array.length;

        if (0 == n) {
            return null;
        }

        return findRecursively(0, n-1, array);
    }

    protected static Result findRecursively(int i, int j, int...array) {
        if (i == j) {
            return new Result(array[0], array[0]);
        } else if (j-i == 1) {
            return new Result(
                    array[i] > array[j] ? array[j] : array[i],
                    array[i] > array[j] ? array[i] : array[j]
            );
        } else {
            int m = (i + j) / 2;
            Result left = findRecursively(i, m, array);
            Result right = findRecursively(m+1, j, array);

            return new Result(
                    left.getMin() < right.getMin() ? left.getMin() : right.getMin(),
                    left.getMax() > right.getMax() ? left.getMax() : right.getMax()
            );
        }
    }

    public static void main(String[] args) {
        Result result = find(3, 1, 6, 8, 5, 4, 8, 10);
        System.out.println(String.format("min: %d, max: %d", result.getMin(), result.getMax()));
    }
}
