package Divide;
import java.io.*;

//백준 1992 쿼드트리
// 백준 2630 색종이 참고 해서 풀어보기
//



public class divide1992 {

    static int[][] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr= new int[N][N];
        for(int i=0;i<N;i++) {
            String[] str = br.readLine().split("");
            for(int j=0;j<N;j++) {
                arr[i][j]=Integer.parseInt(str[j]);
            }
        }

        quad(0,0,N);	//전체를 확인
        System.out.println(sb);
    }// main()

    static void quad(int startX,int startY,int len) {
        if(check(startX,startY,len)) {	//모두 같은 수로 이루어져 있으면
            sb.append(arr[startX][startY]);	//해당 수를 출력
            return;
        }

        len /=2;	//사이즈를 점차 반으로 줄여가면서 확인
        sb.append("(");	//압축의 시작
        //왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순으로
        quad(startX,startY,len);
        quad(startX,startY+len,len);
        quad(startX+len,startY,len);
        quad(startX+len,startY+len,len);
        sb.append(")");	//압축의 끝

    }//quad()

    public static boolean check(int x, int y,int len){
        for(int i=x;i<x+len;i++){
            for(int j=y;j<y+len;j++){
                if(arr[x][y]!=arr[i][j])    return false;
            }
        }
        return true;
    }//check()

}// class Main
