package Divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2630 색종이 만들기
// 재귀로 조각 불러오는 생각
// 너무 어려워서 블로그 참고
// https://st-lab.tistory.com/227

public class divide2630 {
    static int whiteCount,blueCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        whiteCount = 0;
        blueCount = 0;

        for(int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j< n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(arr,0,0,n );
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
    public static void solve(int[][] arr, int x, int y, int n){
        if(check(arr,x,y,n)){
            if(arr[x][y] == 0){
                whiteCount += 1;
            }else if(arr[x][y] == 1){
                blueCount += 1;
            }
            return;
        }

        solve(arr,x,y,n/2);
        solve(arr,x,y + n / 2, n / 2);
        solve(arr,x + n / 2, y, n / 2);
        solve(arr, x + n / 2, y + n / 2, n / 2);

    }

    public static boolean check(int[][] arr, int x, int y, int n){
        int checkNumber = arr[x][y];

        for(int i = x; i< x + n  ; i++){
            for(int j = y; j < y + n ; j++){
                if(arr[i][j] != checkNumber){
                    return false;
                }
            }
        }
        return true;
    }
}