package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11401 {

    static final int DIVIDER = 1_000_000_007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long result = (factorial(N)*calculateFigma(N, K, DIVIDER-2)) % DIVIDER;
        System.out.println(result);
    }

    private static long factorial(int n){
        long result = 1;
        for(int i=1;i<=n;i++){
            result = result * i % DIVIDER;
        }
        return result;
    }

    private static long calculateFigma(int N, int K, int time){
        if(time==1){
            return factorial(K) * factorial(N-K) % DIVIDER;
        }
        long temp = calculateFigma(N, K, time/2);
        if(time%2==0){
            return temp*temp%DIVIDER;
        } else {
            return temp*temp%DIVIDER*calculateFigma(N, K, 1) % DIVIDER;
        }
    }
}
