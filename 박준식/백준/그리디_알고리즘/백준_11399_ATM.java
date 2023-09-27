package 백준.그리디_알고리즘;

import java.io.*;
import java.util.*;

public class 백준_11399_ATM {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) queue.add(Integer.parseInt(st.nextToken()));

    int total = 0;
    for (int i = 1; i <= N; i++) total += queue.poll() * i;

    System.out.println(total);
  }
}
