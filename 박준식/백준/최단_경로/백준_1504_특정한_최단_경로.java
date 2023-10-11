package 백준.최단_경로;

import java.io.*;
import java.util.*;

public class 백준_1504_특정한_최단_경로 {
  static int n;
  static int e;

  static class Node implements Comparable<Node> {
    int index;
    int distance;

    Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
      return this.distance - o.distance;
    }
  }

  static int[][] d;

  static void dijkstra(int start) {
    Arrays.fill(d[start], Integer.MAX_VALUE);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(start, 0));

    d[start][start] = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();

      int dist = node.distance;
      int now = node.index;

      if (d[start][now] < dist) {
        continue;
      }

      for (int i = 0; i < graph.get(now).size(); i++) {
        int cost = d[start][now] + graph.get(now).get(i).distance;

        if (cost < d[start][graph.get(now).get(i).index]) {
          d[start][graph.get(now).get(i).index] = cost;
          pq.offer(new Node(graph.get(now).get(i).index, cost));
        }
      }
    }
  }

  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

  public static int checkIsAble(int v1, int v2) {
    if (d[0][v1] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
    if (d[v1][v2] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
    if (d[v2][n - 1] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
    return d[0][v1] + d[v1][v2] + d[v2][n - 1];
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    n = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < e; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      int start = Integer.parseInt(st.nextToken()) - 1;
      int end = Integer.parseInt(st.nextToken()) - 1;
      int distance = Integer.parseInt(st.nextToken());
      graph.get(start).add(new Node(end, distance));
      graph.get(end).add(new Node(start, distance));
    }
    str = br.readLine();
    st = new StringTokenizer(str);
    int v1 = Integer.parseInt(st.nextToken()) - 1;
    int v2 = Integer.parseInt(st.nextToken()) - 1;
    d = new int[n][n];
    dijkstra(0);
    dijkstra(v1);
    dijkstra(v2);

    int distance = Integer.min(checkIsAble(v1, v2), checkIsAble(v2, v1));
    System.out.println(distance == Integer.MAX_VALUE ? -1 : distance);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}