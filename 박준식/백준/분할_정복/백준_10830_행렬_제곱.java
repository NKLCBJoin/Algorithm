package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_10830_행렬_제곱 {
  static int N;
  static long B;
  static int M = 1000;

  static int[][] A, C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    B = Long.parseLong(st.nextToken());
    A = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken()) % M;
      }
    }

    C = calculate(A, B);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) sb.append(C[i][j]).append(" ");
      sb.append("\n");
    }

    System.out.println(sb);
  }

  static int[][] multiply(int[][] n, int[][] m) {
    int[][] result = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) result[i][j] += n[i][k] * m[k][j];
        result[i][j] %= M;
      }
    }
    return result;
  }

  static int[][] calculate(int[][] a, long b) {
    if (b == 1) return a;
    int[][] temp = calculate(a, b / 2);
    if (b % 2 == 0) return multiply(temp, temp);
    return multiply(multiply(temp, temp), A);
  }
}
