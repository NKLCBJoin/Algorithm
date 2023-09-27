import java.io.*;
import java.util.*;

public class Main {
    //즉 빨리 끝나는 사람을 먼저 앞에서 부터 줄 세워서하면 굿?
    //[2,5,1,4,3] 최적의 순서
    //[3,1,4,3,2] 걸리는 시간
    //걸리는 시간 배열을 하나 더 만들까? -> 굳이 일 수도 있음..
    //애초에 걸리는 시간이 짧은 순서대로 어떻게 줄 세울건데 마냥 막 그냥 구할 순 없잖아
    //2차원 배열 형태로 받아서..정렬을 하는데 2번째 인자를 기준으로
    //{0,3} {1,1} {2,4} {3,3} {4,2} -> 첫 인자 : x번 사람 | 둘째 인자 : 걸리는 시간
    //{1,1} {4,2} {0,3} {3,3} {2,4}

    //아니면 각 자 걸리는 시간은 다 더해놓고
    //진행하면서 각 자 시간을 더 더해나가는건?
    //3+1+4+3+2 = 13에다가 1*4 2*3 3*2 3*1 = 4 6 6 3 = 19 어 이거 되네 이렇게할까?

    //아니 생각해보니 굳이 몇 번째 사람인가가 구현에 필요하니?..ㅠㅠ아니잖아 제ㅔㅇ에에발
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int personNum = Integer.parseInt(st.nextToken());
        int[] watingTimes = new int[personNum];
        int leastTime = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < personNum; i++){
            watingTimes[i] = Integer.parseInt(st.nextToken());
            leastTime += watingTimes[i];
        }

        //빨리 끝나는 녀석들 순서를 세우자!
        Arrays.sort(watingTimes);

        //돌면서 시간을 더하자!
        for(int i = 0 ; i < personNum-1; i++){
            leastTime += watingTimes[i] * (personNum-1-i);
        }
        System.out.println(leastTime);
    }
}
