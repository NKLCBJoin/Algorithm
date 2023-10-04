package 백준.분할_정복;

import java.io.*;
import java.util.*;

public class 백준_2630_색종이_만들기 {
  static int[][] paper;
  static int N;

  static int countB = 0;
  static int countW = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) paper[i][j] = Integer.parseInt(st.nextToken());
    }

    slice(0, 0, N);
    System.out.println(countW);
    System.out.println(countB);
  }

  static void slice(int x, int y, int size) {
    int color = paper[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (color == paper[i][j]) continue;
        slice(x, y, size / 2);
        slice(x + size / 2, y, size / 2);
        slice(x, y + size / 2, size / 2);
        slice(x + size / 2, y + size / 2, size / 2);
        return;
      }
    }
    if (color == 1) countB++;
    else countW++;
  }
}
