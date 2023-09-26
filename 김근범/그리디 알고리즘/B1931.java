package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] timeTableList = new long[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            timeTableList[i][0] = Long.parseLong(st.nextToken());
            timeTableList[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(timeTableList, (t1, t2) -> {
           if(t1[1]==t2[1]) return Long.compare(t1[0], t2[0]);
           else return Long.compare(t1[1], t2[1]);
        });
        int count = 0;
        long endTime = 0;
        for(int i=0;i<N;i++){
            if(endTime<=timeTableList[i][0]) {
                endTime = timeTableList[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
