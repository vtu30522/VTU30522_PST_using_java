import java.util.*;

public class week11_task9_MigratoryBirds {
    public static int migratoryBirds(List<Integer> arr) {
        int[] counts = new int[6];
        for (int bird : arr) {
            if (bird >= 1 && bird <= 5) {
                counts[bird]++;
            }
        }

        int maxFreq = 0;
        int resultId = 1;
        for (int i = 1; i <= 5; i++) {
            if (counts[i] > maxFreq) {
                maxFreq = counts[i];
                resultId = i;
            }
        }
        return resultId;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 4, 4, 4, 5, 3);
        System.out.println(migratoryBirds(arr));
    }
}
