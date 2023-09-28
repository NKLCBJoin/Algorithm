package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {

    static int whiteNum = 0;
    static int blueNum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] paper = new boolean[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                paper[i][j] = st.nextToken().equals("1");
            }
        }
        dividePaper(paper, 0, N-1, 0, N-1);
        System.out.println(whiteNum);
        System.out.println(blueNum);
    }

    private static void dividePaper(boolean[][] paper, int rStart, int rEnd, int cStart, int cEnd){
        if(rStart==rEnd) {
            if(paper[rStart][cStart]) blueNum++;
            else whiteNum++;
            return;
        }
        if(checkPaperValueSame(paper, rStart, rEnd, cStart, cEnd)) {
            if(paper[rStart][cStart]) blueNum++;
            else whiteNum++;
        } else {
            int rMid = (rStart+rEnd)/2;
            int cMid = (cStart+cEnd)/2;
            dividePaper(paper, rStart, rMid, cStart, cMid);
            dividePaper(paper, rStart, rMid, cMid+1, cEnd);
            dividePaper(paper,rMid+1, rEnd, cStart, cMid);
            dividePaper(paper, rMid+1, rEnd, cMid+1, cEnd);
        }
    }

    private static boolean checkPaperValueSame(boolean[][] paper, int rStart, int rEnd, int cStart, int cEnd){
        int num1 = 0;
        int num0 = 0;
        for(int i=rStart; i<=rEnd;i++){
            for(int j=cStart; j<=cEnd; j++){
                if(paper[i][j]){
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
