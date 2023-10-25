package 프로그래머스.lv2;

public class 프로그래머스_lv2_연속된_부분_수열의_합 {
  public int[] solution(int[] sequence, int k) {
    int start = 0;
    int sum = 0;

    int left = 0;
    int right = sequence.length - 1;

    for(int end = 0; end < sequence.length; end++) {
      sum += sequence[end];
      while(sum > k) sum -= sequence[start++];
      if(sum == k) {
        if(right - left > end - start) {
          left = start;
          right = end;
        }
      }
    }

    return new int[]{left, right};
  }
}
