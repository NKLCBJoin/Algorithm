package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B2606 {

    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfComputers = Integer.parseInt(br.readLine());
        int numOfConnections = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] connections = new LinkedList[numOfComputers+1];
        visited = new boolean[numOfComputers+1];
        StringTokenizer st;
        for(int i=0;i<numOfConnections;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(connections[from]==null) connections[from] = new LinkedList<>();
            if(connections[to]==null) connections[to] = new LinkedList<>();
            connections[from].add(to);
            connections[to].add(from);
        }
        dfs(connections, 1);
        int count =0;
        for(int i=1;i<visited.length;i++){
            if(visited[i]) {
                count++;
            }
        }
        System.out.println(count-1);
    }

    private static void dfs(LinkedList<Integer>[] connections, int loc) {
        visited[loc] = true;
        if(connections[loc]==null) return;
        for(int i=0;i<connections[loc].size();i++){
            int dest = connections[loc].get(i);
            if(!visited[dest]) {
                visited[dest] = true;
                dfs(connections, dest);
            }
        }
    }
}
