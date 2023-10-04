package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780 {

    static int[][] paper;
    static int numMinus1 = 0;
    static int num0 = 0;
    static int num1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dividePaper(0, 0, N);
        StringBuilder sb = new StringBuilder().append(numMinus1).append("\n")
                .append(num0).append("\n").append(num1).append("\n");
        System.out.print(sb);
    }

    private static void dividePaper(int startR, int startC, int length){
        if(isAllValueSame(startR, startC, length)) {
            if(paper[startR][startC]==-1) numMinus1++;
            else if(paper[startR][startC]==0) num0++;
            else num1++;
        } else {
            int nextLength = length/3;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    dividePaper(startR+nextLength*i, startC+nextLength*j, nextLength);
                }
            }
        }
    }

    private static boolean isAllValueSame(int startR, int startC, int length) {
        int[] num = new int[3];
        for(int i=startR;i<startR+length;i++){
            for(int j=startC;j<startC+length;j++){
                int value = paper[i][j];
                if(value==-1){
                    num[0]++;
                    if(num[1] >0 || num[2] >0) return false;
                } else if(value ==0){
                    num[1]++;
                    if(num[0]>0 || num[2] >0) return false;
                } else {
                    num[2]++;
                    if(num[0]>0 || num[1] >0) return false;
                }
            }
        }
        return true;
    }
}
