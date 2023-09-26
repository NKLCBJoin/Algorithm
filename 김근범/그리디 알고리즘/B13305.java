package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distanceList = new int[N-1];
        int[] cityList = new int[N];
        BigInteger result = BigInteger.valueOf(0);
        int minIndex = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            distanceList[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            cityList[i] = Integer.parseInt(st.nextToken());
            if(cityList[i] < cityList[minIndex]) minIndex = i;
            BigInteger temp = new BigInteger(String.valueOf(cityList[minIndex])).multiply(new BigInteger(String.valueOf(distanceList[i])));
            result = result.add(temp);
        }
        System.out.println(result);
    }
}
