import java.util.*;

public class week12_task5_FrequencyQueries {
    public static List<Integer> freqQuery(List<int[]> queries) {
        Map<Integer, Integer> valueToFreq = new HashMap<>();
        Map<Integer, Integer> freqCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int val = q[1];

            if (type == 1) {
                int oldFreq = valueToFreq.getOrDefault(val, 0);
                int newFreq = oldFreq + 1;
                valueToFreq.put(val, newFreq);

                if (oldFreq > 0) {
                    freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);
                }
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

            } else if (type == 2) {
                if (valueToFreq.containsKey(val) && valueToFreq.get(val) > 0) {
                    int oldFreq = valueToFreq.get(val);
                    int newFreq = oldFreq - 1;
                    valueToFreq.put(val, newFreq);

                    freqCount.put(oldFreq, freqCount.get(oldFreq) - 1);
                    if (newFreq > 0) {
                        freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
                    }
                }
            } else if (type == 3) {
                if (freqCount.getOrDefault(val, 0) > 0) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<int[]> queries = Arrays.asList(
            new int[]{1, 5},
            new int[]{1, 6},
            new int[]{3, 2},
            new int[]{1, 10},
            new int[]{1, 10},
            new int[]{3, 2}
        );

        System.out.println(freqQuery(queries));
    }
}
