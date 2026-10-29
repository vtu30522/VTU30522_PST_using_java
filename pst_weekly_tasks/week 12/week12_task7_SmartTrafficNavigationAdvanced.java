import java.util.*;

public class week12_task7_SmartTrafficNavigationAdvanced {
    public static boolean hasPath(Map<Integer, Set<Integer>> adjList, int src, int dest) {
        if (src == dest) return true;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == dest) return true;

            for (int next : adjList.getOrDefault(curr, Collections.emptySet())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.add(next);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        adjList.computeIfAbsent(1, k -> new HashSet<>()).add(2);
        adjList.computeIfAbsent(2, k -> new HashSet<>()).add(3);
        adjList.computeIfAbsent(3, k -> new HashSet<>()).add(4);

        System.out.println("Route 1 -> 4 exists: " + (hasPath(adjList, 1, 4) ? "YES" : "NO"));
        System.out.println("Route 1 -> 5 exists: " + (hasPath(adjList, 1, 5) ? "YES" : "NO"));
    }
}
