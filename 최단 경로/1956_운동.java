import java.io.*;
import java.util.*;

/*
    플로이드 와셜
    [Time] 삼중 for -> O(n*n*n)
    [form] 인접행렬 ar[1][2] -> (1->2)
    [How]
    for 경유할 곳
        for 시작
            for 도착
                거리 최소 갱신
* */

public class Main {
    static int[][] dist;
    static final int MAX = 999999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCity = Integer.parseInt(st.nextToken()); // 첫 번째 입력을 읽어서 numCity 변수에 저장
        int numBus = Integer.parseInt(st.nextToken());
        dist = new int[numCity+1][numCity+1];

        for(int i = 1 ;i <= numCity; i++){
            for(int j = 1; j <= numCity; j++){
                if(i==j)
                    dist[i][i] = 0;
                else
                    dist[i][j] = MAX;
            }
        }

        for(int i = 0 ; i < numBus; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(dist[s][e] > cost)
                dist[s][e] = cost;
        }

        for(int i = 1; i <= numCity; i++){
            for(int j = 1; j <= numCity; j++){
                for(int k = 1; k <= numCity; k++){
                    if(dist[j][k] > dist[j][i] + dist[i][k])
                        dist[j][k] = dist[j][i] + dist[i][k];
                }
            }
        }

        int minCycle = MAX;
        for(int i = 1 ;i <= numCity; i++){
            for(int j = 1; j <= numCity; j++){
                if(dist[i][j] != MAX && dist[j][i] != MAX &&
                        dist[i][j] > 0 && dist[j][i] > 0){
                    minCycle = Math.min(minCycle, dist[i][j] + dist[j][i]);
                }
            }
        }

        if(minCycle != MAX)
            System.out.print(minCycle);
        else
            System.out.print(-1);

//        for(int i = 1 ;i <= numCity; i++){
//            for(int j = 1; j <= numCity; j++){
//                if(dist[i][j] == 99999999)
//                    System.out.print("X" + " ");
//                else
//                    System.out.print(dist[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
