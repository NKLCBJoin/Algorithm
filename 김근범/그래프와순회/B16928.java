package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16928 {

    static boolean[] visited = new boolean[101];
    static HashMap<Integer, Integer> gameRoad = new HashMap<>();
    static Queue<PlayStatus> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            gameRoad.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(findShortestWay());
    }

    private static int findShortestWay(){
        visited[1] = true;
        queue.add(new PlayStatus(1, 0));
        int result = 0;
        while(!queue.isEmpty()){
            PlayStatus status = queue.poll();
            if(status.num==100) {
                result = status.time;
                break;
            }
            for(int i=1;i<=6;i++){
                int nextNum = status.num + i;
                if(nextNum <=100 && !visited[nextNum]){
                    visited[nextNum] = true;
                    if(gameRoad.containsKey(nextNum)){
                        nextNum = gameRoad.get(nextNum);
                        visited[nextNum] = true;
                    }
                    queue.add(new PlayStatus(nextNum, status.time+1));
                }
            }
        }
        return result;
    }

    static class PlayStatus{
        int num;
        int time;

        public PlayStatus(int num, int time){
            this.num = num;
            this.time = time;
        }
    }
}
