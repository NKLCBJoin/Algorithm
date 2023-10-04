package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1780_종이의_개수 {
  static int[][] paper;
  static int N;
  static int zero = 0;
  static int plus = 0;
  static int minus = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) paper[i][j] = Integer.parseInt(st.nextToken());
    }

    slice(0, 0, N);

    System.out.println(minus);
    System.out.println(zero);
    System.out.println(plus);
  }

  static void slice(int x, int y, int size) {
    int color = paper[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (color == paper[i][j]) continue;
        slice(x, y, size / 3);
        slice(x, y + size / 3, size / 3);
        slice(x, y + size * 2 / 3, size / 3);
        slice(x + size / 3, y, size / 3);
        slice(x + size / 3, y + size / 3, size / 3);
        slice(x + size / 3, y + size * 2 / 3, size / 3);
        slice(x + size * 2 / 3, y, size / 3);
        slice(x + size * 2 / 3, y + size / 3, size / 3);
        slice(x + size * 2 / 3, y + size * 2 / 3, size / 3);
        return;
      }
    }
    switch (color) {
      case -1: minus++; break;
      case 0: zero++; break;
      case 1: plus++; break;
    }
  }
}
