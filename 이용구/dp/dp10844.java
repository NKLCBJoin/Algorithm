package dp;

import java.util.*;

//dp 10844 쉬운 계단수

//dp[자릿수][자릿값]

// 와 ㅋ
// dp[3][5] = dp[2][4] + dp[2][6]
// 5xx = 54x , 56x

//dp[i][0] = dp[i-1][1]
//dp[i][9] = dp[i-1][8]
//dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]



// 블로그 코드
public class dp10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //1차원: 자리수(n), 2차원: 맨 오른쪽 숫자(0~9), 값은 개수가 들어간다
        int[][] dp = new int[n+1][10];
        //0을 제외한 한자리수 숫자는 자기 자신밖에 없으므로 1로 초기화
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        //2~n 자리수 까지 맨 오른쪽 숫자가 0~9일때의 값을 저장한다
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                //맨 오른쪽 숫자가 0일땐 그 전 자리수가 1로 끝날때 밖에 없음
                if (j==0) dp[i][0] = dp[i-1][1];
                    //맨 오른쪽 숫자가 9일떈 그 전 자리수가 8로 끝날때 밖에 없음
                else if (j==9) dp[i][9] = dp[i-1][8];
                    //그 전 자리수의 j-1에 +1한 값, j+1에 -1한값의 개수
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                dp[i][j] %= 1000000000;
            }
        }
        //n 자리수 일때 모든 계단수
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[n][i];
            result %= 1000000000;
        }
        System.out.println(result % 1000000000);
    }
}
