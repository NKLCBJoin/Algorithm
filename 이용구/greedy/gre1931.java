package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


//회의실 배정
//그리디 1931

// 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다.
// 종료시간을 기준으로 정렬하고
// 빨리 끝나는 것을 기준으로 뽑아주기

public class gre1931 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 회의 수
        int n = in.nextInt();
        int cnt = 0;

        int a[][] = new int[n][2];

        for(int i=0;i<n;i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        // 종료시간 기준 정렬
        Arrays.sort(a,new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return Integer.compare(o1[0],o2[0]);

                return Integer.compare(o1[1], o2[1]);
            }

        });

        int end = 0;

        for(int i=0;i<n;i++) {
            // 직전 회의 종료시간 <= 현재 회의 시작시간이면 회의가 가능하므로,
            if(end<=a[i][0]) {
                // 현재 회의의 종료시간을 갱신 후,
                end = a[i][1];
                // 회의 수 증가.
                cnt++;
            }

        }

        System.out.println(cnt);
        in.close();
    }

}