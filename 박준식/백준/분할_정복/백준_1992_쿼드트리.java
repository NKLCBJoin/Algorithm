package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1992_쿼드트리 {
  static int[][] paper;
  static int N;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    paper = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] temp = br.readLine().split("");
      for (int j = 0; j < N; j++) paper[i][j] = Integer.parseInt(temp[j]);
    }

    slice(0, 0, N);

    String temp = sb.toString();
    temp = temp.replace("(0)", "0");
    temp = temp.replace("(1)", "1");
    System.out.println(temp);
  }

  static void slice(int x, int y, int size) {
    sb.append("(");
    int data = paper[x][y];
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (data == paper[i][j]) continue;
        slice(x, y, size / 2);
        slice(x, y + size / 2, size / 2);
        slice(x + size / 2, y, size / 2);
        slice(x + size / 2, y + size / 2, size / 2);
        sb.append(")");
        return;
      }
    }
    sb.append(data);
    sb.append(")");
  }
}
