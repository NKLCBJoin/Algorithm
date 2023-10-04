package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_11444_피보나치_수_6 {
  static long N;
  static long[][] A = {{1, 1}, {1, 0}};
  static int M = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Long.parseLong(br.readLine());

    System.out.println(calculate(A, N)[0][1]);
  }

  static long[][] multiply(long[][] a, long[][] b) {
    long[][] result = new long[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 2; k++) result[i][j] += a[i][k] * b[k][j];
        result[i][j] %= M;
      }
    }
    return result;
  }

  static long[][] calculate(long[][] a, long b) {
    if (b == 1) return a;
    long[][] temp = calculate(a, b / 2);
    if (b % 2 == 0) return multiply(temp, temp);
    return multiply(multiply(temp, temp), A);
  }
}
