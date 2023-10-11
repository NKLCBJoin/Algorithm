package backtracking;
//[backtracking]백준 15642 N과 M (1)
// 백트레킹 가장 기초 개념 문제이니 확실하게 정리하자

import java.util.Scanner;
public class bt15649 {
    static int N;
    static int M;
    static boolean[] isVisited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isVisited = new boolean[N + 1];
        arr = new int[N + 1];
        dfs(1);

    }

    //current 현재 자리수
    //
    static void dfs(int cur) {
        if (cur > M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            arr[cur] = i;
            dfs(cur + 1);
            isVisited[i] = false;
        }
    }

}
