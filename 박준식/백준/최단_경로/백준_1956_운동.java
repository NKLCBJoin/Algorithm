package 백준.최단_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1956_운동 {
  static int N, M;
  static long[][] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    distance = new long[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(distance[i], Long.MAX_VALUE);
      distance[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      long C = Long.parseLong(st.nextToken());
      distance[A][B] = Long.min(distance[A][B], C);
    }

    FloydWarshall();

    Long result = Long.MAX_VALUE;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if(i != j && distance[i][j] != Long.MAX_VALUE && distance[j][i] != Long.MAX_VALUE) {
          result = Long.min(result, distance[i][j] + distance[j][i]);
        }
      }
    }

    System.out.println(result == Long.MAX_VALUE ? -1 : result);
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
