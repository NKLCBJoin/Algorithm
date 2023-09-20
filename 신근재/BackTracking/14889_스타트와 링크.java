import java.io.*;
import java.util.*;

//1시간 정도 고민하다가 답지 참고
public class Main {
    static int n;
    static int[][] abillitys;
    static int min = Integer.MAX_VALUE;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        abillitys = new int[n][n];
        visited = new int[n];

        //입력 받기
        for (int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < n; j++){
                abillitys[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSquad(0,0);
        System.out.println(min);
    }

    private static void makeSquad(int depth, int value) {
        if (depth == n/2){
            getDiff();
            return;
        }

        for(int i = value; i < n ; i++){
            visited[i] = 1;
            makeSquad(depth+1, i+1);
            visited[i] = 0;
        }
    }

    private static void getDiff() {
        int start = 0;
        int link = 0;

        for(int i = 0 ; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(visited[i] == 1 && visited[j] == 1){//start팀일 경우
                    start += abillitys[i][j];
                    start += abillitys[j][i];
                }
                else if(visited[i] == 0 && visited[j] == 0){//link팀일 경우
                    link += abillitys[i][j];
                    link += abillitys[j][i];
                }
            }
        }

        //팀 계산을 완료되면 최소 구하고
        int val = Math.abs(start-link);

        //가장 근접하는 건 0이니까 0 나오면 그냥 바로 종료~
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(min,val);
    }
}
