package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B24444 {

    static int[] visited;
    static int order = 1;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        PriorityQueue<Integer>[] edge = new PriorityQueue[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(edge[n1]==null) edge[n1] = new PriorityQueue<>();
            if(edge[n2]==null) edge[n2] = new PriorityQueue<>();
            edge[n1].add(n2);
            edge[n2].add(n1);
        }
        bfs(edge, R);
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<visited.length;i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(PriorityQueue<Integer>[] edge, int R) {
        visited[R] = order++;
        queue.add(R);
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            while(edge[vertex] !=null && !edge[vertex].isEmpty()) {
                int v = edge[vertex].poll();
                if(visited[v]==0){
                    visited[v] = order++;
                    queue.add(v);
                }
            }
        }
    }
}
