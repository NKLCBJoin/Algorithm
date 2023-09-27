package 백준.그리디_알고리즘;

import java.io.*;
import java.util.*;

public class 백준_13305_주유소 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] distance = new long[N - 1];
    long[] price = new long[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N - 1; i++) distance[i] = Long.parseUnsignedLong(st.nextToken());
    st = new StringTokenizer(br.readLine());
    long min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      min = Math.min(min, Long.parseUnsignedLong(st.nextToken()));
      price[i] = min;
    }
    long total = 0;
    for (int i = 0; i < N - 1; i++) total += distance[i] * price[i];
    System.out.println(total);
  }
}
