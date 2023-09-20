package dp;

import java.util.Scanner;

//dp 2579 계단오르기

//계단이 주어지면 합의 최댓 값을 구해야 함
//1칸 or 2칸만 가능, 연속 3번 계단 안됨
//처음 마지막 계단은 무조건

//점화식 세우는게 어렵다



public class dp2579 {
    static Integer dp[];
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
        dp[1] = arr[1];

        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));

    }

    static int find(int N) {
        // 아직 탐색하지 않는 N번째 계단일 경우
        if(dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
        }

        return dp[N];
    }
}
