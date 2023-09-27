package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] edge =  new PriorityQueue[N+1];
        PriorityQueue<Integer>[] edge2 = new PriorityQueue[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(edge[n1]==null) edge[n1] = new PriorityQueue<>();
            if(edge[n2]==null) edge[n2] = new PriorityQueue<>();
            if(edge2[n1]==null) edge2[n1] = new PriorityQueue<>();
            if(edge2[n2]==null) edge2[n2] = new PriorityQueue<>();
            edge[n1].add(n2);
            edge[n2].add(n1);
            edge2[n1].add(n2);
            edge2[n2].add(n1);
        }
        dfs(edge, K);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(edge2, K);
        System.out.println(sb);
    }

    static void dfs(PriorityQueue<Integer>[] edge, int K) {
        visited[K] = true;
        sb.append(K).append(" ");
        if(edge[K]==null) return;
        while(!edge[K].isEmpty()) {
            int dest = edge[K].poll();
            if(!visited[dest]) {
                dfs(edge, dest);
            }
        }
    }

    static void bfs(PriorityQueue<Integer>[] edge, int K) {
       visited[K] = true;
       sb.append(K).append(" ");
       if(edge[K]==null) return;
       queue.add(K);
       while(!queue.isEmpty()) {
           int start = queue.poll();
           while(edge[start] != null && !edge[start].isEmpty()){
               int dest = edge[start].poll();
               if(!visited[dest]) {
                   visited[dest] = true;
                   sb.append(dest).append(" ");
                   queue.add(dest);
               }
           }
       }
    }
}
