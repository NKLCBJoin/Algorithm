package 백준.최단_경로;

import java.io.*;
import java.util.*;

public class 백준_13549_숨바꼭질_3 {
  static int n;
  static int k;

  static Queue<Integer> queue = new LinkedList<>();
  static int[] time = new int[100001];
  static boolean[] visited = new boolean[100001];

  static void setVisited(int current, int i) {
    if (!visited[current]) queue.add(current);
    else visited[current] = true;
    time[current] = i;
  }

  static int BFS() {
    setVisited(n, 0);
    while (!queue.isEmpty()) {
      int current = queue.remove();
      if (current == k) return time[current];
      if (current - 1 >= 0 && time[current - 1] > time[current]) setVisited(current - 1, time[current] + 1);
      if (current + 1 <= 100000 && time[current + 1] > time[current]) setVisited(current + 1, time[current] + 1);
      if (current * 2 <= 100000 && time[current * 2] > time[current]) setVisited(current * 2, time[current]);
    }
    return Math.abs(n - k);
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    Arrays.fill(time, Integer.MAX_VALUE);
    System.out.println(BFS());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}