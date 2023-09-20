package dp;

import java.util.Scanner;


//[dp]백준 1904 01타일

//타일 증하가하는 모습이 피보나치 수열과 같다  >> arr[n] = arr[n-1] + arr[n-1]

public class dp1904 {
    static int[] dp = new int[10000]; //메모이제이션

    public static int fibonacci(int n) {
        if (n <=2){ //초기값 1, 1
            if(n==0){
                return 0;
            } else if (n==1) {
                return 1;
            } else if (n==2) {
                return 2;
            }
        }
        if (dp[n]!=0){ //값이 0이 아니면 배열에 저장된 값 리턴
            return dp[n];
        }
        dp[n] = fibonacci(n-1) + fibonacci(n-2); //값을 배열에 저장
        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println("타일 수 "+n+"에 대한 경우의 수는 : "+fibonacci(n));

    }
}
