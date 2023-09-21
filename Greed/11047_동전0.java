import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int won = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int coinNum = 0;

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        for(int i = 0 ; i < n; i++){
            if (coins[i] <= won) { // 등호 추가
                startIdx = i;
            } else {
                break; // 동전 가치가 K보다 크면 더 이상 검사할 필요가 없음
            }
        }

        while(won > 0){
            //System.out.println(won);
            if(won - coins[startIdx] >= 0) {
                won -= coins[startIdx];
                coinNum++;
            }
            else if(won - coins[startIdx] < 0)
                startIdx--;
        }
        System.out.print(coinNum);
    }
}
