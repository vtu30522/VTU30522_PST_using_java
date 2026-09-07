import java.util.*;

public class MaxSubarray {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        // -------------------------------
        // 1. Maximum Subarray
        // -------------------------------

        int currentSum = arr.get(0);
        int maxSubarray = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {

            currentSum = Math.max(
                arr.get(i),
                currentSum + arr.get(i)
            );

            maxSubarray = Math.max(maxSubarray, currentSum);
        }


        // -------------------------------
        // 2. Maximum Subsequence
        // -------------------------------

        int maxSubsequence = 0;
        int largest = arr.get(0);

        for (int num : arr) {

            // Keep track of largest element
            largest = Math.max(largest, num);

            // Add positive numbers
            if (num > 0) {
                maxSubsequence += num;
            }
        }

        // If all numbers are negative,
        // choose the largest (least negative) number
        if (maxSubsequence == 0) {
            maxSubsequence = largest;
        }


        // Return both answers
        return Arrays.asList(maxSubarray, maxSubsequence);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Integer> result = maxSubarray(arr);

            System.out.println(result.get(0) + " " + result.get(1));
        }

        sc.close();
    }
}