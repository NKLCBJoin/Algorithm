package backtracking;

import java.util.Scanner;

public class bt15651 {
    static StringBuilder sb = new StringBuilder();

    // n개의 숫자 중 m개를 뽑는 사전식 순열
    public static void permutation(String value, boolean[] visit, int n, int m, int cnt)
    {
        if(cnt==m)
        {
            sb.append(value + "\n");
            return;
        }

        for(int i=1; i<=n ; i++)
        {
            // 첫 번째 값을 넣을 때와 그 외의 경우를 나눠서 value 설정
            if(cnt==0)
            {
                permutation(i + "", visit, n, m, cnt+1);
            }
            else
            {
                permutation(value + " " + i, visit, n, m, cnt+1);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        permutation("", new boolean[n], n, m, 0);
        System.out.println(sb.toString());
        sc.close();
    }
}

