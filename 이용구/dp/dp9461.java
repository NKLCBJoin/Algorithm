package dp;

import java.util.Scanner;

//[dp]9461 파도반 수열

//피보나치랑 다르게 원하는 항의 값의 전전 + 전전전 항이다.
//long type 사용할 것

public class dp9461 {


    static long[] dp = new long[101]; //메모이제이션

    public static long fibonacci(int n) {
        if (n <=3){ //초기값 1, 1
            if(n==0){
                return 0L;
            } else if (n==1) {
                return 1L;
            } else if (n==1) {
                return 1L;
            } else if (n==2) {
                return 1L;

            }
        }

        if (dp[n]!=0){ //값이 0이 아니면 배열에 저장된 값 리턴
            return dp[n];
        }
        dp[n] = fibonacci(n-2) + fibonacci(n-3); //값을 배열에 저장
        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println("파도반 수열 "+n+"의 수는 : "+fibonacci(n));
    }
}
