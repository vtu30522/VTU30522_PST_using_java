import java.util.*;

public class week12_task6_SlidingWindowDistinctElements {
    public static int maxDistinctInWindow(int[] arr, int k) {
        if (arr == null || k > arr.length || k <= 0) return 0;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        int maxDistinct = freqMap.size();

        for (int i = k; i < arr.length; i++) {
            // Remove outgoing
            int out = arr[i - k];
            freqMap.put(out, freqMap.get(out) - 1);
            if (freqMap.get(out) == 0) {
                freqMap.remove(out);
            }

            // Add incoming
            int in = arr[i];
            freqMap.put(in, freqMap.getOrDefault(in, 0) + 1);

            maxDistinct = Math.max(maxDistinct, freqMap.size());
        }

        return maxDistinct;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println("Max distinct elements in window of size " + k + ": " + maxDistinctInWindow(arr, k));
    }
}
