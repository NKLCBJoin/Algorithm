package backtracking;

import java.util.*;

//bt 15650 N과 M (2)

// 1 과 다르게 오름차순으로 해야 함

public class bt15650 {
    static int n,m;
    static void dfs(int[] a,boolean[] check,int v,int cnt) {
        if(cnt == m) {
            for(int i=0;i<m;i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println();

            return;
        }

        // 깊이 탐색 시 자신을 전달해 
        // 자신+1 부터 반복하면 자신보다 큰 수만으로 수열을 고려함.
        for(int i=v;i<check.length;i++) {
            if(!check[i]) {
                check[i] = true;
                a[cnt] = i;
                
                dfs(a,check,i+1,cnt+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        int a[] = new int[m];
        boolean check[] = new boolean[n+1];

        dfs(a,check,1,0);

    }
}
