import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int command = Integer.parseInt(input[0]);

            switch (command) {
                case 1:
                    int num = Integer.parseInt(input[1]);
                    push(num);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    size();
                    break;
                case 4:
                    isEmpty();
                    break;
                case 5:
                    top();
                    break;
            }
        }

        System.out.print(sb.toString());
    }

    private static void size() {
        sb.append(list.size()).append("\n");
    }

    private static void isEmpty() {
        sb.append(list.isEmpty() ? 1 : 0).append("\n");
    }

    private static void top() {
        if (list.isEmpty())
            sb.append("-1\n");
        else
            sb.append(list.get(list.size() - 1)).append("\n");
    }

    private static void pop() {
        if (list.isEmpty())
            sb.append("-1\n");
        else
            sb.append(list.remove(list.size() - 1)).append("\n");
    }

    private static void push(int num) {
        list.add(num);
    }
}
