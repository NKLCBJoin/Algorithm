package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1707 {

    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            LinkedList<Integer>[] edges = new LinkedList[V+1];
            for(int j=0;j<E;j++){
                st  =new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                if(edges[v1]==null) edges[v1] = new LinkedList<>();
                if(edges[v2]==null) edges[v2] = new LinkedList<>();
                edges[v1].add(v2);
                edges[v2].add(v1);
            }
            boolean result = findBipartiteGraph(edges);
            if(result){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean findBipartiteGraph(LinkedList<Integer>[] edges){
        queue.clear();
        boolean[] visited = new boolean[edges.length];
        boolean[] side1 = new boolean[edges.length];
        boolean[] side2 = new boolean[edges.length];
        for(int i=1;i<visited.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            side1[i] = true;
            queue.add(i);
            while(!queue.isEmpty()){
                int start = queue.poll();
                while(edges[start] != null && !edges[start].isEmpty()){
                    int dest = edges[start].poll();
                    if(!visited[dest]){
                        visited[dest] = true;
                        if(side1[start]) side2[dest] = true;
                        else side1[dest] = true;
                        queue.add(dest);
                    } else {
                        if(side1[start] && side1[dest]) return false;
                        if(side2[start] && side2[dest]) return false;
                    }
                }
            }
        }
        return true;
    }
}
