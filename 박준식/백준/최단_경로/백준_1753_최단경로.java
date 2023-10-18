package 백준.최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1753_최단경로 {
  static int V;
  static int E;
  static int K;
  static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
  static int[] distance;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());

    for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());
    visited = new boolean[V + 1];
    distance = new int[V + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new Node(v, w));
    }

    for (int i = 0; i < V; i++) Collections.sort(graph.get(i));

    dijkstra();

    for (int i = 1; i <= V; i++) System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
  }

  static PriorityQueue<Node> queue = new PriorityQueue<>();

  static void dijkstra() {
    distance[K] = 0;
    queue.add(new Node(K, 0));
    while (!queue.isEmpty()) {
      Node n = queue.poll();
      if (visited[n.v]) continue;
      visited[n.v] = true;
      for (Node node: graph.get(n.v)) {
        if(distance[node.v] <= distance[n.v] + node.w) continue;
        distance[node.v] = distance[n.v] + node.w;
        queue.add(new Node(node.v, distance[node.v]));
      }
    }
  }
}

class Node implements Comparable<Node>{
  int v, w;

  Node(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(Node o) {
    return this.w - o.w == 0 ? this.v - o.v : this.w - o.w;
  }
}