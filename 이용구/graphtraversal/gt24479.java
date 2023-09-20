package graphtraversal;

import java.util.*;
import java.io.*;

//그래프 처음 시작 문제
//너무 어려워서 블로그 참고

//https://tussle.tistory.com/715

//[gt] 24479 깊이 우선 탐색 1

// n개 정점 m개 간선으로 구성된 무방향 그래프가 주어진다.
// 정점 1~ n 번
// 간선 가중치 1
// 정점 r 에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우
// 노드의 방문 순서를 출력하자



public class gt24479 {
    static int N,M,R,count=1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	//그래프 저장 리스트
    static boolean[] visited;		//정점 방문 확인 배열
    static int[] result;		//순번 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        //리스트 및 배열 초기화
        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //무방향 그래프
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(R);		//DFS 탐색 시작


        for(int i=1;i<=N;i++)		//순번 저장된 배열 BufferedWriter 저장
            bw.write(result[i] + "\n");
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }

    //DFS으로 시작정점에서 탐색을 시작하는 함수
    static void dfs(int cur) {
        visited[cur] = true;		//방문 확인
        result[cur] = count++;		//방문 순번 저장
        Collections.sort(graph.get(cur));	//인접 정점 오름차순 정렬
        //인접 정점 탐색
        for(Integer value : graph.get(cur)) {
            if(!visited[value]) {	//방문하지 않았을 때
                dfs(value);
            }
        }
        return;
    }
}
