package dp;

import java.util.Scanner;
//아아아아 개어려워 이게 왜 쉽냐 sibar

//연속된 숫자 중에서 더한 값이 가장 크게 나오게 처리한다.
// 조건 - 연속된 수를 선택해서 구할 수 있는 가장 큰 합;;; 하 sibar
// 조건 - 한 개 이상임

//메모이제이션 = 이전까지 탐색했던 값과 현재 위치의 값을 비교하여 큰 값을 저장

// 근까 이전 탐색값 (비교) 현재 값


public class dp1912 {
    static int[] arr;		// 배열
    static Integer[] dp;		// 메모이제이션 할 dp
    static int max;			// 최댓값 변수

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        arr = new int[N];
        dp = new Integer[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        //초기값 초기화
        dp[0] = arr[0];
        max = arr[0];

        // dp의 마지막 index는 N-1이므로 N-1부터 Top-Down 탐색
        recur(N - 1);

        System.out.println(max);
    }

    static int recur(int N) {

        // 탐색하지 않은 인덱스라면
        if(dp[N] == null) {
            dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);

            // 해당 dp[N]과 max 중 큰 값으로 max 갱신
            max = Math.max(dp[N], max);
        }

        return dp[N];
    }
}
