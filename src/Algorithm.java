import java.util.Random;

public class Algorithm {
    public static void replaceSegments(int[] array) {
        int n = array.length;
        if (n == 0) {
            return;
        }

        int x = array[0];
        int leftNeighbor = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                int rightNeighbor = (i == n - 1) ? 0 : array[i + 1];
                int average = (leftNeighbor + rightNeighbor) / 2;
                array[i] = average;
            }
            leftNeighbor = array[i];
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }

        return array;
    }
}