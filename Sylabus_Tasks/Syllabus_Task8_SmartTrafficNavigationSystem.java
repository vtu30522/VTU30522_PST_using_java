import java.util.*;

public class Syllabus_Task7_SmartTrafficNavigationSystem {
    public static void main(String[] args) {

        int N = 5;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        int[][] roads = {
            {1, 2},
            {2, 3},
            {3, 4},
            {4, 5}
        };

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int source = 1;
        int destination = 5;

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(visited[destination] ? "YES" : "NO");
    }
}