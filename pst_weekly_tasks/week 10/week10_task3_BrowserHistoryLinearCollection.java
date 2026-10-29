import java.util.*;

public class week10_task3_BrowserHistoryLinearCollection {
    private Deque<String> history = new ArrayDeque<>();

    public void visit(String url) {
        history.push(url);
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("Back from: " + removed);
        } else {
            System.out.println("No history available.");
        }
    }

    public static void main(String[] args) {
        week10_task3_BrowserHistoryLinearCollection browser = new week10_task3_BrowserHistoryLinearCollection();
        browser.visit("google.com");
        browser.visit("github.com");
        browser.visit("leetcode.com");

        browser.back();
        browser.back();
    }
}
