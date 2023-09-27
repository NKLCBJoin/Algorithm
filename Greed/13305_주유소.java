import java.io.*;
import java.util.*;

public class Main {
    /*
        가장 오른쪽 도시까지 가기 위한 최소 비용
        - 현재 기준 오른쪽 도시에 가기 위한 km
        - 현 가격 vs 다음 도시 가격 측정

        => 현재 가격이 다다다다다음꺼보다도 더 쌀 수도 있다!
        => 즉 한 번의 측정이 이~~~~후에 영향을 미칠 가능성!
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityNum = Integer.parseInt(st.nextToken());
        int[] distance = new int[cityNum-1];
        int[] literPrice = new int[cityNum];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < cityNum-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < cityNum; i++){
            literPrice[i] = Integer.parseInt(st.nextToken());
        }

        long price = 0;
        int i = 0;
        long curResonablePrice = literPrice[0];
        while(true){
            if(i == cityNum-1) break;

            if(curResonablePrice >= literPrice[i+1]){
                //현재 가격이 더 높아서(비효율) 일단 다음 곳까지만 주유하고 가자!
                price += curResonablePrice * distance[i];
                curResonablePrice = literPrice[i+1];
                i++;
            }
            else{
                //현재 가격이 더 낮다 => curResonable유지
                price += curResonablePrice * distance[i];
                i++;
            }
        }
        System.out.println(price);
    }
}
