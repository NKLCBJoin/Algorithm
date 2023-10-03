package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1629_곱샘 {
  static int A, B, C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    System.out.println(calculate(A, B));
  }

  static long calculate(int a, int b) {
    if (b == 1) return a % C;
    long temp = calculate(a, b / 2);
    if (b % 2 == 0) return temp * temp % C;
    return (temp * temp % C) * (a % C) % C;
  }
}
