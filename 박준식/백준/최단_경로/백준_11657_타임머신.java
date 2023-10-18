package 백준.최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_11657_타임머신 {
  static int N, M;
  static long[] distance;
  static Node[] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new Node[M];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      long C = Long.parseLong(st.nextToken());

      graph[i] = new Node(A, B, C);
    }

    if (bellmanFord()) {
      for (int i = 2; i <= N; i++) {
        sb.append(distance[i] == Long.MAX_VALUE ? -1 : distance[i]).append("\n");
      }
    } else {
      sb.append(-1).append("\n");
    }

    System.out.println(sb);
  }

  static boolean bellmanFord() {
    distance = new long[N + 1];
    Arrays.fill(distance, Long.MAX_VALUE);

    distance[1] = 0;

    for (int i = 0; i <= N; i++) {
      for (int j = 0; j < M; j++) {
        int curr = graph[j].start;
        int next = graph[j].end;
        long cost = graph[j].distance;

        if(distance[curr] == Long.MAX_VALUE) continue;
        if(distance[next] > distance[curr] + cost) {
          if(i == N) return false;
          distance[next] = distance[curr] + cost;
        }
      }
    }

    return true;
  }

  static class Node implements Comparable<Node> {
    int start, end;
    long distance;

    Node(int start, int end, long distance) {
      this.start = start;
      this.end = end;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
      return Long.compare(this.distance, o.distance);
    }
  }
}
