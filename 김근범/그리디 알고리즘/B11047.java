package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        for(int i=0;i<N;i++){
            coin[N-1-i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        for(int i=0;i<N;i++){
            int amount = K/coin[i];
            result+= amount;
            K-=amount*coin[i];
        }
        System.out.println(result);
    }
}
