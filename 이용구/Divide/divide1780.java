package Divide;

//분할정복 1780 종이의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class divide1780 {
    static private int[][] borad;
    static int n_1=0, n0=0, n1=0;
    private static void func(int n, int b1, int b2) {
        /* 배열안에 같은 값이 들어가있는지 확인하는 부분 */
        boolean isOk = true;
        int a = borad[b1][b2];
        for (int i = b1; i < n+b1; i++) {
            for (int j = b2; j < n+b2; j++) {
                if (a != borad[i][j]) {
                    isOk = false;
                    break;
                }
                a = borad[i][j];
            }
            if (!isOk) break;
        }

        if (!isOk) { //같은 값이 안들어가있다면
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    func(n/3, b1 + i*n/3, b2 + j*n/3); //9분할 코드
                }
            }
        } else {
            if (borad[b1][b2] == 0) n0++;
            else if (borad[b1][b2] == -1) n_1++;
            else if (borad[b1][b2] == 1) n1++;
            return;
        }

    }
    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        borad = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                borad[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(n, 0, 0);
        System.out.println(n_1);
        System.out.println(n0);
        System.out.println(n1);
    }
}