package dp;

import java.util.Scanner;

//dp 9184, 신나는 함수 실행

// 문제가 이해가 안되서 블로그 많이 참고함
// dp와 메모이제이션 잘 정리해서 다시 학습해자


public class dp9184 {
    static int[][][] arr = new int[21][21][21];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }

    static int w(int a, int b, int c) {
        // a, b, c가 범위를 벗어나지 않으면서 메모이제이션이 되어있는 경우
        if(inRange(a, b, c) && arr[a][b][c] != 0) {
            return arr[a][b][c];
        }
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {
            return arr[20][20][20] = w(20, 20, 20);
        }
        if(a < b && b < c) {
            return arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    //범위 밖 값을 체크하기 위한 함수
    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
