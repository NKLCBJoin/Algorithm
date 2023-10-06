import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node>{
        int endNode = 0;
        int weight = 0;

        public Node(int a, int b){
            this.endNode = a;
            this.weight = b;
        }

        @Override
        public int compareTo(Node compNode){
            return this.weight - compNode.weight;
        }
    }

    static int node;
    static int line;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        graph = new ArrayList[node+1];
        dist = new int[node+1];
        int startNode = Integer.parseInt(br.readLine());
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 1; i <= node; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
        }

        leastDist(startNode);

        for(int i = 1 ; i < node+1; i++){
            int p = dist[i];
            if(p == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(p);
        }
    }

    private static void leastDist(int startNode) {
        PriorityQueue<Node> que = new PriorityQueue();
        int[] visited = new int[node+1];
        que.add(new Node(startNode,0));
        dist[startNode] = 0;

        while(!que.isEmpty()){
            Node pollNode = que.poll();
            int cur = pollNode.endNode;

            if(visited[cur] == 1) continue;
            else visited[cur] = 1;

            for(Node curNode : graph[cur]){
                if(dist[curNode.endNode] > dist[cur] + curNode.weight){
                    dist[curNode.endNode] = dist[cur] + curNode.weight;
                    que.add(new Node(curNode.endNode, dist[curNode.endNode]));
                }
            }
        }
    }
}