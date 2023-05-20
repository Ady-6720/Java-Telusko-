import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PascalTriangle {
    private static final Map<String, Integer> cache = new HashMap<>();
    public static int getNumber(int row, int col) {
        String key = row + "-" + col;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (col == 0 || col == row) {
            return 1;
        }
        int number = getNumber(row - 1, col - 1) + getNumber(row - 1, col);
        cache.put(key, number);
        return number;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rows for Pascal's Triangle: ");
        int numRows = scanner.nextInt();
        scanner.close();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print(getNumber(row, col) + " ");
            }
            System.out.println();
        }
    }
}
