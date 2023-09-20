package graphtraversal;

//bt 2606 바이러스

//입력 : 컴터 수, 연결된 번호 쌍
//출력 : 감염된 컴터 수

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class gt2606 {
    private static int[][] gt;
    private static boolean[] visit;


    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        gt = new int[N][N];
        visit = new boolean[N];

        int pair = Integer.parseInt(reader.readLine());

        for(int i=0 ; i<pair ; i++){
            String[] input = reader.readLine().split(" ");
            gt[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1;
            gt[Integer.parseInt(input[1])-1][Integer.parseInt(input[0])-1] = 1;
        }

        dfs(0); // 1번 컴퓨터를 통해 웜 바이러스가 전파

        int count = 0;
        for (boolean aVisit : visit) {
            if (aVisit) {
                count++; // 바이러스에 걸리게 되는 컴퓨터 수 계산
            }
        }

        System.out.println(count-1); // 1번 컴퓨터 제외
    }

    private static void dfs(int computer){
        visit[computer] = true; // 바이러스 감염

        for(int i=0 ; i<visit.length ; i++){
            if(gt[computer][i]==1 && !visit[i]){ // 감염된 컴퓨터와 연결된 컴퓨터가 감염되지 않았다면
                dfs(i);
            }
        }
    }
}

