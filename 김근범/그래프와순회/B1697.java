package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {

    static boolean[] visited = new boolean[100001];
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(findPath(N,K));
    }

    private static int findPath(int N , int K) {
        visited[N]= true;
        queue.add(N);
        int result = 0;
        int[] level = new int[100001];
        while(!queue.isEmpty()) {
            int start = queue.poll();
            if(start == K) {
                result = level[start];
                break;
            }
            if(start>0 && !visited[start-1]) {
                queue.add(start-1);
                visited[start-1] = true;
                level[start-1] = level[start] +1;
            }
            if(start<K && !visited[start+1]) {
                queue.add(start+1);
                visited[start+1] = true;
                level[start+1] = level[start] +1;
            }
            if(start<K && start<=50000 && !visited[start*2]) {
                queue.add(start*2);
                visited[start*2] = true;
                level[start*2] = level[start] +1;
            }
        }
        return result;
    }
}
