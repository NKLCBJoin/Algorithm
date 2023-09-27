package 백준.그리디_알고리즘;

import java.io.*;
import java.util.*;

public class 백준_1931_회의실_배정 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    Meeting[] meetings = new Meeting[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      meetings[i] = new Meeting(st.nextToken(), st.nextToken());
    }

    Arrays.sort(meetings);
    int count = 0;
    int last = 0;

    for (int i = 0; i < N; i++) {
      if (last > meetings[i].start) continue;
      last = meetings[i].end;
      count++;
    }

    System.out.println(count);
  }
}

class Meeting implements Comparable<Meeting> {
  int start;
  int end;

  Meeting(String start, String end) {
    this.start = Integer.parseInt(start);
    this.end = Integer.parseInt(end);
  }


  @Override
  public int compareTo(Meeting o) {
    return this.end - o.end == 0 ? this.start - o.start : this.end - o.end;
  }
}