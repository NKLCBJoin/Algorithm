package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992 {

    static StringBuilder sb = new StringBuilder();
    static boolean[][] video;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new boolean[N][N];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                video[i][j] = input.charAt(j)=='1';
            }
        }
        compressVideo(0, 0, N);
        System.out.println(sb);
    }

    private static void compressVideo(int startR, int startC, int length) {
        if(isAllSameValue(startR, startC, length)){
            if(video[startR][startC]) sb.append("1");
            else sb.append("0");
        } else {
            sb.append("(");
            int mid = length/2;
            compressVideo(startR, startC, mid);
            compressVideo(startR, startC+mid,mid);
            compressVideo(startR+mid, startC, mid);
            compressVideo(startR+mid, startC+mid, mid);
            sb.append(")");
        }
    }

    private static boolean isAllSameValue(int startR, int startC, int length){
        int num0 = 0;
        int num1 = 0;
        for(int i=startR; i<startR+length;i++){
            for(int j=startC; j<startC+length;j++){
                if(video[i][j]){
                    num1++;
                    if(num0>0) return false;
                } else {
                    num0++;
                    if(num1>0) return false;
                }
            }
        }
        return true;
    }
}
