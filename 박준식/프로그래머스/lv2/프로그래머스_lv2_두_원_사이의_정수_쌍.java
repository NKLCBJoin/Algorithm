package 프로그래머스.lv2;

public class 프로그래머스_lv2_두_원_사이의_정수_쌍 {
  public long solution(int r1, int r2) {
    long count = 0;

    long r1_2 = (long) r1 * r1;
    long r2_2 = (long) r2 * r2;

    for(int i = 1; i <= r2; i++) {
      long i_2 = (long) i * i;
      long temp1 = (long) Math.ceil(Math.sqrt(r1_2 - i_2));
      long temp2 = (long) Math.floor(Math.sqrt(r2_2 - i_2));
      count += temp2 - temp1 + 1;
    }

    return count * 4;
  }
}
