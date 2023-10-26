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
    static final int INF = 9900001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCity = Integer.parseInt(st.nextToken()); // 첫 번째 입력을 읽어서 numCity 변수에 저장
        int numBus = Integer.parseInt(br.readLine());
        dist = new int[numCity+1][numCity+1];

        // dist 배열 초기화
        for (int i = 1; i <= numCity; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신으로 가는 거리는 0
        }

        for(int i = 0 ; i < numBus; i++){
            st = new StringTokenizer(br.readLine());
            int start =  Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[start][end] = Math.min(cost, dist[start][end]);
        }

        for(int layover = 1; layover <= numCity; layover++){
            for(int startCity = 1; startCity <= numCity; startCity++){
                if(startCity == layover) continue;
                for(int endCity = 1; endCity <= numCity; endCity++){
                    if(endCity == startCity || endCity == layover) continue;

                    if(dist[startCity][endCity] > dist[startCity][layover] + dist[layover][endCity]){
                        dist[startCity][endCity] =  dist[startCity][layover] + dist[layover][endCity];
                    }
                }
            }
        }

        for(int i = 1 ; i <= numCity; i++){
            for(int j = 1 ; j <= numCity; j++){
                if(dist[i][j] == INF)
                    System.out.print(0);
                else
                    System.out.print(dist[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
