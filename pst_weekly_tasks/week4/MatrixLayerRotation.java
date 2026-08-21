import java.util.*;

public class MatrixLayerRotation  {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int[][] result = new int[rows][cols];

        for (int layer = 0; layer < Math.min(rows, cols) / 2; layer++) {

            int top = layer;
            int left = layer;
            int bottom = rows - 1 - layer;
            int right = cols - 1 - layer;

            // Store elements of the layer
            List<Integer> elements = new ArrayList<>();

            // Top row
            for (int j = left; j <= right; j++) {
                elements.add(matrix.get(top).get(j));
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix.get(bottom).get(j));
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix.get(i).get(left));
            }

            int size = elements.size();

            // Put rotated elements back
            int index = r % size;

            // Top row
            for (int j = left; j <= right; j++) {
                result[top][j] = elements.get(index);
                index = (index + 1) % size;
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                result[i][right] = elements.get(index);
                index = (index + 1) % size;
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                result[bottom][j] = elements.get(index);
                index = (index + 1) % size;
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                result[i][left] = elements.get(index);
                index = (index + 1) % size;
            }
        }

        // Print result
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}