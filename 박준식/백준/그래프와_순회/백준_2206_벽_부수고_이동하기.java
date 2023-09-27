package 백준.그래프와_순회;

import java.io.*;
import java.util.*;

public class 백준_2206_벽_부수고_이동하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    int[] map = new int[N * M];

    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split("");
      for (int j = 0; j < M; j++) map[i * M + j] = Integer.parseInt(temp[j]);
    }


    LinkedList<Node> queue = new LinkedList<>();
    boolean[][] visited = new boolean[N * M][2];
    queue.add(new Node(0, 1, 0));
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      if (current.position == N * M - 1) {
        System.out.println(current.distance);
        return;
      }

      int n = current.position / M;
      int m = current.position % M;
      for (int j = 0; j < 4; j++) {
        int dn = n + dx[j];
        int dm = m + dy[j];
        if (dn >= N || dn < 0 || dm >= M || dm < 0) continue;
        if (map[dn * M + dm] == 1) {
          if (current.count == 1 || visited[dn * M + dm][1]) continue;
          visited[dn * M + dm][1] = true;
          queue.add(new Node(dn * M + dm, current.distance + 1, 1));
        } else if (!visited[dn * M + dm][current.count]) {
          visited[dn * M + dm][current.count] = true;
          queue.add(new Node(dn * M + dm, current.distance + 1, current.count));
        }
      }
    }


    System.out.println(-1);
  }
}

class Node {
  int position, distance, count;

  Node(int position, int distance, int count) {
    this.position = position;
    this.distance = distance;
    this.count = count;
  }
}
