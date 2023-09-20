package dp;

import java.util.*;

//[dp]백준 1932 숫자 삼각형

public class dp1932 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] res = new int[N];
        int max=0;
        int[][] d= new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {

                d[i][j]=scan.nextInt();
                if(j==1) d[i][j] = d[i-1][j] + d[i][j];
                else if (j==i) d[i][j] = d[i-1][j-1] + d[i][j];
                else d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + d[i][j];

                if(max<d[i][j]) max=d[i][j];
            }

        }
        System.out.println(max);
    }

}