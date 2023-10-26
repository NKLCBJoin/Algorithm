import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        //x + n
        //x * 2
        //x * 3
        //=> BFS를 이용해서 풀자
        int[] visited = new int[1000001];
        //BFS는 큐를 이용해서 푼다!
        List<Integer> que = new ArrayList<>();
        que.add(x);
        visited[x] = 1;

        //큐가 안 비어있으면 계속!
        while(!que.isEmpty()){
            int curSize = que.size();
            for(int i = 0 ; i < curSize; i++){
                int cur = que.remove(0);
                int[] curCalcu = {cur + n, cur*2, cur*3};
                //3공간 이동
                for(int j = 0; j < 3; j++){
                    if(curCalcu[j] > 0 && curCalcu[j] < 1000001 && visited[curCalcu[j]] == 0){
                        que.add(curCalcu[j]);
                        visited[curCalcu[j]] = visited[cur] + 1;
                    }

                    if(visited[y] > 0)
                        return visited[y]-1;
                }
            }
        }
        return -1;
    }
}