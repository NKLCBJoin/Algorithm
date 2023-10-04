package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11401_이항_계수_3 {
  static int N, K;
  static int M = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    long a = factorial(N);
    long b = factorial(K) * factorial(N - K) % M;

    System.out.println(a * calculate(b, M - 2) % M);
  }

  static long calculate(long a, long b) {
    if (b == 1) return a % M;
    long temp = calculate(a, b / 2);
    if (b % 2 == 0) return temp * temp % M;
    return temp * temp % M * a % M;
  }

  static long factorial(long n) {
    long result = 1;
    for (long i = n; i > 1; i--) result = (result * i) % M;
    return result;
  }
}
