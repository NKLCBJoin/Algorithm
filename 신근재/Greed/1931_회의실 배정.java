import java.io.*;
import java.util.*;

public class Main {
    /*
        같은 시간인데 비효율적인 걸 빼자?
        최대의 회의 -> 짧으면서도 물레가 맞게 돌아가도록?
        -------------------------------
        겹치지 않는 활동에 대해 종료시간이 더 빠르면 더 많은 활동!
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNum = Integer.parseInt(st.nextToken());

        int[][] times = new int[startNum][2];
        for(int i = 0 ; i < startNum; i++){
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1]-o2[1];
            }
        });

        int cnt = 0;
        int curTime= 0;
        for(int i = 0 ; i < startNum; i++){
            if(curTime <= times[i][0]){//시작 : 현 시각 <= 꺼내온 시간의 시작 시간
                curTime = times[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
