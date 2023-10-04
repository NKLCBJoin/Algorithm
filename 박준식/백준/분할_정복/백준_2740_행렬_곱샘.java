package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2740_행렬_곱샘 {
  static int N, M, K;

  static int[][] A, B, C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    B = new int[M][K];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < K; j++) B[i][j] = Integer.parseInt(st.nextToken());
    }

    C = new int[N][K];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K; j++) C[i][j] = calculate(i, j);
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < K; j++) sb.append(C[i][j]).append(" ");
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static int calculate(int n, int m) {
    int result = 0;
    for (int i = 0; i < M; i++) result += A[n][i] * B[i][m];
    return result;
  }
}
