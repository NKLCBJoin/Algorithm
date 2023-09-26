package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] waitList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            waitList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(waitList);
        int result =0;
        for(int i=1;i<N;i++){
            waitList[i] = waitList[i] + waitList[i-1];
            result+= waitList[i];
        }
        result+=waitList[0];
        System.out.println(result);
    }
}
