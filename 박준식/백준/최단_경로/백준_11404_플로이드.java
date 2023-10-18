package 백준.최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_11404_플로이드 {
  static int N, M;
  static long[][] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    distance = new long[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(distance[i], Long.MAX_VALUE);
      distance[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      long C = Long.parseLong(st.nextToken());
      distance[A][B] = Long.min(distance[A][B], C);
    }

    FloydWarshall();

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) sb.append(distance[i][j] == Long.MAX_VALUE ? 0 : distance[i][j]).append(" ");
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static void FloydWarshall() {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (distance[j][i] == Long.MAX_VALUE) continue;
        for (int k = 1; k <= N; k++) {
          if (distance[i][k] == Long.MAX_VALUE) continue;
          distance[j][k] = Long.min(distance[j][i] + distance[i][k], distance[j][k]);
        }
      }
    }
  }
}
