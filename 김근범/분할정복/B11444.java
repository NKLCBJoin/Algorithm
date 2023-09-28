package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11444 {

    static final int DIVIDER = 1_000_000_007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[][] result = calculateFibonachi(N);
        System.out.println(result[0][1]);
    }

    private static long[][] calculateFibonachi(long n){
        if(n==1){
            return new long[][]{{1,1},{1,0}};
        } else {
            long[][] result = calculateFibonachi(n/2);
            if(n%2==0){
                return calculate(result, result);
            } else {
                return calculate(calculate(result, result), calculateFibonachi(1));
            }
        }
    }

    private static long[][] calculate(long[][] n1, long[][] n2) {
        long[][] result = new long[n1.length][n2[0].length];
        for(int i=0;i<n1.length;i++){
            for(int j=0;j<n2[0].length;j++){
                for(int k=0;k<n1[i].length;k++){
                    result[i][j] = (result[i][j] + (n1[i][k] * n2[k][j]) % DIVIDER) % DIVIDER;
                }
            }
        }
        return result;
    }
}
