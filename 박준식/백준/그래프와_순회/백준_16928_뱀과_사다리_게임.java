package 백준.그래프와_순회;

import java.io.*;
import java.util.*;

public class 백준_16928_뱀과_사다리_게임 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] distances = new int[101];
    int[] graph = new int[101];

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph[Math.min(x, y)] = Math.max(x, y);
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[Math.max(u, v)] = Math.min(u, v);
    }

    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(1);

    while (!queue.isEmpty()) {
      int current = queue.poll();
      int distance = distances[current];

      for (int i = 1; i <= 6; i++) {
        if (current + i > 100) break;
        if (distances[current + i] != 0) continue;
        int next = graph[current + i];
        if (next == 0) {
          distances[current + i] = distance + 1;
          queue.add(current + i);
        } else if (distances[next] == 0) {
          distances[next] = distance + 1;
          queue.add(next);
        }
      }
    }

    System.out.println(distances[100]);
  }
}
