import java.util.*;

public class CircularSubarraySum {

    public static int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int num : nums) {

            // Maximum subarray (Kadane's Algorithm)
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // If all numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum circular subarray
        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Enter size of array
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Enter array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxSubarraySumCircular(nums);

        System.out.println("Maximum Circular Subarray Sum: " + result);

        sc.close();
    }
}