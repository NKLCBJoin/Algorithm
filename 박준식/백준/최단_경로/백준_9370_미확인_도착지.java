package 백준.최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_9370_미확인_도착지 {
  static int T;
  static int n, m, t;
  static int s, g, h;
  static int[] goal;
  static int[] distance;
  static boolean[] visited;
  static ArrayList<ArrayList<Node>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      t = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      g = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      goal = new int[t];
      graph = new ArrayList<>();
      for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        graph.get(a).add(new Node(b, d));
        graph.get(b).add(new Node(a, d));
      }

      for (int i = 0; i < t; i++) goal[i] = Integer.parseInt(br.readLine());
      goal = Arrays.stream(goal).sorted().toArray();
      for (int e : goal) {
        int a = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, e);
        int b = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, e);
        int c = dijkstra(s, e);

        if (Math.min(a, b) == c) sb.append(e).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static int dijkstra(int s, int e) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    distance = new int[n + 1];
    visited = new boolean[n + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);

    distance[s] = 0;
    queue.add(new Node(s, 0));

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      if (visited[current.b]) continue;
      visited[current.b] = true;

      for (Node n : graph.get(current.b)) {
        if (distance[current.b] + n.d > distance[n.b]) continue;
        distance[n.b] = distance[current.b] + n.d;
        queue.add(new Node(n.b, distance[n.b]));
      }
    }
    return distance[e];
  }
}
class Node implements Comparable<Node> {
  int b, d;

  Node(int b, int d) {
    this.b = b;
    this.d = d;
  }

  @Override
  public int compareTo(Node o) {
    return this.d - o.d;
  }
}