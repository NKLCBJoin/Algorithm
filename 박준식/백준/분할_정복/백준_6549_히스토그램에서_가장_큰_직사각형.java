package 백준.분할_정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_6549_히스토그램에서_가장_큰_직사각형 {
  static int N;
  static long[] histogram;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      if (N == 0) break;
      histogram = new long[N];
      for (int i = 0; i < N; i++) histogram[i] = Long.parseLong(st.nextToken());
      sb.append(calculate(0, N - 1)).append('\n');
    }
    System.out.println(sb);
  }

  static long calculate(int low, int high) {
    if (low == high) return histogram[low];
    int mid = (low + high) / 2;
    long max = Math.max(calculate(low, mid), calculate(mid + 1, high));
    return Math.max(max, calculateMid(low, high));
  }

  static long calculateMid(int low, int high) {
    int mid = (low + high) / 2;
    int left = mid;
    int right = mid;

    long height = histogram[mid];
    long max = height;

    while (low < left && right < high) {
      if (histogram[left - 1] < histogram[right + 1]) height = Math.min(height, histogram[++right]);
      else height = Math.min(height, histogram[--left]);
      max = Math.max(max, height * (right - left + 1));
    }

    while (right < high) {
      height = Math.min(height, histogram[++right]);
      max = Math.max(max, height * (right - left + 1));
    }

    while (low < left) {
      height = Math.min(height, histogram[--left]);
      max = Math.max(max, height * (right - left + 1));
    }

    return max;
  }
}
