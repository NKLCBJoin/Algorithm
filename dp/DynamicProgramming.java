package dp;

//피보나치 수열
//동빈나 유튜브 참고하여 만들기

//큰 문제를 작은 문제로 나눌 수 있다.
//작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일합니다.

//계산 결과 저장 > 메모이제이션

//dp[n]의 값은 최댓값을 구함. n-2, n-3 + arr[n-1]
// 재귀호출을 할 것인데.

public class DynamicProgramming {

    static int[] dp = new int[100]; //메모이제이션

    public static int fibonacci(int n) {
        if (n <=1){ //초기값 1, 1
            return n;
        }
        if (dp[n]!=0){ //값이 0이 아니면 배열에 저장된 값 리턴
            return dp[n];
        }
        dp[n] = fibonacci(n-1) + fibonacci(n-2); //값을 배열에 저장
        return dp[n];
    }

    public static void main(String[] args) {
        int n =10;
        System.out.println("피보나치 "+n+"는 : "+fibonacci(n));
    }
}
